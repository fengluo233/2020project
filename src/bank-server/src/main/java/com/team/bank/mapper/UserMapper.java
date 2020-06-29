package com.team.bank.mapper;


import com.team.bank.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

/**
 * @title: UserMapper
 * @package com.team.bank.mapper
 * @description: Mapper层就是Dao层，这里我们主要写数据库的各种操作，增删查改之类，然后在service进行调用。因为写这个的时候没能拿
 * 到数据库的接口，所以暂且搁置
 * @author: fengluo
 * @date: 2020/6/25 2:36 
*/
@Mapper
public interface UserMapper {
    @Insert("INSERT INTO user(username, password) VALUES (#{usrName}, #{usrPwd})")
    int addUser(User user);
}
