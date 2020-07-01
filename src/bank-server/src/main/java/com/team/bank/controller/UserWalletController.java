package com.team.bank.controller;

import com.team.bank.enums.ResultEnum;
import com.team.bank.model.ReturnObject;
import com.team.bank.service.UserInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserWalletController {
    @Resource(name = "userInfoServerimpl")
    private UserInfoService userInfoService;

    @RequestMapping(value = "/api/personal/wallet",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ReturnObject register(String mobile) {
        ReturnObject returnObject = new ReturnObject();
        ResultEnum resultEnum = userInfoService.GetExpense(mobile,returnObject);
        if(resultEnum.getCode()!=0){
            returnObject.setSuccess(false);
        }
        return returnObject;
    }
}
