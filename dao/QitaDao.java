package com.dao;

import com.entity.QitaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.QitaVO;
import com.entity.view.QitaView;


/**
 * 其他
 * 
 * @author 
 * @email 
 * @date 2022-04-11 15:24:59
 */
public interface QitaDao extends BaseMapper<QitaEntity> {
	
	List<QitaVO> selectListVO(@Param("ew") Wrapper<QitaEntity> wrapper);
	
	QitaVO selectVO(@Param("ew") Wrapper<QitaEntity> wrapper);
	
	List<QitaView> selectListView(@Param("ew") Wrapper<QitaEntity> wrapper);

	List<QitaView> selectListView(Pagination page,@Param("ew") Wrapper<QitaEntity> wrapper);
	
	QitaView selectView(@Param("ew") Wrapper<QitaEntity> wrapper);
	

}
