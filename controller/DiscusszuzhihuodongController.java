package com.controller;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.DiscusszuzhihuodongEntity;
import com.entity.DiscusszuzhihuodongEntity;
import com.entity.view.DiscussqitaView;
import com.entity.view.DiscusszuzhihuodongView;
import com.service.DiscusszuzhihuodongService;
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
 * 其他评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-11 15:24:59
 */
@RestController
@RequestMapping("/discusszuzhihuodong")
public class DiscusszuzhihuodongController {
    @Autowired
    private DiscusszuzhihuodongService discusszuzhihuodongService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, DiscusszuzhihuodongEntity discussqita,
                  HttpServletRequest request){

        EntityWrapper<DiscusszuzhihuodongEntity> ew = new EntityWrapper<DiscusszuzhihuodongEntity>();
		PageUtils page = discusszuzhihuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussqita), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscusszuzhihuodongEntity discussqita, 
		HttpServletRequest request){
        EntityWrapper<DiscusszuzhihuodongEntity> ew = new EntityWrapper<DiscusszuzhihuodongEntity>();
		PageUtils page = discusszuzhihuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussqita), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscusszuzhihuodongEntity discussqita){
       	EntityWrapper<DiscusszuzhihuodongEntity> ew = new EntityWrapper<DiscusszuzhihuodongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussqita, "discussqita")); 
        return R.ok().put("data", discusszuzhihuodongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscusszuzhihuodongEntity discussqita){
        EntityWrapper< DiscusszuzhihuodongEntity> ew = new EntityWrapper< DiscusszuzhihuodongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussqita, "discussqita")); 
		DiscusszuzhihuodongView discussqitaView =  discusszuzhihuodongService.selectView(ew);
		return R.ok("查询其他评论表成功").put("data", discussqitaView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscusszuzhihuodongEntity discussqita = discusszuzhihuodongService.selectById(id);
        return R.ok().put("data", discussqita);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscusszuzhihuodongEntity discussqita = discusszuzhihuodongService.selectById(id);
        return R.ok().put("data", discussqita);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscusszuzhihuodongEntity discussqita, HttpServletRequest request){
    	discussqita.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussqita);

        discusszuzhihuodongService.insert(discussqita);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscusszuzhihuodongEntity discussqita, HttpServletRequest request){
    	discussqita.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussqita);

        discusszuzhihuodongService.insert(discussqita);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DiscusszuzhihuodongEntity discussqita, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussqita);
        discusszuzhihuodongService.updateById(discussqita);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discusszuzhihuodongService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<DiscusszuzhihuodongEntity> wrapper = new EntityWrapper<DiscusszuzhihuodongEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = discusszuzhihuodongService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
