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


import com.dao.QitaDao;
import com.entity.QitaEntity;
import com.service.QitaService;
import com.entity.vo.QitaVO;
import com.entity.view.QitaView;

@Service("qitaService")
public class QitaServiceImpl extends ServiceImpl<QitaDao, QitaEntity> implements QitaService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QitaEntity> page = this.selectPage(
                new Query<QitaEntity>(params).getPage(),
                new EntityWrapper<QitaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<QitaEntity> wrapper) {
		  Page<QitaView> page =new Query<QitaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<QitaVO> selectListVO(Wrapper<QitaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public QitaVO selectVO(Wrapper<QitaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<QitaView> selectListView(Wrapper<QitaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public QitaView selectView(Wrapper<QitaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
