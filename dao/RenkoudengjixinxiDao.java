package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.RenkoudengjixinxiEntity;
import com.entity.RenkoutongjixinxiEntity;
import com.entity.view.RenkoudengjixinxiView;
import com.entity.view.RenkoutongjixinxiView;
import com.entity.vo.RenkoudengjixinxiVO;
import com.entity.vo.RenkoutongjixinxiVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 租房信息
 * 
 * @author 
 * @email 
 * @date 2022-04-11 15:24:59
 */
public interface RenkoudengjixinxiDao extends BaseMapper<RenkoudengjixinxiEntity> {
	
	List<RenkoudengjixinxiVO> selectListVO(@Param("ew") Wrapper<RenkoudengjixinxiEntity> wrapper);

	RenkoudengjixinxiVO selectVO(@Param("ew") Wrapper<RenkoudengjixinxiEntity> wrapper);
	
	List<RenkoudengjixinxiView> selectListView(@Param("ew") Wrapper<RenkoudengjixinxiEntity> wrapper);

	List<RenkoudengjixinxiView> selectListView(Pagination page, @Param("ew") Wrapper<RenkoudengjixinxiEntity> wrapper);
	
	RenkoudengjixinxiView selectView(@Param("ew") Wrapper<RenkoudengjixinxiEntity> wrapper);
	

}
