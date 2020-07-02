package com.team.bank.service.serviceimpl;

import com.alibaba.fastjson.JSONObject;
import com.team.bank.enums.AdminResultEnum;
import com.team.bank.mapper.AdminCheckInfoMapper;
import com.team.bank.model.LqAsset;
import com.team.bank.model.LqUserInfo;
import com.team.bank.model.ReturnObject;
import com.team.bank.service.AdminCheckService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedHashMap;

@Service("adminCheckServiceimpl")
public class AdminCheckServiceimpl implements AdminCheckService {

    @Resource
    private AdminCheckInfoMapper adminCheckInfoMapper;

    @Override
    public AdminResultEnum CheckAdmin(LqUserInfo lqUserInfo, LqAsset lqAsset, ReturnObject returnObject){
        Integer isExisted = adminCheckInfoMapper.isExisted(lqUserInfo);
        if(isExisted != 0){
            JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
                jsonObject.put("用户邮箱",adminCheckInfoMapper.getEmail(lqUserInfo));
                jsonObject.put("银行卡号",adminCheckInfoMapper.getCardnum(lqUserInfo));
                jsonObject.put("银行卡余额",adminCheckInfoMapper.getBalance(lqAsset));
                jsonObject.put("理财产品",adminCheckInfoMapper.getMoneyManagement(lqAsset));
                jsonObject.put("基金",adminCheckInfoMapper.getFunds(lqAsset));
                jsonObject.put("黄金",adminCheckInfoMapper.getGold(lqAsset));
                returnObject.setSuccess(true);
                returnObject.setError(null);
                returnObject.setData(jsonObject);
            return AdminResultEnum.Check_SUCCES;
        }else {
            returnObject.setSuccess(false);
            returnObject.setError(AdminResultEnum.Check_ERROR.getMessage());
            returnObject.setData(null);
            return AdminResultEnum.Check_ERROR;
        }
    }
}
