package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.RenkoudengjixinxiEntity;
import com.entity.RenkoutongjixinxiEntity;
import com.entity.view.RenkoudengjixinxiView;
import com.entity.view.RenkoutongjixinxiView;
import com.entity.vo.RenkoudengjixinxiVO;
import com.entity.vo.RenkoutongjixinxiVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 楼房信息
 *
 * @author 
 * @email 
 * @date 2022-04-11 15:24:59
 */
public interface RenkoudengjixinxiService extends IService<RenkoudengjixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);

   	List<RenkoudengjixinxiVO> selectListVO(Wrapper<RenkoudengjixinxiEntity> wrapper);

	RenkoudengjixinxiVO selectVO(@Param("ew") Wrapper<RenkoudengjixinxiEntity> wrapper);

   	List<RenkoudengjixinxiView> selectListView(Wrapper<RenkoudengjixinxiEntity> wrapper);

	RenkoudengjixinxiView selectView(@Param("ew") Wrapper<RenkoudengjixinxiEntity> wrapper);

   	PageUtils queryPage(Map<String, Object> params, Wrapper<RenkoudengjixinxiEntity> wrapper);


}

