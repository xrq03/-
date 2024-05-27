package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.WupingongxiangEntity;
import com.entity.view.WupingongxiangView;
import com.entity.vo.ChongwudailiuVO;
import com.entity.vo.WupingongxiangVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 宠物代遛
 * 
 * @author 
 * @email 
 * @date 2022-04-11 15:24:59
 */
public interface WupingongxiangDao extends BaseMapper<WupingongxiangEntity> {
	
	List<WupingongxiangVO> selectListVO(@Param("ew") Wrapper<WupingongxiangEntity> wrapper);
	
	WupingongxiangVO selectVO(@Param("ew") Wrapper<WupingongxiangEntity> wrapper);
	
	List<WupingongxiangView> selectListView(@Param("ew") Wrapper<WupingongxiangEntity> wrapper);

	List<WupingongxiangView> selectListView(Pagination page,@Param("ew") Wrapper<WupingongxiangEntity> wrapper);
	
	WupingongxiangView selectView(@Param("ew") Wrapper<WupingongxiangEntity> wrapper);
	

}
