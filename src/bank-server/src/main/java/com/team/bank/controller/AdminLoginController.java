package com.team.bank.controller;

import com.team.bank.enums.AdminResultEnum;
import com.team.bank.model.Administrator;
import com.team.bank.model.ReturnObject;
import com.team.bank.service.AdminLoginService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@ResponseBody
@RestController
public class AdminLoginController {

    @Resource(name = "adminLoginServiceimpl")
    private AdminLoginService adminLoginService;

    @CrossOrigin
    @RequestMapping(value = "/api/adminlogin")
    public ReturnObject adminlogin(@RequestBody Administrator administrator){
        ReturnObject returnObject = new ReturnObject();
        AdminResultEnum adminResultEnum = adminLoginService.LoginAdmin(administrator, returnObject);
        return returnObject;
    }
}
