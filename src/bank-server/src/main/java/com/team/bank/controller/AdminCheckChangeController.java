package com.team.bank.controller;

import com.team.bank.enums.AdminResultEnum;
import com.team.bank.model.LqUser;
import com.team.bank.model.ReturnObject;
import com.team.bank.service.AdminChangeCheckService;
import com.team.bank.service.AdminCheckService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@ResponseBody
@RestController
public class AdminCheckChangeController {

    @Resource(name = "adminChangeCheckServiceimpl")
    private AdminChangeCheckService adminChangeCheckService;

    @CrossOrigin
    @RequestMapping(value = "/api/adminchangecheck")
    public ReturnObject adminchangecheck(@RequestBody LqUser lqUser){
        ReturnObject returnObject = new ReturnObject();
        AdminResultEnum adminResultEnum = adminChangeCheckService.AdminChangeCheck(lqUser, returnObject);
        return returnObject;
    }

}
