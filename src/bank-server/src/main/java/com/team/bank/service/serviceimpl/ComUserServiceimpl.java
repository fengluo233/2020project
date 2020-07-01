package com.team.bank.service.serviceimpl;

import com.team.bank.enums.ComResultEnum;
import com.team.bank.mapper.ComUserMapper;
import com.team.bank.model.ComUser;
import com.team.bank.service.ComUserService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

@Service("comuserServerImpl")
public class ComUserServiceimpl implements ComUserService {
    @Resource
    private ComUserMapper comUserMapper;

    @Override
    public ComResultEnum insertComUser(ComUser comUser) throws Exception {
        if(StringUtils.isEmpty(comUser.getID())){
            return ComResultEnum.ID_ERROR;
        }
        if(StringUtils.isEmpty(comUser.getPwd())){
            return ComResultEnum.PWD_ERROR;
        }
        comUserMapper.addComUser(comUser);
        return ComResultEnum.SUCCESS;
    }
}
