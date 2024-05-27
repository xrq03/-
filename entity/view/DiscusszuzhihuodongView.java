package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.DiscussqitaEntity;
import com.entity.DiscusszuzhihuodongEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;


/**
 * 其他评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-04-11 15:24:59
 */
@TableName("discusszuzhihuodong")
public class DiscusszuzhihuodongView extends DiscusszuzhihuodongEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusszuzhihuodongView(){
	}

 	public DiscusszuzhihuodongView(DiscusszuzhihuodongEntity discussqitaEntity){
 	try {
			BeanUtils.copyProperties(this, discussqitaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
