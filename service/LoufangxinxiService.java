package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.LoufangxinxiEntity;
import com.entity.ZufangxinxiEntity;
import com.entity.view.LoufangxinxiView;
import com.entity.view.ZufangxinxiView;
import com.entity.vo.LoufangxinxiVO;
import com.entity.vo.ZufangxinxiVO;
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
public interface LoufangxinxiService extends IService<LoufangxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);

   	List<LoufangxinxiVO> selectListVO(Wrapper<LoufangxinxiEntity> wrapper);

	LoufangxinxiVO selectVO(@Param("ew") Wrapper<LoufangxinxiEntity> wrapper);

   	List<LoufangxinxiView> selectListView(Wrapper<LoufangxinxiEntity> wrapper);

	LoufangxinxiView selectView(@Param("ew") Wrapper<LoufangxinxiEntity> wrapper);

   	PageUtils queryPage(Map<String, Object> params, Wrapper<LoufangxinxiEntity> wrapper);


}

