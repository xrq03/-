package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussqushifenxiangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussqushifenxiangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussqushifenxiangView;


/**
 * 趣事分享评论表
 *
 * @author 
 * @email 
 * @date 2022-04-11 15:24:59
 */
public interface DiscussqushifenxiangService extends IService<DiscussqushifenxiangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussqushifenxiangVO> selectListVO(Wrapper<DiscussqushifenxiangEntity> wrapper);
   	
   	DiscussqushifenxiangVO selectVO(@Param("ew") Wrapper<DiscussqushifenxiangEntity> wrapper);
   	
   	List<DiscussqushifenxiangView> selectListView(Wrapper<DiscussqushifenxiangEntity> wrapper);
   	
   	DiscussqushifenxiangView selectView(@Param("ew") Wrapper<DiscussqushifenxiangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussqushifenxiangEntity> wrapper);
   	

}

