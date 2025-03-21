
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 动物求助
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/dongwu")
public class DongwuController {
    private static final Logger logger = LoggerFactory.getLogger(DongwuController.class);

    private static final String TABLE_NAME = "dongwu";

    @Autowired
    private DongwuService dongwuService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private ChongwuService chongwuService;//寻宠
    @Autowired
    private ChongwuCollectionService chongwuCollectionService;//寻宠收藏
    @Autowired
    private ChongwuLiuyanService chongwuLiuyanService;//寻宠留言
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private DongwuCollectionService dongwuCollectionService;//求助收藏
    @Autowired
    private DongwuLiuyanService dongwuLiuyanService;//求助留言
    @Autowired
    private DongwuYuyueService dongwuYuyueService;//求助报名
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private NewsService newsService;//公告通知
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        params.put("dongwuDeleteStart",1);params.put("dongwuDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = dongwuService.queryPage(params);

        //字典表数据转换
        List<DongwuView> list =(List<DongwuView>)page.getList();
        for(DongwuView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        DongwuEntity dongwu = dongwuService.selectById(id);
        if(dongwu !=null){
            //entity转view
            DongwuView view = new DongwuView();
            BeanUtils.copyProperties( dongwu , view );//把实体数据重构到view中
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(dongwu.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody DongwuEntity dongwu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,dongwu:{}",this.getClass().getName(),dongwu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            dongwu.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<DongwuEntity> queryWrapper = new EntityWrapper<DongwuEntity>()
            .eq("dongwu_name", dongwu.getDongwuName())
            .eq("dongwu_types", dongwu.getDongwuTypes())
            .eq("yonghu_id", dongwu.getYonghuId())
            .eq("qiuzhuzhuangtai_types", dongwu.getQiuzhuzhuangtaiTypes())
            .eq("dongwu_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DongwuEntity dongwuEntity = dongwuService.selectOne(queryWrapper);
        if(dongwuEntity==null){
            dongwu.setDongwuClicknum(1);
            dongwu.setDongwuDelete(1);
            dongwu.setInsertTime(new Date());
            dongwu.setCreateTime(new Date());
            dongwuService.insert(dongwu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody DongwuEntity dongwu, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,dongwu:{}",this.getClass().getName(),dongwu.toString());
        DongwuEntity oldDongwuEntity = dongwuService.selectById(dongwu.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            dongwu.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(dongwu.getDongwuPhoto()) || "null".equals(dongwu.getDongwuPhoto())){
                dongwu.setDongwuPhoto(null);
        }
        if("".equals(dongwu.getDongwuContent()) || "null".equals(dongwu.getDongwuContent())){
                dongwu.setDongwuContent(null);
        }

            dongwuService.updateById(dongwu);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<DongwuEntity> oldDongwuList =dongwuService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<DongwuEntity> list = new ArrayList<>();
        for(Integer id:ids){
            DongwuEntity dongwuEntity = new DongwuEntity();
            dongwuEntity.setId(id);
            dongwuEntity.setDongwuDelete(2);
            list.add(dongwuEntity);
        }
        if(list != null && list.size() >0){
            dongwuService.updateBatchById(list);
        }

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<DongwuEntity> dongwuList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            DongwuEntity dongwuEntity = new DongwuEntity();
//                            dongwuEntity.setDongwuName(data.get(0));                    //求助名称 要改的
//                            dongwuEntity.setDongwuPhoto("");//详情和图片
//                            dongwuEntity.setDongwuTypes(Integer.valueOf(data.get(0)));   //求助类型 要改的
//                            dongwuEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            dongwuEntity.setDongwuClicknum(Integer.valueOf(data.get(0)));   //求助热度 要改的
//                            dongwuEntity.setDongwuContent("");//详情和图片
//                            dongwuEntity.setQiuzhuzhuangtaiTypes(Integer.valueOf(data.get(0)));   //求助状态 要改的
//                            dongwuEntity.setDongwuDelete(1);//逻辑删除字段
//                            dongwuEntity.setInsertTime(date);//时间
//                            dongwuEntity.setCreateTime(date);//时间
                            dongwuList.add(dongwuEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        dongwuService.insertBatch(dongwuList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }



    /**
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<DongwuView> returnDongwuViewList = new ArrayList<>();

        //查看收藏
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        params1.put("shangxiaTypes",1);
        params1.put("dongwuYesnoTypes",2);
        PageUtils pageUtils = dongwuCollectionService.queryPage(params1);
        List<DongwuCollectionView> collectionViewsList =(List<DongwuCollectionView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(DongwuCollectionView collectionView:collectionViewsList){
            Integer dongwuTypes = collectionView.getDongwuTypes();
            if(typeMap.containsKey(dongwuTypes)){
                typeMap.put(dongwuTypes,typeMap.get(dongwuTypes)+1);
            }else{
                typeMap.put(dongwuTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("dongwuTypes",type);
            params2.put("shangxiaTypes",1);
            params2.put("dongwuYesnoTypes",2);
            PageUtils pageUtils1 = dongwuService.queryPage(params2);
            List<DongwuView> dongwuViewList =(List<DongwuView>)pageUtils1.getList();
            returnDongwuViewList.addAll(dongwuViewList);
            if(returnDongwuViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        params.put("shangxiaTypes",1);
        params.put("dongwuYesnoTypes",2);
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = dongwuService.queryPage(params);
        if(returnDongwuViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnDongwuViewList.size();//要添加的数量
            List<DongwuView> dongwuViewList =(List<DongwuView>)page.getList();
            for(DongwuView dongwuView:dongwuViewList){
                Boolean addFlag = true;
                for(DongwuView returnDongwuView:returnDongwuViewList){
                    if(returnDongwuView.getId().intValue() ==dongwuView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnDongwuViewList.add(dongwuView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnDongwuViewList = returnDongwuViewList.subList(0, limit);
        }

        for(DongwuView c:returnDongwuViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnDongwuViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = dongwuService.queryPage(params);

        //字典表数据转换
        List<DongwuView> list =(List<DongwuView>)page.getList();
        for(DongwuView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        DongwuEntity dongwu = dongwuService.selectById(id);
            if(dongwu !=null){

                //点击数量加1
                dongwu.setDongwuClicknum(dongwu.getDongwuClicknum()+1);
                dongwuService.updateById(dongwu);

                //entity转view
                DongwuView view = new DongwuView();
                BeanUtils.copyProperties( dongwu , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(dongwu.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody DongwuEntity dongwu, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,dongwu:{}",this.getClass().getName(),dongwu.toString());
        Wrapper<DongwuEntity> queryWrapper = new EntityWrapper<DongwuEntity>()
            .eq("dongwu_name", dongwu.getDongwuName())
            .eq("dongwu_types", dongwu.getDongwuTypes())
            .eq("yonghu_id", dongwu.getYonghuId())
            .eq("dongwu_clicknum", dongwu.getDongwuClicknum())
            .eq("qiuzhuzhuangtai_types", dongwu.getQiuzhuzhuangtaiTypes())
            .eq("dongwu_delete", dongwu.getDongwuDelete())
//            .notIn("dongwu_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DongwuEntity dongwuEntity = dongwuService.selectOne(queryWrapper);
        if(dongwuEntity==null){
            dongwu.setDongwuClicknum(1);
            dongwu.setDongwuDelete(1);
            dongwu.setInsertTime(new Date());
            dongwu.setCreateTime(new Date());
        dongwuService.insert(dongwu);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

