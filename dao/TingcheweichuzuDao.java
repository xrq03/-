package com.dao;

import com.entity.TingcheweichuzuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.TingcheweichuzuVO;
import com.entity.view.TingcheweichuzuView;


/**
 * 停车位出租
 * 
 * @author 
 * @email 
 * @date 2022-04-11 15:24:59
 */
public interface TingcheweichuzuDao extends BaseMapper<TingcheweichuzuEntity> {
	
	List<TingcheweichuzuVO> selectListVO(@Param("ew") Wrapper<TingcheweichuzuEntity> wrapper);
	
	TingcheweichuzuVO selectVO(@Param("ew") Wrapper<TingcheweichuzuEntity> wrapper);
	
	List<TingcheweichuzuView> selectListView(@Param("ew") Wrapper<TingcheweichuzuEntity> wrapper);

	List<TingcheweichuzuView> selectListView(Pagination page,@Param("ew") Wrapper<TingcheweichuzuEntity> wrapper);
	
	TingcheweichuzuView selectView(@Param("ew") Wrapper<TingcheweichuzuEntity> wrapper);
	

}
