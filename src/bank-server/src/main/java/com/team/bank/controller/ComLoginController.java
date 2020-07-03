package com.team.bank.controller;

import com.team.bank.enums.ComResultEnum;
import com.team.bank.model.ComUser;
import com.team.bank.model.ReturnObject;
import com.team.bank.service.ComUserInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@ResponseBody
public class ComLoginController {
    @Resource(name = "comUserInfoServerimpl")
    private ComUserInfoService comUserInfoService;

    @CrossOrigin
    @RequestMapping(value = "/api/login",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ReturnObject login(@RequestBody ComUser comUser){
        ReturnObject returnObject = new ReturnObject();
        ComResultEnum comResultEnum = comUserInfoService.LoginComUser(comUser, returnObject);
        if (comResultEnum.getCode() != 0) {
            System.out.println(comResultEnum.getMessage());
        }
        return returnObject;
    }
}
