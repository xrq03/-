package com.dao;

import com.entity.QushifenxiangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.QushifenxiangVO;
import com.entity.view.QushifenxiangView;


/**
 * 趣事分享
 * 
 * @author 
 * @email 
 * @date 2022-04-11 15:24:59
 */
public interface QushifenxiangDao extends BaseMapper<QushifenxiangEntity> {
	
	List<QushifenxiangVO> selectListVO(@Param("ew") Wrapper<QushifenxiangEntity> wrapper);
	
	QushifenxiangVO selectVO(@Param("ew") Wrapper<QushifenxiangEntity> wrapper);
	
	List<QushifenxiangView> selectListView(@Param("ew") Wrapper<QushifenxiangEntity> wrapper);

	List<QushifenxiangView> selectListView(Pagination page,@Param("ew") Wrapper<QushifenxiangEntity> wrapper);


    List<QushifenxiangView> selectListViewByNames(@Param("names") List<String> names);


	QushifenxiangView selectView(@Param("ew") Wrapper<QushifenxiangEntity> wrapper);
	

}
