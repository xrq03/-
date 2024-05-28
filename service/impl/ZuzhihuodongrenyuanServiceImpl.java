package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.DiscusszuzhihuodongDao;
import com.dao.ZuzhihuodongrenyuanDao;
import com.entity.DiscusszuzhihuodongEntity;
import com.entity.ZuzhihuodongrenyuanEntity;
import com.entity.view.DiscusszuzhihuodongView;
import com.entity.view.ZuzhihuodongrenyuanView;
import com.entity.vo.DiscusszuzhihuodongVO;
import com.entity.vo.ZuzhihuodongrenyuanVO;
import com.service.DiscusszuzhihuodongService;
import com.service.ZuzhihuodongrenyuanService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("zuzhihuodongrenyuanService")
public class ZuzhihuodongrenyuanServiceImpl extends ServiceImpl<ZuzhihuodongrenyuanDao, ZuzhihuodongrenyuanEntity> implements ZuzhihuodongrenyuanService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZuzhihuodongrenyuanEntity> page = this.selectPage(
                new Query<ZuzhihuodongrenyuanEntity>(params).getPage(),
                new EntityWrapper<ZuzhihuodongrenyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZuzhihuodongrenyuanEntity> wrapper) {
		  Page<ZuzhihuodongrenyuanView> page =new Query<ZuzhihuodongrenyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZuzhihuodongrenyuanVO> selectListVO(Wrapper<ZuzhihuodongrenyuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZuzhihuodongrenyuanVO selectVO(Wrapper<ZuzhihuodongrenyuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZuzhihuodongrenyuanView> selectListView(Wrapper<ZuzhihuodongrenyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZuzhihuodongrenyuanView selectView(Wrapper<ZuzhihuodongrenyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
