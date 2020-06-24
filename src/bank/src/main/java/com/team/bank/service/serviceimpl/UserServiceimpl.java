package com.team.bank.service.serviceimpl;

import com.team.bank.enums.ResultEnum;
import com.team.bank.model.User;
import com.team.bank.service.UserService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @title: UserServiceimpl
 * @package com.team.bank.service.serviceimpl
 * @description: 这里写方法的具体实现。我们使用接口就是为了能够更好的处理多继承问题。
 * @author: fengluo
 * @date: 2020/6/25 2:10
*/

@Service("userServerImpl")
public class UserServiceimpl implements UserService {
    @Override
    public ResultEnum method(User user,JSONObject jsReply) throws Exception {
        if(StringUtils.isEmpty(user.getUsrName())){
            return ResultEnum.USR_ERROR;
        }
        if(StringUtils.isEmpty(user.getUsrPwd())){
            return ResultEnum.PWD_ERROR;
        }
        String userName = user.getUsrName();
        String password = user.getUsrPwd();
        jsReply.put("username", userName);
        jsReply.put("password", password);
        return ResultEnum.SUCCESS;
    }
}
