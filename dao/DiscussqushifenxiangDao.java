package com.dao;

import com.entity.DiscussqushifenxiangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussqushifenxiangVO;
import com.entity.view.DiscussqushifenxiangView;


/**
 * 趣事分享评论表
 * 
 * @author 
 * @email 
 * @date 2022-04-11 15:24:59
 */
public interface DiscussqushifenxiangDao extends BaseMapper<DiscussqushifenxiangEntity> {
	
	List<DiscussqushifenxiangVO> selectListVO(@Param("ew") Wrapper<DiscussqushifenxiangEntity> wrapper);
	
	DiscussqushifenxiangVO selectVO(@Param("ew") Wrapper<DiscussqushifenxiangEntity> wrapper);
	
	List<DiscussqushifenxiangView> selectListView(@Param("ew") Wrapper<DiscussqushifenxiangEntity> wrapper);

	List<DiscussqushifenxiangView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussqushifenxiangEntity> wrapper);
	
	DiscussqushifenxiangView selectView(@Param("ew") Wrapper<DiscussqushifenxiangEntity> wrapper);
	

}
