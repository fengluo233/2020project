package com.team.bank.service;

import com.team.bank.enums.AdminResultEnum;
import com.team.bank.model.Administrator;
import com.team.bank.model.ReturnObject;

public interface AdminLoginService {
    public AdminResultEnum LoginAdmin(Administrator administrator, ReturnObject returnObject);
}
