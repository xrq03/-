package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.entity.UsermoneyEntity;
import com.entity.YonghuEntity;
import com.entity.view.YonghuView;
import com.service.*;
import com.utils.ValidatorUtils;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ChongwudailiuEntity;
import com.entity.view.ChongwudailiuView;

import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import com.entity.StoreupEntity;

/**
 * 宠物代遛
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-11 15:24:59
 */
@RestController
@RequestMapping("/chongwudailiu")
public class ChongwudailiuController {
    @Autowired
    private ChongwudailiuService chongwudailiuService;


    @Autowired
    private StoreupService storeupService;

    @Resource
    private RechargeService rechargeService;

    @Resource
    private UsermoneyService usermoneyService;

    @Resource
    private YonghuService yonghuService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChongwudailiuEntity chongwudailiu, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			chongwudailiu.setusername((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ChongwudailiuEntity> ew = new EntityWrapper<ChongwudailiuEntity>();
        Wrapper<ChongwudailiuEntity> entityWrapper = null;
        if ("管理员".equals((String) request.getSession().getAttribute("role"))) {
            entityWrapper = MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chongwudailiu), params), params);
        }else {
             entityWrapper = MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chongwudailiu).or().eq("reciver",chongwudailiu.getusername()), params), params);
        }
        //entityWrapper.or().eq("reciver", chongwudailiu.getusername());
        PageUtils page = chongwudailiuService.queryPage(params, entityWrapper);
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ChongwudailiuEntity chongwudailiu, 
		HttpServletRequest request){
        EntityWrapper<ChongwudailiuEntity> ew = new EntityWrapper<ChongwudailiuEntity>();
        Wrapper<ChongwudailiuEntity> wrapper = MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chongwudailiu), params), params);
        wrapper.eq("nowstatus", 0);
        PageUtils page = chongwudailiuService.queryPage(params,wrapper);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChongwudailiuEntity chongwudailiu){
       	EntityWrapper<ChongwudailiuEntity> ew = new EntityWrapper<ChongwudailiuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( chongwudailiu, "chongwudailiu")); 
        return R.ok().put("data", chongwudailiuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChongwudailiuEntity chongwudailiu){
        EntityWrapper< ChongwudailiuEntity> ew = new EntityWrapper< ChongwudailiuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( chongwudailiu, "chongwudailiu")); 
		ChongwudailiuView chongwudailiuView =  chongwudailiuService.selectView(ew);
		return R.ok("查询宠物代遛成功").put("data", chongwudailiuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChongwudailiuEntity chongwudailiu = chongwudailiuService.selectById(id);
        return R.ok().put("data", chongwudailiu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChongwudailiuEntity chongwudailiu = chongwudailiuService.selectById(id);
        return R.ok().put("data", chongwudailiu);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R thumbsup(@PathVariable("id") String id,String type){
        ChongwudailiuEntity chongwudailiu = chongwudailiuService.selectById(id);
        if(type.equals("1")) {
        	chongwudailiu.setThumbsupnum(chongwudailiu.getThumbsupnum()+1);
        } else {
        	chongwudailiu.setCrazilynum(chongwudailiu.getCrazilynum()+1);
        }
        chongwudailiuService.updateById(chongwudailiu);
        return R.ok();
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @Transactional
    public R save(@RequestBody ChongwudailiuEntity chongwudailiu, HttpServletRequest request){
    	chongwudailiu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chongwudailiu);

        chongwudailiuService.insert(chongwudailiu);

        UsermoneyEntity usermoney = rechargeService.lookMoney(chongwudailiu.getusername());
        if (usermoney != null && usermoney.getAccount() >= chongwudailiu.getPrice()) {
            usermoney.setAccount(usermoney.getAccount()-chongwudailiu.getPrice());
            usermoneyService.updateById(usermoney);
        }else {
            return R.error("余额不足，请充值");
        }

        return R.ok();
    }

    @PostMapping(value = "/acceptOrder")
    public R acceptOrder(@RequestBody ChongwudailiuEntity chongwudailiu, HttpServletRequest request){
        String username = (String)request.getSession().getAttribute("username");
        String phone = null;
        if (username != null) {
            Wrapper<YonghuEntity> wrapper = new EntityWrapper<>();
            wrapper.eq("username", username);
            YonghuView yonghuView = yonghuService.selectView(wrapper);
            phone=yonghuView.getLianxifangshi();
        }
        chongwudailiu.setReciver(username).setReciverphone(phone).setNowstatus(1);
        chongwudailiuService.updateById(chongwudailiu);
        return R.ok("接单成功！");
    }
    
    /**
     * 前端保存
     */
	@IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody ChongwudailiuEntity chongwudailiu, HttpServletRequest request){
    	chongwudailiu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chongwudailiu);
        chongwudailiuService.insert(chongwudailiu);


        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ChongwudailiuEntity chongwudailiu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(chongwudailiu);
        chongwudailiuService.updateById(chongwudailiu);//全部更新
        return R.ok();
    }

    @Data
    static class Param{
        private Long id;
        private Integer nowstatus;
    }

    /**
     * 修改
     */
    @RequestMapping("/updateStatus")
    public R update(@RequestBody Param param, HttpServletRequest request){
        //ValidatorUtils.validateEntity(chongwudailiu);
        ChongwudailiuEntity chongwudailiu = chongwudailiuService.selectById(param.getId());
        if (param.getNowstatus().equals(3)) {
            UsermoneyEntity usermoney = rechargeService.lookMoney(chongwudailiu.getReciver());
            if (usermoney != null) {
                usermoney.setAccount(usermoney.getAccount()+chongwudailiu.getPrice());
                usermoneyService.updateById(usermoney);
            }
        }
        chongwudailiu.setNowstatus(param.getNowstatus());
        chongwudailiuService.updateById(chongwudailiu);//全部更新
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @Transactional
    public R delete(@RequestBody Long[] ids){

        for (Long id : Arrays.asList(ids)) {
            ChongwudailiuEntity chongwudailiu = chongwudailiuService.selectById(id);
            UsermoneyEntity usermoney = rechargeService.lookMoney(chongwudailiu.getusername());
            if (usermoney != null) {
                usermoney.setAccount(usermoney.getAccount()+chongwudailiu.getPrice());
                usermoneyService.updateById(usermoney);
            }
        }
        chongwudailiuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<ChongwudailiuEntity> wrapper = new EntityWrapper<ChongwudailiuEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			wrapper.eq("username", (String)request.getSession().getAttribute("username"));
		}

		int count = chongwudailiuService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
