package com.team.bank.controller;

import com.team.bank.enums.ResultEnum;
import com.team.bank.model.LqUserInfo;
import com.team.bank.model.ReturnObject;
import com.team.bank.service.UserInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class GetUserInfoController {
    @Resource(name = "userInfoServerimpl")
    private UserInfoService userInfoService;

    @RequestMapping(value = "/api/personal/info",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ReturnObject getUserInfo(String mobile) {
        ReturnObject returnObject = new ReturnObject();
        ResultEnum resultEnum = userInfoService.GetInfoUser(mobile, returnObject);
        if(resultEnum.getCode()!=0){
            returnObject.setSuccess(false);
        }
        return returnObject;
    }

    @RequestMapping(value = "/api/personal/mobile",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ReturnObject getSimpleInfo(String mobile) {
        ReturnObject returnObject = new ReturnObject();
        ResultEnum resultEnum = userInfoService.GetUserName(mobile, returnObject);
        if(resultEnum.getCode()!=0){
            returnObject.setSuccess(false);
        }
        return returnObject;
    }

}
