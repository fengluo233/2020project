package com.team.bank.service;

import com.team.bank.enums.ResultEnum;
import com.team.bank.model.lqUserInfo;

import javax.xml.transform.Result;

public interface UserInfoService {
    public ResultEnum RegisterUser (lqUserInfo lqUserInfo);
}
