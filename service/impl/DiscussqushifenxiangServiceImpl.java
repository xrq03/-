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


import com.dao.DiscussqushifenxiangDao;
import com.entity.DiscussqushifenxiangEntity;
import com.service.DiscussqushifenxiangService;
import com.entity.vo.DiscussqushifenxiangVO;
import com.entity.view.DiscussqushifenxiangView;

@Service("discussqushifenxiangService")
public class DiscussqushifenxiangServiceImpl extends ServiceImpl<DiscussqushifenxiangDao, DiscussqushifenxiangEntity> implements DiscussqushifenxiangService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussqushifenxiangEntity> page = this.selectPage(
                new Query<DiscussqushifenxiangEntity>(params).getPage(),
                new EntityWrapper<DiscussqushifenxiangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussqushifenxiangEntity> wrapper) {
		  Page<DiscussqushifenxiangView> page =new Query<DiscussqushifenxiangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussqushifenxiangVO> selectListVO(Wrapper<DiscussqushifenxiangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussqushifenxiangVO selectVO(Wrapper<DiscussqushifenxiangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussqushifenxiangView> selectListView(Wrapper<DiscussqushifenxiangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussqushifenxiangView selectView(Wrapper<DiscussqushifenxiangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
