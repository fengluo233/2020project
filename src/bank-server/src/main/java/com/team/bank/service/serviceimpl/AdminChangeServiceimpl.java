package com.team.bank.service.serviceimpl;

import com.alibaba.fastjson.JSONObject;
import com.team.bank.enums.AdminResultEnum;
import com.team.bank.mapper.AdminChangeMapper;
import com.team.bank.mapper.AdminResetpwdMapper;
import com.team.bank.mapper.UserInfoMapper;
import com.team.bank.model.LqUser;
import com.team.bank.model.LqUserInfo;
import com.team.bank.model.ReturnObject;
import com.team.bank.service.AdminChangeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedHashMap;

@Service("adminChangeServiceimpl")
public class AdminChangeServiceimpl implements AdminChangeService {

    @Resource
    private AdminResetpwdMapper adminResetpwdMapper;

    @Resource
    private AdminChangeMapper adminChangeMapper;

    @Override
    public AdminResultEnum changeUserInfo(LqUser lqUser, LqUserInfo lqUserInfo, ReturnObject returnObject){
        lqUser.setUsername(lqUserInfo.getName());
        lqUser.setPassword(lqUserInfo.getPassword());
        if(lqUser.getPassword() == null || lqUser.getPassword().length() == 0){
            returnObject.setSuccess(false);
            returnObject.setError(AdminResultEnum.EMPTY_USERPWD.getMessage());
            returnObject.setData(null);
            return AdminResultEnum.EMPTY_USERPWD;
        }else if(lqUserInfo.getEmail() == null || lqUserInfo.getEmail().length() == 0){
            returnObject.setSuccess(false);
            returnObject.setError(AdminResultEnum.EMPTY_EMAIL.getMessage());
            returnObject.setData(null);
            return AdminResultEnum.EMPTY_EMAIL;
        }else if(lqUserInfo.getMobile() == null || lqUserInfo.getMobile().length() == 0){
            returnObject.setSuccess(false);
            returnObject.setError(AdminResultEnum.EMPTY_MOBILE.getMessage());
            returnObject.setData(null);
            return AdminResultEnum.EMPTY_MOBILE;
        }else {
            adminResetpwdMapper.resetPassword(lqUser);
            adminChangeMapper.changeEmail(lqUserInfo);
            adminChangeMapper.changeMobile(lqUserInfo);
            returnObject.setSuccess(true);
            returnObject.setError(AdminResultEnum.CHANGEUSERINFO_SUCCESS.getMessage());
            returnObject.setData(null);
            return AdminResultEnum.CHANGEUSERINFO_SUCCESS;
        }
    }
}
