package com.dao;

import com.config.MyStringArrayTypeHandler;
import com.entity.StoreupEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import com.entity.vo.UserData;
import org.apache.ibatis.annotations.Param;
import com.entity.vo.StoreupVO;
import com.entity.view.StoreupView;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;


/**
 * 收藏表
 * 
 * @author 
 * @email 
 * @date 2022-04-11 15:24:59
 */
public interface StoreupDao extends BaseMapper<StoreupEntity> {
	
	List<StoreupVO> selectListVO(@Param("ew") Wrapper<StoreupEntity> wrapper);
	
	StoreupVO selectVO(@Param("ew") Wrapper<StoreupEntity> wrapper);
	
	List<StoreupView> selectListView(@Param("ew") Wrapper<StoreupEntity> wrapper);

	List<StoreupView> selectListView(Pagination page,@Param("ew") Wrapper<StoreupEntity> wrapper);
	
	StoreupView selectView(@Param("ew") Wrapper<StoreupEntity> wrapper);

	@Results(id = "userDataResult", value = {
			@Result(property = "userid", column = "userid"),
			@Result(property = "name", column = "name"),
			@Result(property = "types", column = "types", javaType = String.class, typeHandler = MyStringArrayTypeHandler.class)
	})
	@Select("SELECT userid, name, GROUP_CONCAT(type) AS types FROM storeup WHERE tablename = #{tablename} GROUP BY userid, name")
	List<UserData> getUserData(@Param("tablename") String tablename);
}
