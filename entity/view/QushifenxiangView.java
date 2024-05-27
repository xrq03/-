package com.entity.view;

import com.entity.QushifenxiangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 趣事分享
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-04-11 15:24:59
 */
@TableName("qushifenxiang")
public class QushifenxiangView  extends QushifenxiangEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public QushifenxiangView(){
	}
 
 	public QushifenxiangView(QushifenxiangEntity qushifenxiangEntity){
 	try {
			BeanUtils.copyProperties(this, qushifenxiangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
