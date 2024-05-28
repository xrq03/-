package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussqitaEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussqitaVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussqitaView;


/**
 * 其他评论表
 *
 * @author 
 * @email 
 * @date 2022-04-11 15:24:59
 */
public interface DiscussqitaService extends IService<DiscussqitaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussqitaVO> selectListVO(Wrapper<DiscussqitaEntity> wrapper);
   	
   	DiscussqitaVO selectVO(@Param("ew") Wrapper<DiscussqitaEntity> wrapper);
   	
   	List<DiscussqitaView> selectListView(Wrapper<DiscussqitaEntity> wrapper);
   	
   	DiscussqitaView selectView(@Param("ew") Wrapper<DiscussqitaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussqitaEntity> wrapper);
   	

}

