package com.team.bank.mapper;

import com.team.bank.model.ComUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

@Mapper
public interface ComUserMapper {
    @Insert("INSERT INTO com_user(ID, pwd) VALUES (#{ID}, #{pwd})")
    int addComUser(ComUser comUser);
}