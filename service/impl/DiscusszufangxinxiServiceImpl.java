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


import com.dao.DiscusszufangxinxiDao;
import com.entity.DiscusszufangxinxiEntity;
import com.service.DiscusszufangxinxiService;
import com.entity.vo.DiscusszufangxinxiVO;
import com.entity.view.DiscusszufangxinxiView;

@Service("discusszufangxinxiService")
public class DiscusszufangxinxiServiceImpl extends ServiceImpl<DiscusszufangxinxiDao, DiscusszufangxinxiEntity> implements DiscusszufangxinxiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusszufangxinxiEntity> page = this.selectPage(
                new Query<DiscusszufangxinxiEntity>(params).getPage(),
                new EntityWrapper<DiscusszufangxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusszufangxinxiEntity> wrapper) {
		  Page<DiscusszufangxinxiView> page =new Query<DiscusszufangxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusszufangxinxiVO> selectListVO(Wrapper<DiscusszufangxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusszufangxinxiVO selectVO(Wrapper<DiscusszufangxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusszufangxinxiView> selectListView(Wrapper<DiscusszufangxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusszufangxinxiView selectView(Wrapper<DiscusszufangxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
