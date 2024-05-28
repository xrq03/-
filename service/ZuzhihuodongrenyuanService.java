package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.DiscusszuzhihuodongEntity;
import com.entity.ZuzhihuodongrenyuanEntity;
import com.entity.view.DiscusszuzhihuodongView;
import com.entity.view.ZuzhihuodongrenyuanView;
import com.entity.vo.DiscusszuzhihuodongVO;
import com.entity.vo.ZuzhihuodongrenyuanVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 其他评论表
 *
 * @author 
 * @email 
 * @date 2022-04-11 15:24:59
 */
public interface ZuzhihuodongrenyuanService extends IService<ZuzhihuodongrenyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZuzhihuodongrenyuanVO> selectListVO(Wrapper<ZuzhihuodongrenyuanEntity> wrapper);
   	
   	ZuzhihuodongrenyuanVO selectVO(@Param("ew") Wrapper<ZuzhihuodongrenyuanEntity> wrapper);
   	
   	List<ZuzhihuodongrenyuanView> selectListView(Wrapper<ZuzhihuodongrenyuanEntity> wrapper);
   	
   	ZuzhihuodongrenyuanView selectView(@Param("ew") Wrapper<ZuzhihuodongrenyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZuzhihuodongrenyuanEntity> wrapper);
   	

}

