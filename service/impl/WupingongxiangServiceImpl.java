package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.ChongwudailiuDao;
import com.dao.WupingongxiangDao;
import com.entity.ChongwudailiuEntity;
import com.entity.WupingongxiangEntity;
import com.entity.view.ChongwudailiuView;
import com.entity.view.WupingongxiangView;
import com.entity.vo.ChongwudailiuVO;
import com.entity.vo.WupingongxiangVO;
import com.service.ChongwudailiuService;
import com.service.WupingongxiangService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("wupingongxiangService")
public class WupingongxiangServiceImpl extends ServiceImpl<WupingongxiangDao, WupingongxiangEntity> implements WupingongxiangService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WupingongxiangEntity> page = this.selectPage(
                new Query<WupingongxiangEntity>(params).getPage(),
                new EntityWrapper<WupingongxiangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WupingongxiangEntity> wrapper) {
		  Page<WupingongxiangView> page =new Query<WupingongxiangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<WupingongxiangVO> selectListVO(Wrapper<WupingongxiangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WupingongxiangVO selectVO(Wrapper<WupingongxiangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WupingongxiangView> selectListView(Wrapper<WupingongxiangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WupingongxiangView selectView(Wrapper<WupingongxiangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
