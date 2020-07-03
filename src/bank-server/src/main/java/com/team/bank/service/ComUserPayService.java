package com.team.bank.service;

import com.alibaba.fastjson.JSONObject;
import com.team.bank.enums.ComResultEnum;
import com.team.bank.model.ReturnObject;

public interface ComUserPayService {
    public ComResultEnum ComUserPay(JSONObject jsonObject, ReturnObject returnObject);
}
