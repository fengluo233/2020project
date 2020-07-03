package com.team.bank.controller;

import com.team.bank.enums.AdminResultEnum;
import com.team.bank.model.LqAsset;
import com.team.bank.model.LqUser;
import com.team.bank.model.LqUserInfo;
import com.team.bank.model.ReturnObject;
import com.team.bank.service.AdminCheckService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@ResponseBody
@RestController
public class AdminCheckController {

    @Resource(name = "adminCheckServiceimpl")
    private AdminCheckService adminCheckService;

    @CrossOrigin
    @RequestMapping(value = "/api/admincheck")
    public ReturnObject admincheck(@RequestBody LqUserInfo lqUserInfo){
        LqAsset lqAsset = new LqAsset();
        lqAsset.setMobile(lqUserInfo.getMobile());
        ReturnObject returnObject = new ReturnObject();
        AdminResultEnum adminResultEnum = adminCheckService.CheckAdmin(lqUserInfo, lqAsset,returnObject);
        return returnObject;
    }
}
