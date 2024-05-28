package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusschongwudailiuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusschongwudailiuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusschongwudailiuView;


/**
 * 宠物代遛评论表
 *
 * @author 
 * @email 
 * @date 2022-04-11 15:24:59
 */
public interface DiscusschongwudailiuService extends IService<DiscusschongwudailiuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusschongwudailiuVO> selectListVO(Wrapper<DiscusschongwudailiuEntity> wrapper);
   	
   	DiscusschongwudailiuVO selectVO(@Param("ew") Wrapper<DiscusschongwudailiuEntity> wrapper);
   	
   	List<DiscusschongwudailiuView> selectListView(Wrapper<DiscusschongwudailiuEntity> wrapper);
   	
   	DiscusschongwudailiuView selectView(@Param("ew") Wrapper<DiscusschongwudailiuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusschongwudailiuEntity> wrapper);
   	

}

