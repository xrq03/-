package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.entity.RechargeEntity;
import com.entity.UsermoneyEntity;


/**
 * 用户
 *
 * @author 
 * @email 
 * @date 2022-04-11 15:24:59
 */
public interface UsermoneyService extends IService<UsermoneyEntity> {

    @Override
    boolean insert(UsermoneyEntity usermoneyEntity);
}

