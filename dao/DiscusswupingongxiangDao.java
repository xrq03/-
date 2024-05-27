package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.DiscusswupingongxiangEntity;
import com.entity.view.DiscusswupingongxiangView;
import com.entity.vo.DiscusswupingongxiangVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 宠物代遛评论表
 * 
 * @author 
 * @email 
 * @date 2022-04-11 15:24:59
 */
public interface DiscusswupingongxiangDao extends BaseMapper<DiscusswupingongxiangEntity> {
	
	List<DiscusswupingongxiangVO> selectListVO(@Param("ew") Wrapper<DiscusswupingongxiangEntity> wrapper);
	
	DiscusswupingongxiangVO selectVO(@Param("ew") Wrapper<DiscusswupingongxiangEntity> wrapper);
	
	List<DiscusswupingongxiangView> selectListView(@Param("ew") Wrapper<DiscusswupingongxiangEntity> wrapper);

	List<DiscusswupingongxiangView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusswupingongxiangEntity> wrapper);
	
	DiscusswupingongxiangView selectView(@Param("ew") Wrapper<DiscusswupingongxiangEntity> wrapper);
	

}
