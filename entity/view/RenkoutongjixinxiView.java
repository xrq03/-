package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.LoufangxinxiEntity;
import com.entity.RenkoutongjixinxiEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;


/**
 * 楼房信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-04-11 15:24:59
 */
@TableName("renkoutongjixinxi")
public class RenkoutongjixinxiView extends RenkoutongjixinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public RenkoutongjixinxiView(){
	}

 	public RenkoutongjixinxiView(LoufangxinxiEntity zufangxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, zufangxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
