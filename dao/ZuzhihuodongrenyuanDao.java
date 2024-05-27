package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.DiscusszuzhihuodongEntity;
import com.entity.ZuzhihuodongrenyuanEntity;
import com.entity.view.DiscusszuzhihuodongView;
import com.entity.view.ZuzhihuodongrenyuanView;
import com.entity.vo.DiscusszuzhihuodongVO;
import com.entity.vo.ZuzhihuodongrenyuanVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 其他评论表
 * 
 * @author 
 * @email 
 * @date 2022-04-11 15:24:59
 */
public interface ZuzhihuodongrenyuanDao extends BaseMapper<ZuzhihuodongrenyuanEntity> {
	
	List<ZuzhihuodongrenyuanVO> selectListVO(@Param("ew") Wrapper<ZuzhihuodongrenyuanEntity> wrapper);
	
	ZuzhihuodongrenyuanVO selectVO(@Param("ew") Wrapper<ZuzhihuodongrenyuanEntity> wrapper);
	
	List<ZuzhihuodongrenyuanView> selectListView(@Param("ew") Wrapper<ZuzhihuodongrenyuanEntity> wrapper);

	List<ZuzhihuodongrenyuanView> selectListView(Pagination page,@Param("ew") Wrapper<ZuzhihuodongrenyuanEntity> wrapper);
	
	ZuzhihuodongrenyuanView selectView(@Param("ew") Wrapper<ZuzhihuodongrenyuanEntity> wrapper);
	

}
