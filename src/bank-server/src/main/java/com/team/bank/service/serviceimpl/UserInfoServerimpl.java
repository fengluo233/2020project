package com.team.bank.service.serviceimpl;

import com.team.bank.enums.ResultEnum;
import com.team.bank.mapper.userInfoMapper;
import com.team.bank.model.lqUserInfo;
import com.team.bank.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userInfoServerimpl")
public class UserInfoServerimpl implements UserInfoService {
    @Resource
    private userInfoMapper userInfoMapper;

    @Override
    public ResultEnum RegisterUser(lqUserInfo lqUserInfo) {
        Integer isUsed = userInfoMapper.isUsed(lqUserInfo.getMobile());
        if(isUsed != 0){
            return ResultEnum.USED_ERROR;
        }else {
            userInfoMapper.addUserInfo(lqUserInfo);
            userInfoMapper.addUserPwd(lqUserInfo);
            return ResultEnum.SUCCESS;
        }
    }
}
