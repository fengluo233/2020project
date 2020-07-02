package com.team.bank.controller;

import com.team.bank.enums.AdminResultEnum;
import com.team.bank.model.AdminFreeze;
import com.team.bank.model.ReturnObject;
import com.team.bank.service.AdminFreezeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@ResponseBody
@RestController
public class AdminFreezeController {

    @Resource(name = "adminFreezeServiceimpl")
    private AdminFreezeService adminFreezeService;

    @CrossOrigin
    @RequestMapping(value = "/api/adminfreeze")
    public ReturnObject adminfreeze(@RequestBody AdminFreeze adminFreeze){
        ReturnObject returnObject = new ReturnObject();
        AdminResultEnum adminResultEnum = adminFreezeService.freezeUser(adminFreeze, returnObject);
        return returnObject;
    }
}
