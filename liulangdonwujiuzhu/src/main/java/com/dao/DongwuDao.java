package com.dao;

import com.entity.DongwuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.DongwuView;

/**
 * 动物求助 Dao 接口
 *
 * @author 
 */
public interface DongwuDao extends BaseMapper<DongwuEntity> {

   List<DongwuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
