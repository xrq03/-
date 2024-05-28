
package com.service.impl;


import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.hutool.core.util.ObjectUtil;
import com.dao.UserDao;
import com.dao.YonghuDao;
import com.entity.UserEntity;
import com.entity.YonghuEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.TokenDao;
import com.entity.TokenEntity;
import com.entity.TokenEntity;
import com.service.TokenService;
import com.utils.CommonUtil;
import com.utils.PageUtils;
import com.utils.Query;


/**
 * token
 */
@Service("tokenService")
public class TokenServiceImpl extends ServiceImpl<TokenDao, TokenEntity> implements TokenService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private YonghuDao yonghuDao;

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<TokenEntity> page = this.selectPage(
                new Query<TokenEntity>(params).getPage(),
                new EntityWrapper<TokenEntity>()
        );
        return new PageUtils(page);
	}

	@Override
	public List<TokenEntity> selectListView(Wrapper<TokenEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PageUtils queryPage(Map<String, Object> params,
			Wrapper<TokenEntity> wrapper) {
		 Page<TokenEntity> page =new Query<TokenEntity>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
	}

	@Override
	public String generateToken(Long userid,String username, String tableName, String role) {
		TokenEntity tokenEntity = this.selectOne(new EntityWrapper<TokenEntity>().eq("userid", userid).eq("role", role));
		String token = CommonUtil.getRandomString(32);
		Calendar cal = Calendar.getInstance();   
    	cal.setTime(new Date());   
    	cal.add(Calendar.HOUR_OF_DAY, 1);
		if(tokenEntity!=null) {
			tokenEntity.setToken(token);
			tokenEntity.setExpiratedtime(cal.getTime());
			this.updateById(tokenEntity);
		} else {
			this.insert(new TokenEntity(userid,username, tableName, role, token, cal.getTime()));
		}
		return token;
	}

	@Override
	public TokenEntity getTokenEntity(String token) {
		TokenEntity tokenEntity = this.selectOne(new EntityWrapper<TokenEntity>().eq("token", token));
		if(tokenEntity == null || tokenEntity.getExpiratedtime().getTime()<new Date().getTime()) {
			if (ObjectUtil.isNotNull(tokenEntity) && StringUtils.isNotBlank(tokenEntity.getUsername())) {
				UserEntity user = new UserEntity();
				user.setUserStateId(1);
				userDao.update(user, new EntityWrapper<UserEntity>().eq("username", tokenEntity.getUsername()));
				YonghuEntity yonghuEntity = new YonghuEntity();
				yonghuEntity.setUserStateId(1);
				yonghuDao.update(yonghuEntity, new EntityWrapper<YonghuEntity>().eq("username", tokenEntity.getUsername()));
			}
			return null;
		}
		return tokenEntity;
	}
}
