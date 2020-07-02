package com.team.bank.mapper;

import com.team.bank.model.LqUser;
import com.team.bank.model.LqUserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AdminResetpwdMapper {
    @Update("UPDATE lq_user SET pd = #{password} WHERE username = #{username}")
    void resetPassword(LqUser lqUser);
}
