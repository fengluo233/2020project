package com.team.bank.service;

import com.team.bank.model.LqUserInfo;
import com.team.bank.model.ReturnObject;

public interface AdminCheckService {
    public ReturnObject CheckAdmin(LqUserInfo lqUserInfo);
}
