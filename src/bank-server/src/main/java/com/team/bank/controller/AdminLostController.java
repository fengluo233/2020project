package com.team.bank.controller;

import com.team.bank.enums.AdminResultEnum;
import com.team.bank.model.LqUser;
import com.team.bank.model.LqUserInfo;
import com.team.bank.model.ReturnObject;
import com.team.bank.service.AdminLostService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@ResponseBody
@RestController
public class AdminLostController {

    @Resource(name = "adminLostServiceimpl")
    private AdminLostService adminLostService;

    @CrossOrigin
    @RequestMapping(value = "/api/adminlost")
    public ReturnObject adminlost(@RequestBody LqUserInfo lqUserInfo){
        ReturnObject returnObject = new ReturnObject();
        AdminResultEnum adminResultEnum = adminLostService.LostAdmin(lqUserInfo, returnObject);
        return returnObject;
    }
}
