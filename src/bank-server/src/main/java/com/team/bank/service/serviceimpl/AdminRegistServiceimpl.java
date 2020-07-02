package com.team.bank.service.serviceimpl;

import com.alibaba.fastjson.JSONObject;
import com.team.bank.enums.AdminResultEnum;
import com.team.bank.enums.ResultEnum;
import com.team.bank.mapper.AdminRegistMapper;
import com.team.bank.model.Administrator;
import com.team.bank.model.ReturnObject;
import com.team.bank.service.AdminRegistService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

@Service("adminRegistServiceimpl")
public class AdminRegistServiceimpl implements AdminRegistService {

    @Resource
    private AdminRegistMapper adminRegistMapper;

    @Override
    public ReturnObject RegisterAdminstrator(Administrator administrator){
        ReturnObject returnObject=new ReturnObject();
        if(administrator.getAdminName() == null || administrator.getAdminName().length() == 0){
            returnObject.setSuccess(false);
            returnObject.setError(AdminResultEnum.EMPTY_ADMINNAME.getMessage());
            returnObject.setData(null);
            return returnObject;
        }else if(administrator.getAdminPwd() == null || administrator.getAdminPwd().length() == 0){
            returnObject.setSuccess(false);
            returnObject.setError(AdminResultEnum.EMPTY_ADMINPWD.getMessage());
            returnObject.setData(null);
            return returnObject;
        }else if(administrator.getJobNum() == null || administrator.getJobNum().length() == 0){
            returnObject.setSuccess(false);
            returnObject.setError(AdminResultEnum.EMPTY_JOBNUM.getMessage());
            returnObject.setData(null);
            return returnObject;
        }
        if(adminRegistMapper.addAdminstrator(administrator)>0) {
            returnObject.setSuccess(true);
            returnObject.setError(null);
        }else {
            returnObject.setSuccess(false);
            returnObject.setError("服务器异常");
        }
        returnObject.setData(null);
        return returnObject;
    }
}
