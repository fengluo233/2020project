package com.team.bank.service;

import com.team.bank.enums.AdminResultEnum;
import com.team.bank.model.LqUser;
import com.team.bank.model.ReturnObject;

public interface AdminChangeCheckService {
    public AdminResultEnum AdminChangeCheck(LqUser lqUser, ReturnObject returnObject);
}
