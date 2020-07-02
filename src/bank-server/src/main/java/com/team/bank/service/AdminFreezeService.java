package com.team.bank.service;

import com.team.bank.enums.AdminResultEnum;
import com.team.bank.model.AdminFreeze;
import com.team.bank.model.ReturnObject;

public interface AdminFreezeService {
    public AdminResultEnum freezeUser(AdminFreeze adminFreeze, ReturnObject returnObject);
}
