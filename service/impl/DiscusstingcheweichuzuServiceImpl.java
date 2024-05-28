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


import com.dao.DiscusstingcheweichuzuDao;
import com.entity.DiscusstingcheweichuzuEntity;
import com.service.DiscusstingcheweichuzuService;
import com.entity.vo.DiscusstingcheweichuzuVO;
import com.entity.view.DiscusstingcheweichuzuView;

@Service("discusstingcheweichuzuService")
public class DiscusstingcheweichuzuServiceImpl extends ServiceImpl<DiscusstingcheweichuzuDao, DiscusstingcheweichuzuEntity> implements DiscusstingcheweichuzuService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusstingcheweichuzuEntity> page = this.selectPage(
                new Query<DiscusstingcheweichuzuEntity>(params).getPage(),
                new EntityWrapper<DiscusstingcheweichuzuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusstingcheweichuzuEntity> wrapper) {
		  Page<DiscusstingcheweichuzuView> page =new Query<DiscusstingcheweichuzuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusstingcheweichuzuVO> selectListVO(Wrapper<DiscusstingcheweichuzuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusstingcheweichuzuVO selectVO(Wrapper<DiscusstingcheweichuzuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusstingcheweichuzuView> selectListView(Wrapper<DiscusstingcheweichuzuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusstingcheweichuzuView selectView(Wrapper<DiscusstingcheweichuzuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
