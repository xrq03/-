package com.dao;

import com.entity.DiscussqitaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussqitaVO;
import com.entity.view.DiscussqitaView;


/**
 * 其他评论表
 * 
 * @author 
 * @email 
 * @date 2022-04-11 15:24:59
 */
public interface DiscussqitaDao extends BaseMapper<DiscussqitaEntity> {
	
	List<DiscussqitaVO> selectListVO(@Param("ew") Wrapper<DiscussqitaEntity> wrapper);
	
	DiscussqitaVO selectVO(@Param("ew") Wrapper<DiscussqitaEntity> wrapper);
	
	List<DiscussqitaView> selectListView(@Param("ew") Wrapper<DiscussqitaEntity> wrapper);

	List<DiscussqitaView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussqitaEntity> wrapper);
	
	DiscussqitaView selectView(@Param("ew") Wrapper<DiscussqitaEntity> wrapper);
	

}
