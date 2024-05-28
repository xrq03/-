package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.ChongwudailiuEntity;
import com.entity.WupingongxiangEntity;
import com.entity.view.ChongwudailiuView;
import com.entity.view.WupingongxiangView;
import com.entity.vo.ChongwudailiuVO;
import com.entity.vo.WupingongxiangVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 宠物代遛
 *
 * @author 
 * @email 
 * @date 2022-04-11 15:24:59
 */
public interface WupingongxiangService extends IService<WupingongxiangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WupingongxiangVO> selectListVO(Wrapper<WupingongxiangEntity> wrapper);

	WupingongxiangVO selectVO(@Param("ew") Wrapper<WupingongxiangEntity> wrapper);
   	
   	List<WupingongxiangView> selectListView(Wrapper<WupingongxiangEntity> wrapper);

	WupingongxiangView selectView(@Param("ew") Wrapper<WupingongxiangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WupingongxiangEntity> wrapper);
   	

}

