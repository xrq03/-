package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.QushifenxiangEntity;
import com.entity.view.QushifenxiangView;
import com.entity.vo.QushifenxiangVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 趣事分享
 *
 * @author 
 * @email 
 * @date 2022-04-11 15:24:59
 */
public interface QushifenxiangService extends IService<QushifenxiangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<QushifenxiangVO> selectListVO(Wrapper<QushifenxiangEntity> wrapper);
   	
   	QushifenxiangVO selectVO(@Param("ew") Wrapper<QushifenxiangEntity> wrapper);
   	
   	List<QushifenxiangView> selectListView(Wrapper<QushifenxiangEntity> wrapper);
   	
   	QushifenxiangView selectView(@Param("ew") Wrapper<QushifenxiangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<QushifenxiangEntity> wrapper);

	List<QushifenxiangView> selectListViewByNames(List<String> names);

}

