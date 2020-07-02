package com.team.bank.controller;

import com.team.bank.enums.AdminResultEnum;
import com.team.bank.model.LqUser;
import com.team.bank.model.LqUserInfo;
import com.team.bank.model.ReturnObject;
import com.team.bank.service.AdminChangeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@ResponseBody
@RestController
public class AdminChangeController {

    @Resource(name = "adminChangeServiceimpl")
    private AdminChangeService adminChangeService;

    @CrossOrigin
    @RequestMapping(value = "/api/adminchange")
    public ReturnObject changeUserInfo(@RequestBody LqUserInfo lqUserInfo, LqUser lqUser){
        ReturnObject returnObject = new ReturnObject();
        AdminResultEnum adminResultEnum = adminChangeService.changeUserInfo(lqUser, lqUserInfo, returnObject);
        return returnObject;
    }
}
