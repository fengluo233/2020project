package com.team.bank.service.serviceimpl;

import com.team.bank.enums.AdminResultEnum;
import com.team.bank.mapper.AdminFreezeMapper;
import com.team.bank.model.AdminFreeze;
import com.team.bank.model.ReturnObject;
import com.team.bank.service.AdminFreezeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("adminFreezeServiceimpl")
public class AdminFreezeServiceimpl implements AdminFreezeService {

    @Resource
    private AdminFreezeMapper adminFreezeMapper;

    @Override
    public AdminResultEnum freezeUser(AdminFreeze adminFreeze, ReturnObject returnObject){
        Integer isExisted = adminFreezeMapper.isExisted(adminFreeze);
        if(isExisted != 0){
            adminFreezeMapper.addIsfrozen(adminFreeze);
            returnObject.setSuccess(true);
            returnObject.setError(AdminResultEnum.FREEZE_SUCCESS.getMessage());
            returnObject.setData(null);
            return AdminResultEnum.FREEZE_SUCCESS;
        }else {
            returnObject.setSuccess(false);
            returnObject.setError(AdminResultEnum.FREEZE_ERRPR.getMessage());
            returnObject.setData(null);
            return AdminResultEnum.FREEZE_ERRPR;
        }
    }
}
