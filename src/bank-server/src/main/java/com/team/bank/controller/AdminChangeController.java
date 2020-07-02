package com.team.bank.controller;

import com.team.bank.enums.AdminResultEnum;
import com.team.bank.model.LqUserInfo;
import com.team.bank.model.ReturnObject;
import com.team.bank.service.AdminChangeService;
import com.team.bank.service.serviceimpl.AdminChangeServiceimpl;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class AdminChangeController {
    @Resource(name = "adminChangeServiceimpl")
    private AdminChangeService adminChangeService;

    @RequestMapping(value = "/api/adminchange")
    public ReturnObject adminRegist(@RequestBody LqUserInfo lqUserInfo){
        return adminChangeService.changeUserInfo(lqUserInfo);
    }
}
