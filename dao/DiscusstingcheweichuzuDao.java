package com.dao;

import com.entity.DiscusstingcheweichuzuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusstingcheweichuzuVO;
import com.entity.view.DiscusstingcheweichuzuView;


/**
 * 停车位出租评论表
 * 
 * @author 
 * @email 
 * @date 2022-04-11 15:24:59
 */
public interface DiscusstingcheweichuzuDao extends BaseMapper<DiscusstingcheweichuzuEntity> {
	
	List<DiscusstingcheweichuzuVO> selectListVO(@Param("ew") Wrapper<DiscusstingcheweichuzuEntity> wrapper);
	
	DiscusstingcheweichuzuVO selectVO(@Param("ew") Wrapper<DiscusstingcheweichuzuEntity> wrapper);
	
	List<DiscusstingcheweichuzuView> selectListView(@Param("ew") Wrapper<DiscusstingcheweichuzuEntity> wrapper);

	List<DiscusstingcheweichuzuView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusstingcheweichuzuEntity> wrapper);
	
	DiscusstingcheweichuzuView selectView(@Param("ew") Wrapper<DiscusstingcheweichuzuEntity> wrapper);
	

}
