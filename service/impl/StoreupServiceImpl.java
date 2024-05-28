package com.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.dao.ZuzhihuodongDao;
import com.entity.view.ZuzhihuodongView;
import com.entity.vo.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.StoreupDao;
import com.entity.StoreupEntity;
import com.service.StoreupService;
import com.entity.vo.StoreupVO;
import com.entity.view.StoreupView;

@Service("storeupService")
public class StoreupServiceImpl extends ServiceImpl<StoreupDao, StoreupEntity> implements StoreupService {

	@Autowired
	private ZuzhihuodongDao zuzhihuodongDao;


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<StoreupEntity> page = this.selectPage(
                new Query<StoreupEntity>(params).getPage(),
                new EntityWrapper<StoreupEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<StoreupEntity> wrapper) {
		  Page<StoreupView> page =new Query<StoreupView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<StoreupVO> selectListVO(Wrapper<StoreupEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public StoreupVO selectVO(Wrapper<StoreupEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<StoreupView> selectListView(Wrapper<StoreupEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public StoreupView selectView(Wrapper<StoreupEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

	@Override
	public Map<String, Map<String, Set<Integer>>> getUserTopicPreferences(String tableName) {
		Map<String, Map<String, Set<Integer>>> userTopicPreferences = new HashMap<>();
		List<UserData> userDataList = baseMapper.getUserData(tableName);

		if ("zuzhihuodong".equals(tableName)) {
			userDataList.removeIf(item -> {
				ZuzhihuodongView zuzhihuodongView = zuzhihuodongDao.queryOneByStarttimeAndTitle(item.getName());
				if (ObjectUtil.isNotNull(zuzhihuodongView)) {
					return true;
				}else {
					return false;
				}
			});
		}

		for (UserData userData : userDataList) {
			String userId = userData.getUserid();
			String name = userData.getName();
			List<String> types = userData.getTypes();

			// Convert types from List<String> to Set<Integer>
			Set<Integer> typeSet = new HashSet<>();
			for (String type : types) {
				typeSet.add(Integer.parseInt(type));
			}

			Map<String, Set<Integer>> topicPreferences = userTopicPreferences.computeIfAbsent(userId, k -> new HashMap<>());
			topicPreferences.put(name, typeSet);
		}

		return userTopicPreferences;
	}
}
