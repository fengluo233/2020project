package com.team.bank.controller;

import com.team.bank.enums.ComResultEnum;
import com.team.bank.model.ComUser;
import com.team.bank.model.ReturnObject;
import com.team.bank.service.ComUserInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ComLoginController {
    @Resource(name = "comUserInfoServerimpl")
    private ComUserInfoService comUserInfoService;

    @RequestMapping(value = "/api/login",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ReturnObject login(ComUser comUser){
        String number = "";
        ReturnObject returnObject = new ReturnObject();
        ComResultEnum comResultEnum = comUserInfoService.LoginComUser(comUser, returnObject);
        if (comResultEnum.getCode() != 0) {
            System.out.println(comResultEnum.getMessage());
        }
        return returnObject;
    }
}
