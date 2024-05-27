package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.QitaEntity;
import com.entity.ZuzhihuodongEntity;
import com.entity.view.QitaView;
import com.entity.view.QushifenxiangView;
import com.entity.view.ZuzhihuodongView;
import com.entity.vo.QitaVO;
import com.entity.vo.ZuzhihuodongVO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;


/**
 * 其他
 * 
 * @author 
 * @email 
 * @date 2022-04-11 15:24:59
 */
public interface ZuzhihuodongDao extends BaseMapper<ZuzhihuodongEntity> {
	
	List<ZuzhihuodongVO> selectListVO(@Param("ew") Wrapper<ZuzhihuodongEntity> wrapper);

	ZuzhihuodongVO selectVO(@Param("ew") Wrapper<ZuzhihuodongEntity> wrapper);
	
	List<ZuzhihuodongView> selectListView(@Param("ew") Wrapper<ZuzhihuodongEntity> wrapper);

	List<ZuzhihuodongView> selectListView(Pagination page, @Param("ew") Wrapper<ZuzhihuodongEntity> wrapper);

	ZuzhihuodongView selectView(@Param("ew") Wrapper<ZuzhihuodongEntity> wrapper);


	List<ZuzhihuodongView> selectListViewByNames(@Param("names") List<String> names);


	ZuzhihuodongView queryOneByStarttimeAndTitle(@Param("title") String title);
}
