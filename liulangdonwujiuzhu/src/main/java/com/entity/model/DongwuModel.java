package com.entity.model;

import com.entity.DongwuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 动物求助
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class DongwuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 求助名称
     */
    private String dongwuName;


    /**
     * 求助照片
     */
    private String dongwuPhoto;


    /**
     * 求助类型
     */
    private Integer dongwuTypes;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 求助热度
     */
    private Integer dongwuClicknum;


    /**
     * 求助详情
     */
    private String dongwuContent;


    /**
     * 求助状态
     */
    private Integer qiuzhuzhuangtaiTypes;


    /**
     * 逻辑删除
     */
    private Integer dongwuDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow homeMain
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：求助名称
	 */
    public String getDongwuName() {
        return dongwuName;
    }


    /**
	 * 设置：求助名称
	 */
    public void setDongwuName(String dongwuName) {
        this.dongwuName = dongwuName;
    }
    /**
	 * 获取：求助照片
	 */
    public String getDongwuPhoto() {
        return dongwuPhoto;
    }


    /**
	 * 设置：求助照片
	 */
    public void setDongwuPhoto(String dongwuPhoto) {
        this.dongwuPhoto = dongwuPhoto;
    }
    /**
	 * 获取：求助类型
	 */
    public Integer getDongwuTypes() {
        return dongwuTypes;
    }


    /**
	 * 设置：求助类型
	 */
    public void setDongwuTypes(Integer dongwuTypes) {
        this.dongwuTypes = dongwuTypes;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：求助热度
	 */
    public Integer getDongwuClicknum() {
        return dongwuClicknum;
    }


    /**
	 * 设置：求助热度
	 */
    public void setDongwuClicknum(Integer dongwuClicknum) {
        this.dongwuClicknum = dongwuClicknum;
    }
    /**
	 * 获取：求助详情
	 */
    public String getDongwuContent() {
        return dongwuContent;
    }


    /**
	 * 设置：求助详情
	 */
    public void setDongwuContent(String dongwuContent) {
        this.dongwuContent = dongwuContent;
    }
    /**
	 * 获取：求助状态
	 */
    public Integer getQiuzhuzhuangtaiTypes() {
        return qiuzhuzhuangtaiTypes;
    }


    /**
	 * 设置：求助状态
	 */
    public void setQiuzhuzhuangtaiTypes(Integer qiuzhuzhuangtaiTypes) {
        this.qiuzhuzhuangtaiTypes = qiuzhuzhuangtaiTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getDongwuDelete() {
        return dongwuDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setDongwuDelete(Integer dongwuDelete) {
        this.dongwuDelete = dongwuDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：录入时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow homeMain
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow homeMain
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
