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


import com.dao.ChongwudailiuDao;
import com.entity.ChongwudailiuEntity;
import com.service.ChongwudailiuService;
import com.entity.vo.ChongwudailiuVO;
import com.entity.view.ChongwudailiuView;

@Service("chongwudailiuService")
public class ChongwudailiuServiceImpl extends ServiceImpl<ChongwudailiuDao, ChongwudailiuEntity> implements ChongwudailiuService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChongwudailiuEntity> page = this.selectPage(
                new Query<ChongwudailiuEntity>(params).getPage(),
                new EntityWrapper<ChongwudailiuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChongwudailiuEntity> wrapper) {
		  Page<ChongwudailiuView> page =new Query<ChongwudailiuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ChongwudailiuVO> selectListVO(Wrapper<ChongwudailiuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ChongwudailiuVO selectVO(Wrapper<ChongwudailiuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ChongwudailiuView> selectListView(Wrapper<ChongwudailiuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChongwudailiuView selectView(Wrapper<ChongwudailiuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
