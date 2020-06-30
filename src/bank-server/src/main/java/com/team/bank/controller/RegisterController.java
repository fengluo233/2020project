package com.team.bank.controller;

import com.team.bank.enums.ResultEnum;
import com.team.bank.service.UserInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.team.bank.model.*;

import javax.annotation.Resource;

@RestController
public class RegisterController {
    @Resource(name = "userInfoServerimpl")
    private UserInfoService userInfoService;

    @RequestMapping(value = "/api/personal/user",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ReturnObject register(LqUserInfo lqUserInfo) {
        ResultEnum resultEnum = userInfoService.RegisterUser(lqUserInfo);
        ReturnObject returnObject = new ReturnObject();
        if(resultEnum.getCode() == 0){
            returnObject.setSuccess(true);
            returnObject.setError("");
        }else {
            returnObject.setSuccess(false);
            returnObject.setError(resultEnum.getMessage());
        }
        return returnObject;
    }
}
