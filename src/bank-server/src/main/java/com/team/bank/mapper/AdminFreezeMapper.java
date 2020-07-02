package com.team.bank.mapper;

import com.team.bank.model.AdminFreeze;
import com.team.bank.model.Administrator;
import com.team.bank.model.LqUser;
import com.team.bank.model.LqUserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AdminFreezeMapper {

    @Insert("INSERT INTO adminfreeze(username) VALUES (#{username})")
    int addAdminFreeze(LqUser lqUser);

    @Update("UPDATE adminfreeze SET isfrozen = 'YES' WHERE username = #{username}")
    void addIsfrozen(AdminFreeze adminFreeze);

    @Select("SELECT COUNT(*) FROM adminfreeze WHERE username = #{username}")
    Integer isExisted(AdminFreeze adminFreeze);
}
