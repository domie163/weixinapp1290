package com.dao;

import com.entity.DongwuYuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.DongwuYuyueView;

/**
 * 求助报名 Dao 接口
 *
 * @author 
 */
public interface DongwuYuyueDao extends BaseMapper<DongwuYuyueEntity> {

   List<DongwuYuyueView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
