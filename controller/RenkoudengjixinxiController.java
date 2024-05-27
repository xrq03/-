package com.controller;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.RenkoudengjixinxiEntity;
import com.entity.RenkoutongjixinxiEntity;
import com.entity.view.RenkoudengjixinxiView;
import com.entity.view.RenkoutongjixinxiView;
import com.service.RenkoudengjixinxiService;
import com.service.StoreupService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * 楼房信息
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-11 15:24:59
 */
@RestController
@RequestMapping("/renkoudengjixinxi")
public class RenkoudengjixinxiController {
    @Autowired
    private RenkoudengjixinxiService renkoudengjixinxiService;


    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, RenkoudengjixinxiEntity zufangxinxi,
                  HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			//zufangxinxi.setusername((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<RenkoudengjixinxiEntity> ew = new EntityWrapper<RenkoudengjixinxiEntity>();
		PageUtils page = renkoudengjixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zufangxinxi), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,RenkoudengjixinxiEntity zufangxinxi,
		HttpServletRequest request){
        EntityWrapper<RenkoudengjixinxiEntity> ew = new EntityWrapper<RenkoudengjixinxiEntity>();
		PageUtils page = renkoudengjixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zufangxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( RenkoudengjixinxiEntity zufangxinxi){
       	EntityWrapper<RenkoudengjixinxiEntity> ew = new EntityWrapper<RenkoudengjixinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zufangxinxi, "loufangxinxi"));
        return R.ok().put("data", renkoudengjixinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(RenkoudengjixinxiEntity zufangxinxi){
        EntityWrapper< RenkoudengjixinxiEntity> ew = new EntityWrapper<RenkoudengjixinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zufangxinxi, "zufangxinxi")); 
		RenkoudengjixinxiView zufangxinxiView =  renkoudengjixinxiService.selectView(ew);
		return R.ok("查询租房信息成功").put("data", zufangxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        RenkoudengjixinxiEntity zufangxinxi = renkoudengjixinxiService.selectById(id);
        return R.ok().put("data", zufangxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        RenkoudengjixinxiEntity zufangxinxi = renkoudengjixinxiService.selectById(id);
        return R.ok().put("data", zufangxinxi);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R thumbsup(@PathVariable("id") String id,String type){
        RenkoudengjixinxiEntity zufangxinxi = renkoudengjixinxiService.selectById(id);
        zufangxinxi = renkoudengjixinxiService.selectById(id);
        if(type.equals("1")) {
        	zufangxinxi.setThumbsupnum(zufangxinxi.getThumbsupnum()+1);
        } else {
        	zufangxinxi.setCrazilynum(zufangxinxi.getCrazilynum()+1);
        }
        renkoudengjixinxiService.updateById(zufangxinxi);
        return R.ok();
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody RenkoudengjixinxiEntity zufangxinxi, HttpServletRequest request){
    	zufangxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zufangxinxi);

        renkoudengjixinxiService.insert(zufangxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
	@IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody RenkoudengjixinxiEntity zufangxinxi, HttpServletRequest request){
    	zufangxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zufangxinxi);

        renkoudengjixinxiService.insert(zufangxinxi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody RenkoudengjixinxiEntity zufangxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zufangxinxi);
        renkoudengjixinxiService.updateById(zufangxinxi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        renkoudengjixinxiService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<RenkoudengjixinxiEntity> wrapper = new EntityWrapper<RenkoudengjixinxiEntity>();
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

		int count = renkoudengjixinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
