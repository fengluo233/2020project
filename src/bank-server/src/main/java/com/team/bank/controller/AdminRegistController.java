package com.team.bank.controller;

import com.team.bank.enums.ResultEnum;
import com.team.bank.model.Administrator;
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
    public String index(Administrator administrator){
        ResultEnum resultEnum = adminRegistService.RegisterAdminstrator(administrator);
        return resultEnum.getMessage();
    }
}
