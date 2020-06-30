package com.team.bank.service.serviceimpl;

import com.alibaba.fastjson.JSONObject;
import com.team.bank.enums.AdminResultEnum;
import com.team.bank.mapper.AdminLoginMapper;
import com.team.bank.model.Administrator;
import com.team.bank.model.ReturnObject;
import com.team.bank.service.AdminLoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedHashMap;

@Service("adminLoginServiceimpl")
public class AdminLoginServiceimpl implements AdminLoginService {

    @Resource
    private AdminLoginMapper adminLoginMapper;

    @Override
    public AdminResultEnum LoginAdmin(Administrator administrator, ReturnObject returnObject){
        Integer isAdministrator = adminLoginMapper.adminLogin(administrator);
        if(isAdministrator != 0){
            JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());         //jsonObject按照输入的顺序排列
                jsonObject.put("jobnum",adminLoginMapper.getJobnum(administrator));
                returnObject.setSuccess(true);
                returnObject.setError(null);
                returnObject.setData(jsonObject);
            return AdminResultEnum.LOGIN_SUCCESS;
        }else {
            returnObject.setSuccess(false);
            returnObject.setError(AdminResultEnum.LOGIN_ERROR.getMessage());
            return AdminResultEnum.LOGIN_ERROR;
        }
    }
}
