package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.entity.RechargeEntity;
import com.entity.UsermoneyEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


/**
 * 用户
 * 
 * @author 
 * @email 
 * @date 2022-04-11 15:24:59
 */
public interface UsermoneyDao extends BaseMapper<UsermoneyEntity> {


    @Select(" select * from usermoney where username = #{username}")
    UsermoneyEntity lookMoney(@Param("username") String username);

    @Override
    Integer insert(UsermoneyEntity usermoneyEntity);
}
