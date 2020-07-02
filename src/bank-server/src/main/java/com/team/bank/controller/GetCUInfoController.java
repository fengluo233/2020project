package com.team.bank.controller;

import com.team.bank.enums.ComResultEnum;
import com.team.bank.model.ComUserInfo;
import com.team.bank.model.ReturnObject;
import com.team.bank.service.ComUserInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class GetCUInfoController {
    @Resource(name = "comUserInfoServerimpl")
    private ComUserInfoService comUserInfoService;

    @RequestMapping(value = "/api/info",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ReturnObject getComUserInfo(String ID) {
        ReturnObject returnObject = new ReturnObject();
        ComResultEnum comResultEnum = comUserInfoService.GetInfoComUser(ID, returnObject);
        if(comResultEnum.getCode()!=0){
            returnObject.setSuccess(false);
        }
        return returnObject;
    }

}
