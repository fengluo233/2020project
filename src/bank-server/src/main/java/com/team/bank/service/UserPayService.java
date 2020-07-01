package com.team.bank.service;

import com.alibaba.fastjson.JSONObject;
import com.team.bank.enums.ResultEnum;
import com.team.bank.model.ReturnObject;

public interface UserPayService {
    public ResultEnum UserPay(JSONObject jsonObject, ReturnObject returnObject);
}
