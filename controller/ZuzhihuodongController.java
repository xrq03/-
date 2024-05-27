package com.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.HybridRecommendation;
import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.YonghuEntity;
import com.entity.ZuzhihuodongEntity;
import com.entity.ZuzhihuodongEntity;
import com.entity.ZuzhihuodongrenyuanEntity;
import com.entity.view.QitaView;
import com.entity.view.QushifenxiangView;
import com.entity.view.YonghuView;
import com.entity.view.ZuzhihuodongView;
import com.service.StoreupService;
import com.service.YonghuService;
import com.service.ZuzhihuodongService;
import com.service.ZuzhihuodongrenyuanService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 其他
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-11 15:24:59
 */
@RestController
@RequestMapping("/zuzhihuodong")
public class ZuzhihuodongController {
    @Autowired
    private ZuzhihuodongService zuzhihuodongService;


    @Autowired
    private StoreupService storeupService;

    @Resource
    private YonghuService yonghuService;

    @Resource
    private ZuzhihuodongrenyuanService zuzhihuodongrenyuanService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, ZuzhihuodongEntity qita,
                  HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			qita.setUsername((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZuzhihuodongEntity> ew = new EntityWrapper<ZuzhihuodongEntity>();
		PageUtils page = zuzhihuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qita), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZuzhihuodongEntity qita, 
		HttpServletRequest request){
        EntityWrapper<ZuzhihuodongEntity> ew = new EntityWrapper<ZuzhihuodongEntity>();
        ew.gt("starttime", new Date());//开始时间大于当前时间
		PageUtils page = zuzhihuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qita), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZuzhihuodongEntity qita){
       	EntityWrapper<ZuzhihuodongEntity> ew = new EntityWrapper<ZuzhihuodongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( qita, "qita")); 
        return R.ok().put("data", zuzhihuodongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZuzhihuodongEntity qita){
        EntityWrapper< ZuzhihuodongEntity> ew = new EntityWrapper< ZuzhihuodongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( qita, "qita")); 
		ZuzhihuodongView qitaView =  zuzhihuodongService.selectView(ew);
		return R.ok("查询其他成功").put("data", qitaView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZuzhihuodongEntity qita = zuzhihuodongService.selectById(id);
        return R.ok().put("data", qita);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZuzhihuodongEntity qita = zuzhihuodongService.selectById(id);
        return R.ok().put("data", qita);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R thumbsup(@PathVariable("id") String id,String type){
        ZuzhihuodongEntity qita = zuzhihuodongService.selectById(id);
        if(type.equals("1")) {
        	qita.setThumbsupnum(qita.getThumbsupnum()+1);
        } else {
        	qita.setCrazilynum(qita.getCrazilynum()+1);
        }
        zuzhihuodongService.updateById(qita);
        return R.ok();
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZuzhihuodongEntity qita, HttpServletRequest request){
    	qita.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(qita);

        zuzhihuodongService.insert(qita);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
	@IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody ZuzhihuodongEntity qita, HttpServletRequest request){
    	qita.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(qita);

        zuzhihuodongService.insert(qita);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ZuzhihuodongEntity qita, HttpServletRequest request){
        //ValidatorUtils.validateEntity(qita);
        zuzhihuodongService.updateById(qita);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zuzhihuodongService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<ZuzhihuodongEntity> wrapper = new EntityWrapper<ZuzhihuodongEntity>();
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

		int count = zuzhihuodongService.selectCount(wrapper);
		return R.ok().put("count", count);
	}




    @PostMapping(value = "/accept")
    public R accept(@RequestBody ZuzhihuodongEntity zuzhihuodongEntity, HttpServletRequest request) {
        String username = (String)request.getSession().getAttribute("username");
        String phone = null;
        String yonghuxingming = null;
        if (username != null) {
            Wrapper<YonghuEntity> wrapper = new EntityWrapper<>();
            wrapper.eq("username", username);
            YonghuView yonghuView = yonghuService.selectView(wrapper);
            phone=yonghuView.getLianxifangshi();
            yonghuxingming = yonghuView.getYonghuxingming();
            ZuzhihuodongrenyuanEntity renyuan = new ZuzhihuodongrenyuanEntity();
            Wrapper<ZuzhihuodongrenyuanEntity> ew = new EntityWrapper<>();
            ew.eq("username", username);
            ew.eq("zuzhihuodongid", zuzhihuodongEntity.getId());
            Wrapper<ZuzhihuodongrenyuanEntity> rap = MPUtil.allEq(ew, renyuan);
            ZuzhihuodongrenyuanEntity renyuanxinxi = zuzhihuodongrenyuanService.selectOne(rap);
            if (renyuanxinxi == null) {
                renyuan.setYonghuxingming(yonghuxingming);
                renyuan.setAddtime(new Date());
                renyuan.setZuzhihuodongid(zuzhihuodongEntity.getId());
                renyuan.setYonghuxingming(username);
                renyuan.setUsername(username);
                renyuan.setLianxifangshi(phone);
                zuzhihuodongrenyuanService.insert(renyuan);
            }
            return R.ok("报名成功！");
        }else {
            return R.error("用户还未登录！");
        }
    }


    //取消报名
    @PostMapping(value = "/cancel")
    public R cancel(@RequestBody ZuzhihuodongEntity zuzhihuodongEntity, HttpServletRequest request) {
        String username = (String)request.getSession().getAttribute("username");
        if (username != null) {
            ZuzhihuodongrenyuanEntity renyuan = new ZuzhihuodongrenyuanEntity();
            Wrapper<ZuzhihuodongrenyuanEntity> ew = new EntityWrapper<>();
            ew.eq("username", username);
            ew.eq("zuzhihuodongid", zuzhihuodongEntity.getId());
            Wrapper<ZuzhihuodongrenyuanEntity> rap = MPUtil.allEq(ew, renyuan);
            zuzhihuodongrenyuanService.delete(rap);
            return R.ok("取消报名成功！");
        }else {
            return R.error("取消报名失败！");
        }
    }



    @GetMapping(value = "/recommend")
    public R recommend(HttpServletRequest request) {
        String tableName = request.getSession().getAttribute("tableName").toString();
        String username = null;
        if(tableName.equals("yonghu")) {
            username = String.valueOf((Long) request.getSession().getAttribute("userId"));
        }
        //CollaborativeFiltering collaborativeFiltering = new CollaborativeFiltering();
        Map<String, Map<String, Set<Integer>>> userTopicPreferences = storeupService.getUserTopicPreferences("zuzhihuodong");
        //权重占比
        HybridRecommendation hybridRecommendation = new HybridRecommendation(0.7, 0.3, userTopicPreferences);
        //collaborativeFiltering.setUserTopicPreferences(userTopicPreferences);
        //推荐前十条
        //List<String> names = collaborativeFiltering.generateRecommendations(username, 10);
        List<String> names = hybridRecommendation.generateRecommendations(username, 10);
        List<ZuzhihuodongView> list=null;
        if (CollectionUtil.isNotEmpty(names)) {
            list= zuzhihuodongService.selectListViewByNames(names);
        }else {
            list = Collections.emptyList();
        }
        return R.ok().put("data", list);
    }
}
