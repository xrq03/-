package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.DiscusschongwudailiuEntity;
import com.entity.DiscusswupingongxiangEntity;
import com.entity.view.DiscusschongwudailiuView;
import com.entity.view.DiscusswupingongxiangView;
import com.entity.vo.DiscusschongwudailiuVO;
import com.entity.vo.DiscusswupingongxiangVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 宠物代遛评论表
 *
 * @author 
 * @email 
 * @date 2022-04-11 15:24:59
 */
public interface DiscusswupingongxiangService extends IService<DiscusswupingongxiangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusswupingongxiangVO> selectListVO(Wrapper<DiscusswupingongxiangEntity> wrapper);
   	
   	DiscusswupingongxiangVO selectVO(@Param("ew") Wrapper<DiscusswupingongxiangEntity> wrapper);
   	
   	List<DiscusswupingongxiangView> selectListView(Wrapper<DiscusswupingongxiangEntity> wrapper);
   	
   	DiscusswupingongxiangView selectView(@Param("ew") Wrapper<DiscusswupingongxiangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusswupingongxiangEntity> wrapper);
   	

}

