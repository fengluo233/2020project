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
    public AdminResultEnum changeUserInfo(LqUserInfo lqUserInfo, ReturnObject returnObject){
        Integer isExisted = adminChangeMapper.isExisted(lqUserInfo);
        if(isExisted != 0){
            adminChangeMapper.changeEmail(lqUserInfo);
            adminChangeMapper.changeMobile(lqUserInfo);
            returnObject.setSuccess(true);
            returnObject.setError(AdminResultEnum.CHANGEUSERINFO_SUCCESS.getMessage());
            returnObject.setData(null);
            return AdminResultEnum.CHANGEUSERINFO_SUCCESS;
        }else {
            returnObject.setSuccess(false);
            returnObject.setError(AdminResultEnum.Check_ERROR.getMessage());
            returnObject.setData(null);
            return AdminResultEnum.Check_ERROR;
        }
    }
}
