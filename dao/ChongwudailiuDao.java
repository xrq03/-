package com.dao;

import com.entity.ChongwudailiuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ChongwudailiuVO;
import com.entity.view.ChongwudailiuView;


/**
 * 宠物代遛
 * 
 * @author 
 * @email 
 * @date 2022-04-11 15:24:59
 */
public interface ChongwudailiuDao extends BaseMapper<ChongwudailiuEntity> {
	
	List<ChongwudailiuVO> selectListVO(@Param("ew") Wrapper<ChongwudailiuEntity> wrapper);
	
	ChongwudailiuVO selectVO(@Param("ew") Wrapper<ChongwudailiuEntity> wrapper);
	
	List<ChongwudailiuView> selectListView(@Param("ew") Wrapper<ChongwudailiuEntity> wrapper);

	List<ChongwudailiuView> selectListView(Pagination page,@Param("ew") Wrapper<ChongwudailiuEntity> wrapper);
	
	ChongwudailiuView selectView(@Param("ew") Wrapper<ChongwudailiuEntity> wrapper);
	

}
