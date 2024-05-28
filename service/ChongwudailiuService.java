package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChongwudailiuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ChongwudailiuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ChongwudailiuView;


/**
 * 宠物代遛
 *
 * @author 
 * @email 
 * @date 2022-04-11 15:24:59
 */
public interface ChongwudailiuService extends IService<ChongwudailiuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChongwudailiuVO> selectListVO(Wrapper<ChongwudailiuEntity> wrapper);
   	
   	ChongwudailiuVO selectVO(@Param("ew") Wrapper<ChongwudailiuEntity> wrapper);
   	
   	List<ChongwudailiuView> selectListView(Wrapper<ChongwudailiuEntity> wrapper);
   	
   	ChongwudailiuView selectView(@Param("ew") Wrapper<ChongwudailiuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChongwudailiuEntity> wrapper);
   	

}

