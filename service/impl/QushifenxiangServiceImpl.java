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


import com.dao.QushifenxiangDao;
import com.entity.QushifenxiangEntity;
import com.service.QushifenxiangService;
import com.entity.vo.QushifenxiangVO;
import com.entity.view.QushifenxiangView;

@Service("qushifenxiangService")
public class QushifenxiangServiceImpl extends ServiceImpl<QushifenxiangDao, QushifenxiangEntity> implements QushifenxiangService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QushifenxiangEntity> page = this.selectPage(
                new Query<QushifenxiangEntity>(params).getPage(),
                new EntityWrapper<QushifenxiangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<QushifenxiangEntity> wrapper) {
		  Page<QushifenxiangView> page =new Query<QushifenxiangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<QushifenxiangVO> selectListVO(Wrapper<QushifenxiangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public QushifenxiangVO selectVO(Wrapper<QushifenxiangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<QushifenxiangView> selectListView(Wrapper<QushifenxiangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public QushifenxiangView selectView(Wrapper<QushifenxiangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

	@Override
	public List<QushifenxiangView> selectListViewByNames(List<String> names) {
		return baseMapper.selectListViewByNames(names);
	}

}
