package com.team.bank.service.serviceimpl;

import com.alibaba.fastjson.JSONObject;
import com.team.bank.enums.ResultEnum;
import com.team.bank.mapper.UserInfoMapper;
import com.team.bank.model.LqUser;
import com.team.bank.model.LqUserInfo;
import com.team.bank.model.ReturnObject;
import com.team.bank.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userInfoServerimpl")
public class UserInfoServerimpl implements UserInfoService {
    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public ResultEnum RegisterUser(LqUserInfo lqUserInfo) {
        Integer isUsed = userInfoMapper.isUsed(lqUserInfo.getMobile());
        if(isUsed != 0){
            return ResultEnum.USED_ERROR;
        }else {
            userInfoMapper.addUserInfo(lqUserInfo);
            userInfoMapper.addUserPwd(lqUserInfo);
            return ResultEnum.SUCCESS;
        }
    }

    @Override
    public ResultEnum LoginUser(LqUser lqUser, ReturnObject returnObject) {
        if(lqUser.getUsername() == null || lqUser.getUsername().length() == 0){
            returnObject.setSuccess(false);
            returnObject.setError(ResultEnum.USERNAME_MISS.getMessage());
            return ResultEnum.USERNAME_MISS;
        }else if (lqUser.getPassword() == null || lqUser.getPassword().length() ==0){
            returnObject.setSuccess(false);
            returnObject.setError(ResultEnum.PSDDWORD_ERROR.getMessage());
            return ResultEnum.PSDDWORD_ERROR;
        }
        Integer isRegister = userInfoMapper.checkLogin(lqUser);
        if(isRegister != 0){
            JSONObject jsonObject = new JSONObject();
                jsonObject.put("mobile", userInfoMapper.getMobile(lqUser));
                returnObject.setData(jsonObject);
                returnObject.setError("");
                returnObject.setSuccess(true);
            return ResultEnum.SUCCESS;
        }else {
            returnObject.setSuccess(false);
            returnObject.setError(ResultEnum.LOGIN_ERROR.getMessage());
            return ResultEnum.LOGIN_ERROR;
        }
    }
}
