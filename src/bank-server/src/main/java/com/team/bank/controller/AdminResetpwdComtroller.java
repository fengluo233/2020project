package com.team.bank.controller;

import com.team.bank.enums.AdminResultEnum;
import com.team.bank.model.LqUser;
import com.team.bank.model.ReturnObject;
import com.team.bank.service.AdminResetpwdService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@ResponseBody
@RestController
public class AdminResetpwdComtroller {
    @Resource(name = "adminResetpwdServiceimpl")
    private AdminResetpwdService adminResetpwdService;

    @CrossOrigin
    @RequestMapping(value = "/api/resetpassword")
    public ReturnObject adminResetpwd(@RequestBody LqUser lqUser){
        ReturnObject returnObject = new ReturnObject();
        AdminResultEnum adminResultEnum = adminResetpwdService.ResetpwdAdmin(lqUser, returnObject);
        return returnObject;
    }
}
