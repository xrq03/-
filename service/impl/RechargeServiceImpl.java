package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.RechargeDao;
import com.dao.UsermoneyDao;
import com.dao.YonghuDao;
import com.entity.DiscusszufangxinxiEntity;
import com.entity.RechargeEntity;
import com.entity.UsermoneyEntity;
import com.entity.YonghuEntity;
import com.entity.view.YonghuView;
import com.entity.vo.YonghuVO;
import com.service.RechargeService;
import com.service.YonghuService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("rechargeService")
public class RechargeServiceImpl extends ServiceImpl<RechargeDao, RechargeEntity> implements RechargeService {

    @Resource
    private UsermoneyDao usermoneyDao;

    @Override
    @Transactional
    public int rechargeMoney(RechargeEntity rechargeEntity) {
        rechargeEntity.setPaydate(new Date());
        Integer i = baseMapper.insert(rechargeEntity);
        if (i > 0) {
            UsermoneyEntity entity = usermoneyDao.lookMoney(rechargeEntity.getUsername());
            if (entity != null) {
                entity.setAccount(entity.getAccount() + rechargeEntity.getPaymoney());
                usermoneyDao.updateById(entity);
            }else{
                usermoneyDao.insert(new UsermoneyEntity().setUsername(rechargeEntity.getUsername()).setAccount(rechargeEntity.getPaymoney()));
            }
        }
        return i;
    }

    @Override
    public UsermoneyEntity lookMoney(String username) {
        UsermoneyEntity entity = usermoneyDao.lookMoney(username);
        return entity;

    }
}
