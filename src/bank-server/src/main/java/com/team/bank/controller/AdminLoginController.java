package com.team.bank.controller;

import com.team.bank.enums.AdminResultEnum;
import com.team.bank.model.Administrator;
import com.team.bank.model.ReturnObject;
import com.team.bank.service.AdminLoginService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class AdminLoginController {

    @Resource(name = "adminLoginServiceimpl")
    private AdminLoginService adminLoginService;

    @RequestMapping(value = "/api/adminlogin")
    public ReturnObject adminlogin(Administrator administrator){
        return adminLoginService.LoginAdmin(administrator);

    }
}
