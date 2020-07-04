package com.team.bank.mapper;

import com.team.bank.model.AdminFreeze;
import com.team.bank.model.LqUser;
import com.team.bank.model.LqUserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AdminChangeMapper {
    @Select("SELECT COUNT(*) FROM lq_userinfo WHERE username = #{name}")
    Integer isExisted(LqUserInfo lqUserInfo);

    @Update("UPDATE lq_userinfo SET mobile = #{mobile} WHERE username = #{name}")
    void changeMobile(LqUserInfo lqUserInfo);

    @Update("UPDATE lq_userinfo SET email = #{email} WHERE username = #{name}")
    void changeEmail(LqUserInfo lqUserInfo);
}
