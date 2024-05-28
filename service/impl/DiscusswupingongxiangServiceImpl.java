package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.DiscusschongwudailiuDao;
import com.dao.DiscusswupingongxiangDao;
import com.entity.DiscusschongwudailiuEntity;
import com.entity.DiscusswupingongxiangEntity;
import com.entity.view.DiscusschongwudailiuView;
import com.entity.view.DiscusswupingongxiangView;
import com.entity.vo.DiscusschongwudailiuVO;
import com.entity.vo.DiscusswupingongxiangVO;
import com.service.DiscusschongwudailiuService;
import com.service.DiscusswupingongxiangService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("discusswupingongxiangService")
public class DiscusswupingongxiangServiceImpl extends ServiceImpl<DiscusswupingongxiangDao, DiscusswupingongxiangEntity> implements DiscusswupingongxiangService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusswupingongxiangEntity> page = this.selectPage(
                new Query<DiscusswupingongxiangEntity>(params).getPage(),
                new EntityWrapper<DiscusswupingongxiangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusswupingongxiangEntity> wrapper) {
		  Page<DiscusswupingongxiangView> page =new Query<DiscusswupingongxiangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusswupingongxiangVO> selectListVO(Wrapper<DiscusswupingongxiangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusswupingongxiangVO selectVO(Wrapper<DiscusswupingongxiangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusswupingongxiangView> selectListView(Wrapper<DiscusswupingongxiangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusswupingongxiangView selectView(Wrapper<DiscusswupingongxiangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
