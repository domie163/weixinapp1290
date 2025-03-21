package com.dao;

import com.entity.DongwuCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.DongwuCollectionView;

/**
 * 求助收藏 Dao 接口
 *
 * @author 
 */
public interface DongwuCollectionDao extends BaseMapper<DongwuCollectionEntity> {

   List<DongwuCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
