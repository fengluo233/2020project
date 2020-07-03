package com.team.bank.service;

import com.team.bank.enums.AdminResultEnum;
import com.team.bank.model.LqUser;
import com.team.bank.model.LqUserInfo;
import com.team.bank.model.ReturnObject;

public interface AdminChangeService {
    public AdminResultEnum changeUserInfo(LqUserInfo lqUserInfo, ReturnObject returnObject);
}
