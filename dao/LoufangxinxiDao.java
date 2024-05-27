package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.LoufangxinxiEntity;
import com.entity.ZufangxinxiEntity;
import com.entity.view.LoufangxinxiView;
import com.entity.view.ZufangxinxiView;
import com.entity.vo.LoufangxinxiVO;
import com.entity.vo.ZufangxinxiVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 租房信息
 * 
 * @author 
 * @email 
 * @date 2022-04-11 15:24:59
 */
public interface LoufangxinxiDao extends BaseMapper<LoufangxinxiEntity> {
	
	List<LoufangxinxiVO> selectListVO(@Param("ew") Wrapper<LoufangxinxiEntity> wrapper);
	
	LoufangxinxiVO selectVO(@Param("ew") Wrapper<LoufangxinxiEntity> wrapper);
	
	List<LoufangxinxiView> selectListView(@Param("ew") Wrapper<LoufangxinxiEntity> wrapper);

	List<LoufangxinxiView> selectListView(Pagination page, @Param("ew") Wrapper<LoufangxinxiEntity> wrapper);
	
	LoufangxinxiView selectView(@Param("ew") Wrapper<LoufangxinxiEntity> wrapper);
	

}
