package com.team.bank.service;

import com.team.bank.enums.ComResultEnum;
import com.team.bank.model.ComUser;

public interface ComUserService {
    public ComResultEnum insertComUser(ComUser comUser) throws Exception;
}