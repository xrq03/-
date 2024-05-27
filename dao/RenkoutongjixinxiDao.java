package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.LoufangxinxiEntity;
import com.entity.RenkoutongjixinxiEntity;
import com.entity.view.LoufangxinxiView;
import com.entity.view.RenkoutongjixinxiView;
import com.entity.vo.LoufangxinxiVO;
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
public interface RenkoutongjixinxiDao extends BaseMapper<RenkoutongjixinxiEntity> {
	
	List<RenkoutongjixinxiVO> selectListVO(@Param("ew") Wrapper<RenkoutongjixinxiEntity> wrapper);

	RenkoutongjixinxiVO selectVO(@Param("ew") Wrapper<RenkoutongjixinxiEntity> wrapper);
	
	List<RenkoutongjixinxiView> selectListView(@Param("ew") Wrapper<RenkoutongjixinxiEntity> wrapper);

	List<RenkoutongjixinxiView> selectListView(Pagination page, @Param("ew") Wrapper<RenkoutongjixinxiEntity> wrapper);
	
	RenkoutongjixinxiView selectView(@Param("ew") Wrapper<RenkoutongjixinxiEntity> wrapper);
	

}
