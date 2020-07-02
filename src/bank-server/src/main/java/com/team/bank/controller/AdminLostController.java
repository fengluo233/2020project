package com.team.bank.controller;

import com.team.bank.model.LqUserInfo;
import com.team.bank.model.ReturnObject;
import com.team.bank.service.AdminLoginService;
import com.team.bank.service.AdminLostService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class AdminLostController {

    @Resource
    private AdminLostService adminLostService;

    @RequestMapping(value = "/api/adminlost")
    public ReturnObject adminlogin(@RequestBody LqUserInfo lqUserInfo){
        return adminLostService.LostAdmin(lqUserInfo);
    }
}
