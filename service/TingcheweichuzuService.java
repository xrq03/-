package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.TingcheweichuzuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.TingcheweichuzuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.TingcheweichuzuView;


/**
 * 停车位出租
 *
 * @author 
 * @email 
 * @date 2022-04-11 15:24:59
 */
public interface TingcheweichuzuService extends IService<TingcheweichuzuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TingcheweichuzuVO> selectListVO(Wrapper<TingcheweichuzuEntity> wrapper);
   	
   	TingcheweichuzuVO selectVO(@Param("ew") Wrapper<TingcheweichuzuEntity> wrapper);
   	
   	List<TingcheweichuzuView> selectListView(Wrapper<TingcheweichuzuEntity> wrapper);
   	
   	TingcheweichuzuView selectView(@Param("ew") Wrapper<TingcheweichuzuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TingcheweichuzuEntity> wrapper);
   	

}

