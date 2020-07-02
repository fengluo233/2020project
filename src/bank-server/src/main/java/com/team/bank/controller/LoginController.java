package com.team.bank.controller;

import com.team.bank.enums.ResultEnum;
import com.team.bank.model.LqUser;
import com.team.bank.model.ReturnObject;
import com.team.bank.service.UserInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
public class LoginController {
    @Resource(name = "userInfoServerimpl")
    private UserInfoService userInfoService;

    @ResponseBody
    @CrossOrigin
    @RequestMapping(value = "/api/personal/login",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ReturnObject login(LqUser lqUser){
        String mobile = "";
        ReturnObject returnObject = new ReturnObject();
        ResultEnum resultEnum = userInfoService.LoginUser(lqUser, returnObject);
        if (resultEnum.getCode() != 0) {
            System.out.println(resultEnum.getMessage());
        }
        return returnObject;
    }
}
