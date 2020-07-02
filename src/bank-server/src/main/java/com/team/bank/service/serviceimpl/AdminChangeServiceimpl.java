package com.team.bank.service.serviceimpl;

import com.alibaba.fastjson.JSONObject;
import com.team.bank.enums.ResultEnum;
import com.team.bank.mapper.AdminChangeMapper;
import com.team.bank.model.LqUserInfo;
import com.team.bank.model.ReturnObject;
import com.team.bank.service.AdminChangeService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

@Service("adminChangeServiceimpl")
public class AdminChangeServiceimpl implements AdminChangeService {

    @Resource
    private AdminChangeMapper adminChangeMapper;

    @Override
    public ReturnObject changeUserInfo(LqUserInfo lqUserInfo){
        ReturnObject returnObject=new ReturnObject();
        if(lqUserInfo.getName() == null ){
            returnObject.setSuccess(false);
            returnObject.setError(ResultEnum.USR_ERROR.getMessage());
            returnObject.setData(null);
            return returnObject;
        }else {
            try{
                adminChangeMapper.changeMobile(lqUserInfo);
                adminChangeMapper.changeEmail(lqUserInfo);
                returnObject.setSuccess(true);
                returnObject.setError(null);
            }catch{
                returnObject.setSuccess(false);
                returnObject.setError("服务器异常");
            }finally {
                returnObject.setData(null);
                return returnObject;
            }
        }
        
    }
}
