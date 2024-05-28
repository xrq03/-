package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.RechargeEntity;
import com.entity.UsermoneyEntity;
import com.entity.YonghuEntity;
import com.entity.view.YonghuView;
import com.entity.vo.YonghuVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 用户
 *
 * @author 
 * @email 
 * @date 2022-04-11 15:24:59
 */
public interface RechargeService extends IService<RechargeEntity> {


    public int rechargeMoney(RechargeEntity rechargeEntity);


    public UsermoneyEntity lookMoney(String username);


}

