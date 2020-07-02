package com.team.bank.service.serviceimpl;

import com.alibaba.fastjson.JSONObject;
import com.team.bank.enums.AdminResultEnum;
import com.team.bank.mapper.AdminLoginMapper;
import com.team.bank.mapper.AdminLostMapper;
import com.team.bank.model.LqUserInfo;
import com.team.bank.model.ReturnObject;
import com.team.bank.service.AdminLoginService;
import com.team.bank.service.AdminLostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedHashMap;

@Service
public class AdminLostServiceimpl implements AdminLostService {

    @Resource
    private AdminLostMapper adminLostMapper;

    @Override
    public ReturnObject adminLost(LqUserInfo lqUserInfo){
        ReturnObject returnObject =new ReturnObject();
        if(lqUserInfo.getName()==null) {
            returnObject.setError("用户名不能为空");
            return returnObject;
        }
        if(adminLostMapper.adminlost(lqUserInfo)>0){
            JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
                jsonObject.put("password",'重新设置用户密码');
            returnObject.setSuccess(true);
            returnObject.setError('');
             returnObject.setData(jsonObject);
        }else{
            returnObject.setError("服务器异常");
        }
        return returnObject;
    }
}
