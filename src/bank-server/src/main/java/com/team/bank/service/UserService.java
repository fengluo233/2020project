package com.team.bank.service;

import com.team.bank.enums.ResultEnum;
import com.team.bank.model.User;

/**
 * @title: UserService
 * @package com.team.bank.service
 * @description: 方法的定义都放在
 * @author: fengluo
 * @date: 2020/6/25 2:40
*/
public interface UserService {
    public ResultEnum insertUser(User user) throws Exception;
}
