package com.team.bank.controller;

import com.team.bank.enums.AdminResultEnum;
import com.team.bank.model.Administrator;
import com.team.bank.model.ReturnObject;
import com.team.bank.service.AdminRegistService;
import com.team.bank.service.serviceimpl.AdminRegistServiceimpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@ResponseBody
@RestController
public class AdminRegistController {
    @Resource(name = "adminRegistServiceimpl")
    private AdminRegistService adminRegistService;

    @CrossOrigin
    @RequestMapping(value = "/api/administrator")
    public ReturnObject adminRegist(@RequestBody Administrator administrator){
        ReturnObject returnObject = new ReturnObject();
        AdminResultEnum adminResultEnum = adminRegistService.RegisterAdminstrator(administrator, returnObject);
        return returnObject;
    }
}
