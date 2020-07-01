package com.team.bank.service;

import com.team.bank.enums.ResultEnum;
import com.team.bank.model.LqUser;
import com.team.bank.model.LqUserInfo;
import com.team.bank.model.ReturnObject;

public interface UserInfoService {
    public ResultEnum RegisterUser (LqUserInfo lqUserInfo);
    public ResultEnum LoginUser (LqUser lqUser, ReturnObject returnObject);
    public ResultEnum GetInfoUser(String mobile, ReturnObject returnObject);
    public ResultEnum GetExpense(String mobile, ReturnObject returnObject);
}
