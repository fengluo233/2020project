package com.team.bank.service;

import com.team.bank.enums.AdminResultEnum;
import com.team.bank.model.LqUserInfo;

public interface AdminChangeService {
    public AdminResultEnum changeUserInfo( LqUserInfo lqUserInfo);
}
