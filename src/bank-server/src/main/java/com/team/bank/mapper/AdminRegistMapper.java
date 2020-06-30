package com.team.bank.mapper;

import com.team.bank.model.Administrator;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminRegistMapper {
    @Insert("INSERT INTO lq_administrator(adminname,adminpwd,jobnumber) VALUES (#{adminName},#{adminPwd},#{jobNum})")
    int addAdminstrator(Administrator administrator);
}
