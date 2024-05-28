package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.LoufangxinxiEntity;
import com.entity.RenkoutongjixinxiEntity;
import com.entity.view.LoufangxinxiView;
import com.entity.view.RenkoutongjixinxiView;
import com.entity.vo.LoufangxinxiVO;
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
public interface RenkoutongjixinxiService extends IService<RenkoutongjixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);

   	List<RenkoutongjixinxiVO> selectListVO(Wrapper<RenkoutongjixinxiEntity> wrapper);

	RenkoutongjixinxiVO selectVO(@Param("ew") Wrapper<RenkoutongjixinxiEntity> wrapper);

   	List<RenkoutongjixinxiView> selectListView(Wrapper<RenkoutongjixinxiEntity> wrapper);

	RenkoutongjixinxiView selectView(@Param("ew") Wrapper<RenkoutongjixinxiEntity> wrapper);

   	PageUtils queryPage(Map<String, Object> params, Wrapper<RenkoutongjixinxiEntity> wrapper);


}

