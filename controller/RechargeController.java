package com.controller;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.RechargeEntity;
import com.entity.UsermoneyEntity;
import com.entity.YonghuEntity;
import com.entity.view.YonghuView;
import com.service.RechargeService;
import com.service.TokenService;
import com.service.YonghuService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * 用户
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-11 15:24:59
 */
@RestController
@RequestMapping("/recharge")
public class RechargeController {

    @Resource
    private RechargeService rechargeService;

    @PostMapping("/rechargemoney")
    public R rechargeMoney(@RequestBody RechargeEntity rechargeEntity, HttpServletRequest request) {
        int i = rechargeService.rechargeMoney(rechargeEntity);
        return R.ok();
    }


    @GetMapping(value = "/lookmoney")
    public R lookmoney(HttpServletRequest request,String username) {
        UsermoneyEntity usermoneyEntity = rechargeService.lookMoney(username);
        double money = 0.0;
        if (usermoneyEntity != null) {
            money = usermoneyEntity.getAccount();
        }
        return R.ok().put("data", money);
    }


}
