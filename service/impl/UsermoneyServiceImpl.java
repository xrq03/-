package com.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.RechargeDao;
import com.dao.UsermoneyDao;
import com.entity.RechargeEntity;
import com.entity.UsermoneyEntity;
import com.service.RechargeService;
import com.service.UsermoneyService;
import org.springframework.stereotype.Service;

@Service("usermoneyService")
public class UsermoneyServiceImpl extends ServiceImpl<UsermoneyDao, UsermoneyEntity> implements UsermoneyService {
	

}
