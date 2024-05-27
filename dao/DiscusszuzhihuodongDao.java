package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.DiscussqitaEntity;
import com.entity.DiscusszuzhihuodongEntity;
import com.entity.view.DiscussqitaView;
import com.entity.view.DiscusszuzhihuodongView;
import com.entity.vo.DiscussqitaVO;
import com.entity.vo.DiscusszuzhihuodongVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 其他评论表
 * 
 * @author 
 * @email 
 * @date 2022-04-11 15:24:59
 */
public interface DiscusszuzhihuodongDao extends BaseMapper<DiscusszuzhihuodongEntity> {
	
	List<DiscusszuzhihuodongVO> selectListVO(@Param("ew") Wrapper<DiscusszuzhihuodongEntity> wrapper);
	
	DiscusszuzhihuodongVO selectVO(@Param("ew") Wrapper<DiscusszuzhihuodongEntity> wrapper);
	
	List<DiscusszuzhihuodongView> selectListView(@Param("ew") Wrapper<DiscusszuzhihuodongEntity> wrapper);

	List<DiscusszuzhihuodongView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusszuzhihuodongEntity> wrapper);
	
	DiscusszuzhihuodongView selectView(@Param("ew") Wrapper<DiscusszuzhihuodongEntity> wrapper);
	

}
