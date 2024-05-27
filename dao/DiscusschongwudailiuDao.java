package com.dao;

import com.entity.DiscusschongwudailiuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusschongwudailiuVO;
import com.entity.view.DiscusschongwudailiuView;


/**
 * 宠物代遛评论表
 * 
 * @author 
 * @email 
 * @date 2022-04-11 15:24:59
 */
public interface DiscusschongwudailiuDao extends BaseMapper<DiscusschongwudailiuEntity> {
	
	List<DiscusschongwudailiuVO> selectListVO(@Param("ew") Wrapper<DiscusschongwudailiuEntity> wrapper);
	
	DiscusschongwudailiuVO selectVO(@Param("ew") Wrapper<DiscusschongwudailiuEntity> wrapper);
	
	List<DiscusschongwudailiuView> selectListView(@Param("ew") Wrapper<DiscusschongwudailiuEntity> wrapper);

	List<DiscusschongwudailiuView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusschongwudailiuEntity> wrapper);
	
	DiscusschongwudailiuView selectView(@Param("ew") Wrapper<DiscusschongwudailiuEntity> wrapper);
	

}
