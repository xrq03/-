package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import cn.hutool.core.collection.CollectionUtil;
import com.CollaborativeFiltering;
import com.HybridRecommendation;
import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.QushifenxiangEntity;
import com.entity.view.QushifenxiangView;

import com.service.QushifenxiangService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 趣事分享
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-11 15:24:59
 */
@RestController
@RequestMapping("/qushifenxiang")
public class QushifenxiangController {
    @Autowired
    private QushifenxiangService qushifenxiangService;


    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,QushifenxiangEntity qushifenxiang, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			qushifenxiang.setusername((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<QushifenxiangEntity> ew = new EntityWrapper<QushifenxiangEntity>();
		PageUtils page = qushifenxiangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qushifenxiang), params), params));
        return R.ok().put("data", page);
    }


    @GetMapping(value = "/recommend")
    public R recommend(HttpServletRequest request) {
        String tableName = request.getSession().getAttribute("tableName").toString();
        String username = null;
        if(tableName.equals("yonghu")) {
            username = String.valueOf((Long) request.getSession().getAttribute("userId"));
        }
        //CollaborativeFiltering collaborativeFiltering = new CollaborativeFiltering();
        Map<String, Map<String, Set<Integer>>> userTopicPreferences = storeupService.getUserTopicPreferences("qushifenxiang");
        //权重占比
        HybridRecommendation hybridRecommendation = new HybridRecommendation(0.7, 0.3, userTopicPreferences);
        //collaborativeFiltering.setUserTopicPreferences(userTopicPreferences);
        //推荐前十条
        //List<String> names = collaborativeFiltering.generateRecommendations(username, 10);
        List<String> names = hybridRecommendation.generateRecommendations(username, 10);
        List<QushifenxiangView> list=null;
        if (CollectionUtil.isNotEmpty(names)) {
            list= qushifenxiangService.selectListViewByNames(names);
        }else {
            list = Collections.emptyList();
        }
        return R.ok().put("data", list);
    }
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,QushifenxiangEntity qushifenxiang, 
		HttpServletRequest request){
        EntityWrapper<QushifenxiangEntity> ew = new EntityWrapper<QushifenxiangEntity>();
		PageUtils page = qushifenxiangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qushifenxiang), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( QushifenxiangEntity qushifenxiang){
       	EntityWrapper<QushifenxiangEntity> ew = new EntityWrapper<QushifenxiangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( qushifenxiang, "qushifenxiang")); 
        return R.ok().put("data", qushifenxiangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(QushifenxiangEntity qushifenxiang){
        EntityWrapper< QushifenxiangEntity> ew = new EntityWrapper< QushifenxiangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( qushifenxiang, "qushifenxiang")); 
		QushifenxiangView qushifenxiangView =  qushifenxiangService.selectView(ew);
		return R.ok("查询趣事分享成功").put("data", qushifenxiangView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        QushifenxiangEntity qushifenxiang = qushifenxiangService.selectById(id);
        return R.ok().put("data", qushifenxiang);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        QushifenxiangEntity qushifenxiang = qushifenxiangService.selectById(id);
        return R.ok().put("data", qushifenxiang);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R thumbsup(@PathVariable("id") String id,String type){
        QushifenxiangEntity qushifenxiang = qushifenxiangService.selectById(id);
        if(type.equals("1")) {
        	qushifenxiang.setThumbsupnum(qushifenxiang.getThumbsupnum()+1);
        } else {
        	qushifenxiang.setCrazilynum(qushifenxiang.getCrazilynum()+1);
        }
        qushifenxiangService.updateById(qushifenxiang);
        return R.ok();
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody QushifenxiangEntity qushifenxiang, HttpServletRequest request){
    	qushifenxiang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(qushifenxiang);

        qushifenxiangService.insert(qushifenxiang);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
	@IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody QushifenxiangEntity qushifenxiang, HttpServletRequest request){
    	qushifenxiang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(qushifenxiang);

        qushifenxiangService.insert(qushifenxiang);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody QushifenxiangEntity qushifenxiang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(qushifenxiang);
        qushifenxiangService.updateById(qushifenxiang);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        qushifenxiangService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<QushifenxiangEntity> wrapper = new EntityWrapper<QushifenxiangEntity>();
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

		int count = qushifenxiangService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
