package com.team.bank.controller;

import com.team.bank.enums.ResultEnum;
import com.team.bank.model.ReturnArray;
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
    public ReturnArray register(String mobile) {
        ReturnArray returnArray = new ReturnArray();
        ResultEnum resultEnum = userInfoService.GetExpense(mobile,returnArray);
        if(resultEnum.getCode()!=0){
            returnArray.setSuccess(false);
        }
        return returnArray;
    }
}
