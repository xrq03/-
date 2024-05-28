package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.QitaEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.QitaVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.QitaView;


/**
 * 其他
 *
 * @author 
 * @email 
 * @date 2022-04-11 15:24:59
 */
public interface QitaService extends IService<QitaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<QitaVO> selectListVO(Wrapper<QitaEntity> wrapper);
   	
   	QitaVO selectVO(@Param("ew") Wrapper<QitaEntity> wrapper);
   	
   	List<QitaView> selectListView(Wrapper<QitaEntity> wrapper);
   	
   	QitaView selectView(@Param("ew") Wrapper<QitaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<QitaEntity> wrapper);
   	

}

