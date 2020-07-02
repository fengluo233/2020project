package com.team.bank.service.serviceimpl;

import com.alibaba.fastjson.JSONObject;
import com.team.bank.enums.AdminResultEnum;
import com.team.bank.mapper.AdminResetpwdMapper;
import com.team.bank.model.LqUser;
import com.team.bank.model.ReturnObject;
import com.team.bank.service.AdminResetpwdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("adminResetpwdServiceimpl")
public class AdminResetpwdServiceimpl implements AdminResetpwdService {

    @Resource
    private AdminResetpwdMapper adminResetpwdMapper;

    @Override
    public AdminResultEnum ResetpwdAdmin(LqUser lqUser, ReturnObject returnObject){
        if(lqUser.getPassword() == null || lqUser.getPassword().length() == 0){
            returnObject.setSuccess(false);
            returnObject.setError(AdminResultEnum.RESET_ERROR.getMessage());
            returnObject.setData(null);
            return AdminResultEnum.RESET_ERROR;
        }else {
            adminResetpwdMapper.resetPassword(lqUser);
            returnObject.setSuccess(true);
            returnObject.setError(null);
            returnObject.setData(null);
            return AdminResultEnum.RESET_SUCCESS;
        }
    }
}
