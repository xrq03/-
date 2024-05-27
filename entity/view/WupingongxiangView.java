package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.ChongwudailiuEntity;
import com.entity.WupingongxiangEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;


/**
 * 宠物代遛
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-04-11 15:24:59
 */
@TableName("wupingongxiang")
public class WupingongxiangView extends WupingongxiangEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public WupingongxiangView(){
	}

 	public WupingongxiangView(WupingongxiangEntity chongwudailiuEntity){
 	try {
			BeanUtils.copyProperties(this, chongwudailiuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
