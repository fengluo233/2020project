package com.team.bank.controller;

import com.team.bank.enums.ComResultEnum;
import com.team.bank.service.ComUserInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.team.bank.model.*;

import javax.annotation.Resource;

@RestController
public class ComRegisterController {
    @Resource(name = "comUserInfoServerimpl")
    private ComUserInfoService comUserInfoService;

    @RequestMapping(value = "/api/user",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ReturnObject register(ComUserInfo comUserInfo) {
        ComResultEnum comResultEnum = comUserInfoService.RegisterComUser(comUserInfo);
        ReturnObject returnObject = new ReturnObject();
        if(comResultEnum.getCode() == 0){
            returnObject.setSuccess(true);
            returnObject.setError("");
        }else {
            returnObject.setSuccess(false);
            returnObject.setError(comResultEnum.getMessage());
        }
        return returnObject;
    }
}
