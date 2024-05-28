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


import com.dao.DiscussqitaDao;
import com.entity.DiscussqitaEntity;
import com.service.DiscussqitaService;
import com.entity.vo.DiscussqitaVO;
import com.entity.view.DiscussqitaView;

@Service("discussqitaService")
public class DiscussqitaServiceImpl extends ServiceImpl<DiscussqitaDao, DiscussqitaEntity> implements DiscussqitaService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussqitaEntity> page = this.selectPage(
                new Query<DiscussqitaEntity>(params).getPage(),
                new EntityWrapper<DiscussqitaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussqitaEntity> wrapper) {
		  Page<DiscussqitaView> page =new Query<DiscussqitaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussqitaVO> selectListVO(Wrapper<DiscussqitaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussqitaVO selectVO(Wrapper<DiscussqitaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussqitaView> selectListView(Wrapper<DiscussqitaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussqitaView selectView(Wrapper<DiscussqitaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
