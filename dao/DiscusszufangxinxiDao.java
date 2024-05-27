package com.dao;

import com.entity.DiscusszufangxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusszufangxinxiVO;
import com.entity.view.DiscusszufangxinxiView;


/**
 * 租房信息评论表
 * 
 * @author 
 * @email 
 * @date 2022-04-11 15:24:59
 */
public interface DiscusszufangxinxiDao extends BaseMapper<DiscusszufangxinxiEntity> {
	
	List<DiscusszufangxinxiVO> selectListVO(@Param("ew") Wrapper<DiscusszufangxinxiEntity> wrapper);
	
	DiscusszufangxinxiVO selectVO(@Param("ew") Wrapper<DiscusszufangxinxiEntity> wrapper);
	
	List<DiscusszufangxinxiView> selectListView(@Param("ew") Wrapper<DiscusszufangxinxiEntity> wrapper);

	List<DiscusszufangxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusszufangxinxiEntity> wrapper);
	
	DiscusszufangxinxiView selectView(@Param("ew") Wrapper<DiscusszufangxinxiEntity> wrapper);
	

}
