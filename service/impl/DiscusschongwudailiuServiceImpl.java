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


import com.dao.DiscusschongwudailiuDao;
import com.entity.DiscusschongwudailiuEntity;
import com.service.DiscusschongwudailiuService;
import com.entity.vo.DiscusschongwudailiuVO;
import com.entity.view.DiscusschongwudailiuView;

@Service("discusschongwudailiuService")
public class DiscusschongwudailiuServiceImpl extends ServiceImpl<DiscusschongwudailiuDao, DiscusschongwudailiuEntity> implements DiscusschongwudailiuService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusschongwudailiuEntity> page = this.selectPage(
                new Query<DiscusschongwudailiuEntity>(params).getPage(),
                new EntityWrapper<DiscusschongwudailiuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusschongwudailiuEntity> wrapper) {
		  Page<DiscusschongwudailiuView> page =new Query<DiscusschongwudailiuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusschongwudailiuVO> selectListVO(Wrapper<DiscusschongwudailiuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusschongwudailiuVO selectVO(Wrapper<DiscusschongwudailiuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusschongwudailiuView> selectListView(Wrapper<DiscusschongwudailiuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusschongwudailiuView selectView(Wrapper<DiscusschongwudailiuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
