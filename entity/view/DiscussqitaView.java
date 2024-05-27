package com.entity.view;

import com.entity.DiscussqitaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 其他评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-04-11 15:24:59
 */
@TableName("discussqita")
public class DiscussqitaView  extends DiscussqitaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussqitaView(){
	}
 
 	public DiscussqitaView(DiscussqitaEntity discussqitaEntity){
 	try {
			BeanUtils.copyProperties(this, discussqitaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
