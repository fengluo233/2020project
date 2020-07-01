package com.team.bank.service;

import com.team.bank.enums.AdminResultEnum;
import com.team.bank.model.LqAsset;
import com.team.bank.model.LqUserInfo;
import com.team.bank.model.ReturnObject;

public interface AdminCheckService {
    public AdminResultEnum CheckAdmin(LqUserInfo lqUserInfo, LqAsset lqAsset, ReturnObject returnObject);
}
