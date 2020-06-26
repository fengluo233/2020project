package com.team.bank.service.serviceimpl;

import com.team.bank.enums.ResultEnum;
import com.team.bank.mapper.UserMapper;
import com.team.bank.model.User;
import com.team.bank.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * @title: UserServiceimpl
 * @package com.team.bank.service.serviceimpl
 * @description: 这里写方法的具体实现。我们使用接口就是为了能够更好的处理多继承问题。
 * @author: fengluo
 * @date: 2020/6/25 2:10
*/

@Service("userServerImpl")
public class UserServiceimpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public ResultEnum insertUser(User user) throws Exception {
        if(StringUtils.isEmpty(user.getUsrName())){
            return ResultEnum.USR_ERROR;
        }
        if(StringUtils.isEmpty(user.getUsrPwd())){
            return ResultEnum.PWD_ERROR;
        }
        userMapper.addUser(user);
        return ResultEnum.SUCCESS;
    }
}
