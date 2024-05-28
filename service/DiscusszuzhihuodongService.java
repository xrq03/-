package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.DiscussqitaEntity;
import com.entity.DiscusszuzhihuodongEntity;
import com.entity.view.DiscussqitaView;
import com.entity.view.DiscusszuzhihuodongView;
import com.entity.vo.DiscussqitaVO;
import com.entity.vo.DiscusszuzhihuodongVO;
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
public interface DiscusszuzhihuodongService extends IService<DiscusszuzhihuodongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusszuzhihuodongVO> selectListVO(Wrapper<DiscusszuzhihuodongEntity> wrapper);
   	
   	DiscusszuzhihuodongVO selectVO(@Param("ew") Wrapper<DiscusszuzhihuodongEntity> wrapper);
   	
   	List<DiscusszuzhihuodongView> selectListView(Wrapper<DiscusszuzhihuodongEntity> wrapper);
   	
   	DiscusszuzhihuodongView selectView(@Param("ew") Wrapper<DiscusszuzhihuodongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusszuzhihuodongEntity> wrapper);
   	

}

