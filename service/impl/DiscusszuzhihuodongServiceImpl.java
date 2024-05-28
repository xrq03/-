package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.DiscussqitaDao;
import com.dao.DiscusszuzhihuodongDao;
import com.entity.DiscussqitaEntity;
import com.entity.DiscusszuzhihuodongEntity;
import com.entity.view.DiscussqitaView;
import com.entity.view.DiscusszuzhihuodongView;
import com.entity.vo.DiscussqitaVO;
import com.entity.vo.DiscusszuzhihuodongVO;
import com.service.DiscussqitaService;
import com.service.DiscusszuzhihuodongService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("discusszuzhihuodongService")
public class DiscusszuzhihuodongServiceImpl extends ServiceImpl<DiscusszuzhihuodongDao, DiscusszuzhihuodongEntity> implements DiscusszuzhihuodongService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusszuzhihuodongEntity> page = this.selectPage(
                new Query<DiscusszuzhihuodongEntity>(params).getPage(),
                new EntityWrapper<DiscusszuzhihuodongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusszuzhihuodongEntity> wrapper) {
		  Page<DiscusszuzhihuodongView> page =new Query<DiscusszuzhihuodongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusszuzhihuodongVO> selectListVO(Wrapper<DiscusszuzhihuodongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusszuzhihuodongVO selectVO(Wrapper<DiscusszuzhihuodongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusszuzhihuodongView> selectListView(Wrapper<DiscusszuzhihuodongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusszuzhihuodongView selectView(Wrapper<DiscusszuzhihuodongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
