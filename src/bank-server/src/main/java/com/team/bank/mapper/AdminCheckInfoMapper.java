package com.team.bank.mapper;

import com.team.bank.model.LqUserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminCheckInfoMapper {

    @Select("SELECT COUNT(*) FROM lq_userinfo WHERE mobile = #{mobile}")
    Integer isExisted(LqUserInfo lqUserInfo);

    @Select("SELECT email from lq_userinfo WHERE mobile = #{mobile}")
    String getEmail(LqUserInfo lqUserInfo);

    @Select("SELECT cardnum from lq_userinfo WHERE mobile = #{mobile}")
    String getCardnum(LqUserInfo lqUserInfo);

}
