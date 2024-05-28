package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.LoufangxinxiDao;
import com.dao.RenkoutongjixinxiDao;
import com.entity.LoufangxinxiEntity;
import com.entity.RenkoutongjixinxiEntity;
import com.entity.view.LoufangxinxiView;
import com.entity.view.RenkoutongjixinxiView;
import com.entity.vo.LoufangxinxiVO;
import com.entity.vo.RenkoutongjixinxiVO;
import com.service.LoufangxinxiService;
import com.service.RenkoutongjixinxiService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("renkoutongjixinxiService")
public class RenkoutongjixinxiServiceImpl extends ServiceImpl<RenkoutongjixinxiDao, RenkoutongjixinxiEntity> implements RenkoutongjixinxiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RenkoutongjixinxiEntity> page = this.selectPage(
                new Query<RenkoutongjixinxiEntity>(params).getPage(),
                new EntityWrapper<RenkoutongjixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<RenkoutongjixinxiEntity> wrapper) {
		  Page<RenkoutongjixinxiView> page =new Query<RenkoutongjixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<RenkoutongjixinxiVO> selectListVO(Wrapper<RenkoutongjixinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public RenkoutongjixinxiVO selectVO(Wrapper<RenkoutongjixinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<RenkoutongjixinxiView> selectListView(Wrapper<RenkoutongjixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public RenkoutongjixinxiView selectView(Wrapper<RenkoutongjixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
