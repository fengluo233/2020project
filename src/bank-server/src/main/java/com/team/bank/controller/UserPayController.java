package com.team.bank.controller;

import com.alibaba.fastjson.JSONObject;
import com.team.bank.enums.ResultEnum;
import com.team.bank.model.ReturnObject;
import com.team.bank.service.UserPayService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class UserPayController {

    @Resource(name ="UserPayServiceimpl")
    UserPayService userPayService;

    @ResponseBody
    @RequestMapping(value = "/api/personal/pay",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ReturnObject register(@RequestBody JSONObject jsonObject) {
        ReturnObject returnObject = new ReturnObject();
        ResultEnum resultEnum= userPayService.UserPay(jsonObject, returnObject);
        System.out.println(jsonObject);
        return returnObject;
    }
}
