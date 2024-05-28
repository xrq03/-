package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusstingcheweichuzuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusstingcheweichuzuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusstingcheweichuzuView;


/**
 * 停车位出租评论表
 *
 * @author 
 * @email 
 * @date 2022-04-11 15:24:59
 */
public interface DiscusstingcheweichuzuService extends IService<DiscusstingcheweichuzuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusstingcheweichuzuVO> selectListVO(Wrapper<DiscusstingcheweichuzuEntity> wrapper);
   	
   	DiscusstingcheweichuzuVO selectVO(@Param("ew") Wrapper<DiscusstingcheweichuzuEntity> wrapper);
   	
   	List<DiscusstingcheweichuzuView> selectListView(Wrapper<DiscusstingcheweichuzuEntity> wrapper);
   	
   	DiscusstingcheweichuzuView selectView(@Param("ew") Wrapper<DiscusstingcheweichuzuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusstingcheweichuzuEntity> wrapper);
   	

}

