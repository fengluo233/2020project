package com.team.bank.mapper;

import com.team.bank.model.LqUserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminLostMapper {
    @Select("SELECT COUNT(*) FROM lq_userinfo WHERE (username = #{name} AND mobile = #{mobile} AND email = #{email} AND cardnum = #{cardnum})")
    Integer isRight(LqUserInfo lqUserInfo);
}
