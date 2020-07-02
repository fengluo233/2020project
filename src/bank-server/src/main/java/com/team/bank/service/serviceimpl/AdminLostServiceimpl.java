package com.team.bank.service.serviceimpl;

import com.alibaba.fastjson.JSONObject;
import com.team.bank.enums.AdminResultEnum;
import com.team.bank.mapper.AdminLostMapper;
import com.team.bank.model.LqUserInfo;
import com.team.bank.model.ReturnObject;
import com.team.bank.service.AdminLostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedHashMap;

@Service("adminLostServiceimpl")
public class AdminLostServiceimpl implements AdminLostService {

    @Resource
    private AdminLostMapper adminLostMapper;

    @Override
    public AdminResultEnum LostAdmin(LqUserInfo lqUserInfo, ReturnObject returnObject) {
        Integer isRight = adminLostMapper.isRight(lqUserInfo);
        if (isRight != 0) {
            JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
                jsonObject.put("password",AdminResultEnum.LOST_RIGHT.getMessage());
                returnObject.setSuccess(true);
                returnObject.setError(null);
                returnObject.setData(jsonObject);
            return AdminResultEnum.LOST_RIGHT;
        } else {
            returnObject.setSuccess(false);
            returnObject.setError(AdminResultEnum.LOST_ERROR.getMessage());
            returnObject.setData(null);
            return AdminResultEnum.LOST_ERROR;
        }
    }
}

