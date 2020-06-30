package com.team.bank.mapper;

import org.apache.ibatis.annotations.*;
import com.team.bank.model.*;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    @Insert("INSERT INTO lq_userinfo(username, mobile, email, cardnum) VALUES (#{username}, #{mobile}, #{email}, #{cardnum})")
    int addUserInfo(LqUserInfo lqUserInfo);

    @Select("SELECT COUNT(*) FROM lq_userinfo WHERE mobile = #{mobile}")
    Integer isUsed(String mobile);

    @Insert("INSERT INTO lq_user(username,pd) VALUES (#{username}, #{password})")
    int addUserPwd(LqUserInfo lqUserInfo);

    @Select("SELECT COUNT(*) FROM lq_user WHERE (username = #{username} AND pd = #{password})")
    Integer checkLogin(LqUser lqUser);

    @Select("SELECT mobile from lq_userinfo WHERE username = #{username}")
    String getMobile(LqUser lqUser);

}
