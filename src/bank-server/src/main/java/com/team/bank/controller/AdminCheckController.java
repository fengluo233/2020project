package com.team.bank.controller;

import com.team.bank.enums.AdminResultEnum;
import com.team.bank.model.LqUser;
import com.team.bank.model.LqUserInfo;
import com.team.bank.model.ReturnObject;
import com.team.bank.service.AdminCheckService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class AdminCheckController {

    @Resource(name = "adminCheckServiceimpl")
    private AdminCheckService adminCheckService;

    @RequestMapping(value = "/api/admincheck")
    public ReturnObject admincheck(LqUserInfo lqUserInfo){
        ReturnObject returnObject = new ReturnObject();
        AdminResultEnum adminResultEnum = adminCheckService.CheckAdmin(lqUserInfo, returnObject);
        return returnObject;
    }

}
