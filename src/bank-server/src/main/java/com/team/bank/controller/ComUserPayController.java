package com.team.bank.controller;

import com.alibaba.fastjson.JSONObject;
import com.team.bank.enums.ComResultEnum;
import com.team.bank.model.ReturnObject;
import com.team.bank.service.ComUserPayService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin
@RestController
public class ComUserPayController {

    @Resource(name ="ComUserPayServiceimpl")
    ComUserPayService comUserPayService;

    @ResponseBody
    @RequestMapping(value = "/api/pay",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ReturnObject register(@RequestBody JSONObject jsonObject) {
        ReturnObject returnObject = new ReturnObject();
        ComResultEnum comResultEnum= comUserPayService.ComUserPay(jsonObject, returnObject);
        //System.out.println(jsonObject);
        return returnObject;
    }
}
