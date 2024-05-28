package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.ZuzhihuodongEntity;
import com.entity.view.ZuzhihuodongView;
import com.entity.vo.ZuzhihuodongVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 其他
 *
 * @author 
 * @email 
 * @date 2022-04-11 15:24:59
 */
public interface ZuzhihuodongService extends IService<ZuzhihuodongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZuzhihuodongVO> selectListVO(Wrapper<ZuzhihuodongEntity> wrapper);
   	
   	ZuzhihuodongVO selectVO(@Param("ew") Wrapper<ZuzhihuodongEntity> wrapper);
   	
   	List<ZuzhihuodongView> selectListView(Wrapper<ZuzhihuodongEntity> wrapper);
   	
   	ZuzhihuodongView selectView(@Param("ew") Wrapper<ZuzhihuodongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZuzhihuodongEntity> wrapper);

	List<ZuzhihuodongView> selectListViewByNames( List<String> names);

}

