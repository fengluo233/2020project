package com.team.bank.service.serviceimpl;

import com.alibaba.fastjson.JSONObject;
import com.team.bank.enums.ComResultEnum;
import com.team.bank.mapper.ComUserInfoMapper;
import com.team.bank.model.ComUser;
import com.team.bank.model.ComUserInfo;
import com.team.bank.model.ReturnObject;
import com.team.bank.service.ComUserInfoService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

@Service("comUserInfoServerimpl")
public class ComUserInfoServiceimpl implements ComUserInfoService {
    @Resource
    private ComUserInfoMapper comUserInfoMapper;

    @Override
    public ComResultEnum RegisterComUser(ComUserInfo comUserInfo) {
        Integer isUsed = comUserInfoMapper.isUsed(comUserInfo.getID());
        if(isUsed != 0){
            return ComResultEnum.USED_ERROR;
        }else {
            comUserInfoMapper.addComUserInfo(comUserInfo);
            comUserInfoMapper.addComUserPwd(comUserInfo);
            return ComResultEnum.SUCCESS;
        }
    }

    @Override
    public ComResultEnum LoginComUser(ComUser comUser, ReturnObject returnObject) {
        if(comUser.getID() == null || comUser.getID().length() == 0){
            returnObject.setSuccess(false);
            returnObject.setError(ComResultEnum.ID_MISS.getMessage());
            return ComResultEnum.ID_MISS;
        }else if (comUser.getPwd() == null || comUser.getPwd().length() ==0){
            returnObject.setSuccess(false);
            returnObject.setError(ComResultEnum.PSDDWORD_ERROR.getMessage());
            return ComResultEnum.PSDDWORD_ERROR;
        }
        Integer isRegister = comUserInfoMapper.checkLogin(comUser);
        if(isRegister != 0){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("number", comUserInfoMapper.getNumber(comUser));
            returnObject.setData(jsonObject);
            returnObject.setError("");
            returnObject.setSuccess(true);
            return ComResultEnum.SUCCESS;
        }else {
            returnObject.setSuccess(false);
            returnObject.setError(ComResultEnum.LOGIN_ERROR.getMessage());
            return ComResultEnum.LOGIN_ERROR;
        }
    }
}
