package com.team.bank.controller;

import com.team.bank.enums.AdminResultEnum;
import com.team.bank.model.Administrator;
import com.team.bank.model.ReturnObject;
import com.team.bank.service.AdminRegistService;
import com.team.bank.service.serviceimpl.AdminRegistServiceimpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class AdminRegistController {
    @Resource(name = "adminRegistServiceimpl")
    private AdminRegistService adminRegistService;

    @RequestMapping(value = "/api/administrator")
    public ReturnObject adminRegist(Administrator administrator){
        ReturnObject returnObject = new ReturnObject();
        AdminResultEnum adminResultEnum = adminRegistService.RegisterAdminstrator(administrator, returnObject);
        return returnObject;
    }
}
