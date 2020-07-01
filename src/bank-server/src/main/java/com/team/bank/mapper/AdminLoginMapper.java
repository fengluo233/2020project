package com.team.bank.mapper;

import com.team.bank.model.Administrator;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminLoginMapper {

    @Select("SELECT COUNT(*) FROM lq_administrator WHERE (adminname = #{adminPwd} adminpwd = #{adminPwd})")
    Integer adminLogin(Administrator administrator);

    @Select("SELECT jobnumber FROM lq_administrator WHERE adminname = #{adminName}")
    String getJobnum(Administrator administrator);
}
