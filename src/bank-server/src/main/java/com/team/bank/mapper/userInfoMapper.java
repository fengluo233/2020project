package com.team.bank.mapper;

import org.apache.ibatis.annotations.*;
import com.team.bank.model.*;

@Mapper
public interface userInfoMapper {

    @Insert("INSERT INTO lq_userinfo(username, mobile, email, cardnum) VALUES (#{username}, #{mobile}, #{email}, #{cardnum})")
    int addUserInfo(lqUserInfo lqUserInfo);

    @Select("SELECT COUNT(*) FROM lq_userinfo WHERE mobile = #{mobile}")
    Integer isUsed(String mobile);

    @Insert("INSERT INTO lq_user(username,pd) VALUES (#{username}, #{password})")
    int addUserPwd(lqUserInfo lqUserInfo);
}
