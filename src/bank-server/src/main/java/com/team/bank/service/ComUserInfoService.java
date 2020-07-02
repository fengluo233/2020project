package com.team.bank.service;

import com.team.bank.enums.ComResultEnum;
import com.team.bank.model.*;

public interface ComUserInfoService {
    public ComResultEnum RegisterComUser (ComUserInfo comUserInfo);
    public ComResultEnum LoginComUser (ComUser comUser, ReturnObject returnObject);
    public ComResultEnum GetInfoComUser(String ID, ReturnObject returnObject);
}