package com.entity.view;

import com.entity.ChongwudailiuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 宠物代遛
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-04-11 15:24:59
 */
@TableName("chongwudailiu")
public class ChongwudailiuView  extends ChongwudailiuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ChongwudailiuView(){
	}
 
 	public ChongwudailiuView(ChongwudailiuEntity chongwudailiuEntity){
 	try {
			BeanUtils.copyProperties(this, chongwudailiuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
