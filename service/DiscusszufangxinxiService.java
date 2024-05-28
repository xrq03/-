package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusszufangxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusszufangxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusszufangxinxiView;


/**
 * 租房信息评论表
 *
 * @author 
 * @email 
 * @date 2022-04-11 15:24:59
 */
public interface DiscusszufangxinxiService extends IService<DiscusszufangxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusszufangxinxiVO> selectListVO(Wrapper<DiscusszufangxinxiEntity> wrapper);
   	
   	DiscusszufangxinxiVO selectVO(@Param("ew") Wrapper<DiscusszufangxinxiEntity> wrapper);
   	
   	List<DiscusszufangxinxiView> selectListView(Wrapper<DiscusszufangxinxiEntity> wrapper);
   	
   	DiscusszufangxinxiView selectView(@Param("ew") Wrapper<DiscusszufangxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusszufangxinxiEntity> wrapper);
   	

}

