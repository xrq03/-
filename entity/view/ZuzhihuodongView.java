package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.QitaEntity;
import com.entity.ZuzhihuodongEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;


/**
 * 组织活动
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-04-11 15:24:59
 */
@TableName("zuzhihuodong")
public class ZuzhihuodongView extends ZuzhihuodongEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZuzhihuodongView(){
	}

 	public ZuzhihuodongView(ZuzhihuodongEntity qitaEntity){
 	try {
			BeanUtils.copyProperties(this, qitaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
