package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.DiscusschongwudailiuEntity;
import com.entity.DiscusswupingongxiangEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;


/**
 * 宠物代遛评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-04-11 15:24:59
 */
@TableName("discusswupingongxiang")
public class DiscusswupingongxiangView extends DiscusswupingongxiangEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusswupingongxiangView(){
	}

 	public DiscusswupingongxiangView(DiscusswupingongxiangEntity discusschongwudailiuEntity){
 	try {
			BeanUtils.copyProperties(this, discusschongwudailiuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
