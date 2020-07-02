package com.team.bank.service.serviceimpl;

import com.team.bank.enums.AdminResultEnum;
import com.team.bank.mapper.UserInfoMapper;
import com.team.bank.model.LqUser;
import com.team.bank.model.ReturnObject;
import com.team.bank.service.AdminChangeCheckService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("adminChangeCheckServiceimpl")
public class AdminChangeCheckServiceimpl implements AdminChangeCheckService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public AdminResultEnum AdminChangeCheck(LqUser lqUser, ReturnObject returnObject){
        Integer isRight = userInfoMapper.checkLogin(lqUser);
        if(isRight != 0){
            returnObject.setSuccess(true);
            returnObject.setError(AdminResultEnum.USERCHECK_SUCCESS.getMessage());
            returnObject.setData(null);
            return AdminResultEnum.USERCHECK_SUCCESS;
        }else {
            returnObject.setSuccess(false);
            returnObject.setError(AdminResultEnum.USERCHECK_ERROR.getMessage());
            returnObject.setData(null);
            return AdminResultEnum.USERCHECK_ERROR;
        }
    }
}
