package com.entity.view;

import com.entity.DiscusstingcheweichuzuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 停车位出租评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-04-11 15:24:59
 */
@TableName("discusstingcheweichuzu")
public class DiscusstingcheweichuzuView  extends DiscusstingcheweichuzuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusstingcheweichuzuView(){
	}
 
 	public DiscusstingcheweichuzuView(DiscusstingcheweichuzuEntity discusstingcheweichuzuEntity){
 	try {
			BeanUtils.copyProperties(this, discusstingcheweichuzuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
