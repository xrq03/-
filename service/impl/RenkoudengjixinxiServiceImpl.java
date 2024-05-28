package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.RenkoudengjixinxiDao;
import com.dao.RenkoutongjixinxiDao;
import com.entity.RenkoudengjixinxiEntity;
import com.entity.RenkoutongjixinxiEntity;
import com.entity.view.RenkoudengjixinxiView;
import com.entity.view.RenkoutongjixinxiView;
import com.entity.vo.RenkoudengjixinxiVO;
import com.entity.vo.RenkoutongjixinxiVO;
import com.service.RenkoudengjixinxiService;
import com.service.RenkoutongjixinxiService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("renkoudengjixinxiService")
public class RenkoudengjixinxiServiceImpl extends ServiceImpl<RenkoudengjixinxiDao, RenkoudengjixinxiEntity> implements RenkoudengjixinxiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RenkoudengjixinxiEntity> page = this.selectPage(
                new Query<RenkoudengjixinxiEntity>(params).getPage(),
                new EntityWrapper<RenkoudengjixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<RenkoudengjixinxiEntity> wrapper) {
		  Page<RenkoudengjixinxiView> page =new Query<RenkoudengjixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<RenkoudengjixinxiVO> selectListVO(Wrapper<RenkoudengjixinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public RenkoudengjixinxiVO selectVO(Wrapper<RenkoudengjixinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<RenkoudengjixinxiView> selectListView(Wrapper<RenkoudengjixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public RenkoudengjixinxiView selectView(Wrapper<RenkoudengjixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
