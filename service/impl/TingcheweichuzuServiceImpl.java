package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.TingcheweichuzuDao;
import com.entity.TingcheweichuzuEntity;
import com.service.TingcheweichuzuService;
import com.entity.vo.TingcheweichuzuVO;
import com.entity.view.TingcheweichuzuView;

@Service("tingcheweichuzuService")
public class TingcheweichuzuServiceImpl extends ServiceImpl<TingcheweichuzuDao, TingcheweichuzuEntity> implements TingcheweichuzuService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TingcheweichuzuEntity> page = this.selectPage(
                new Query<TingcheweichuzuEntity>(params).getPage(),
                new EntityWrapper<TingcheweichuzuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TingcheweichuzuEntity> wrapper) {
		  Page<TingcheweichuzuView> page =new Query<TingcheweichuzuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<TingcheweichuzuVO> selectListVO(Wrapper<TingcheweichuzuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public TingcheweichuzuVO selectVO(Wrapper<TingcheweichuzuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<TingcheweichuzuView> selectListView(Wrapper<TingcheweichuzuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TingcheweichuzuView selectView(Wrapper<TingcheweichuzuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
