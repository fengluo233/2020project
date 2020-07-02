package com.team.bank.service;

import com.alibaba.fastjson.JSONObject;
import com.team.bank.enums.AdminResultEnum;
import com.team.bank.model.LqUser;
import com.team.bank.model.ReturnObject;

public interface AdminResetpwdService {
    public AdminResultEnum ResetpwdAdmin(LqUser lqUser, ReturnObject returnObject);
}
