package com.team.bank.service;

import com.team.bank.enums.AdminResultEnum;
import com.team.bank.model.LqUserInfo;
import com.team.bank.model.ReturnObject;

public interface AdminLostService {
    public AdminResultEnum LostAdmin(LqUserInfo lqUserInfo , ReturnObject returnObject);
}
