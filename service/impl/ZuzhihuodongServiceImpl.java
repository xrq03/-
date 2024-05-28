package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.QitaDao;
import com.dao.ZuzhihuodongDao;
import com.entity.QitaEntity;
import com.entity.ZuzhihuodongEntity;
import com.entity.view.QitaView;
import com.entity.view.ZuzhihuodongView;
import com.entity.vo.QitaVO;
import com.entity.vo.ZuzhihuodongVO;
import com.service.QitaService;
import com.service.ZuzhihuodongService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("zuzhihuodongService")
public class ZuzhihuodongServiceImpl extends ServiceImpl<ZuzhihuodongDao, ZuzhihuodongEntity> implements ZuzhihuodongService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZuzhihuodongEntity> page = this.selectPage(
                new Query<ZuzhihuodongEntity>(params).getPage(),
                new EntityWrapper<ZuzhihuodongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZuzhihuodongEntity> wrapper) {
		  Page<ZuzhihuodongView> page =new Query<ZuzhihuodongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZuzhihuodongVO> selectListVO(Wrapper<ZuzhihuodongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZuzhihuodongVO selectVO(Wrapper<ZuzhihuodongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZuzhihuodongView> selectListView(Wrapper<ZuzhihuodongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZuzhihuodongView selectView(Wrapper<ZuzhihuodongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


	@Override
	public List<ZuzhihuodongView> selectListViewByNames(List<String> names) {
		return baseMapper.selectListViewByNames(names);
	}
}
