package com.team.bank.service;

import com.team.bank.enums.AdminResultEnum;
import com.team.bank.model.Administrator;
import com.team.bank.model.ReturnObject;

public interface AdminRegistService {
    public ReturnObject RegisterAdminstrator(Administrator administrator);
}
