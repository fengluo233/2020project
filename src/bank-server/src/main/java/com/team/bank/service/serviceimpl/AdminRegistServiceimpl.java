package com.team.bank.service.serviceimpl;

import com.team.bank.enums.ResultEnum;
import com.team.bank.mapper.AdminRegistMapper;
import com.team.bank.model.Administrator;
import com.team.bank.service.AdminRegistService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

@Service("adminRegistServiceimpl")
public class AdminRegistServiceimpl implements AdminRegistService {

    @Resource
    private AdminRegistMapper adminRegistMapper;

    @Override
    public ResultEnum RegisterAdminstrator(Administrator administrator){
        if(StringUtils.isEmpty(administrator.getAdminName())){          //检查注册时的用户名是否为空
            return ResultEnum.USR_ERROR;                                //此处因为创建检测时格式有误，后面改正错误后会改回来
        }
        if(StringUtils.isEmpty(administrator.getAdminPwd())){
            return  ResultEnum.PWD_ERROR;
        }
        if(StringUtils.isEmpty(administrator.getJobNum())){
            return ResultEnum.USED_ERROR;
        }
        adminRegistMapper.addAdminstrator(administrator);
        return ResultEnum.SUCCESS;
    }
}
