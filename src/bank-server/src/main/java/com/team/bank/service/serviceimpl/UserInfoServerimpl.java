package com.team.bank.service.serviceimpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.team.bank.enums.ResultEnum;
import com.team.bank.mapper.UserInfoMapper;
import com.team.bank.model.*;
import com.team.bank.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userInfoServerimpl")
public class UserInfoServerimpl implements UserInfoService {
    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public ResultEnum RegisterUser(LqUserInfo lqUserInfo) {
        Integer isUsed = userInfoMapper.isUsed(lqUserInfo.getMobile(),lqUserInfo.getName());
        if(isUsed != 0){
            return ResultEnum.USED_ERROR;
        }else {
            userInfoMapper.addUserInfo(lqUserInfo);
            userInfoMapper.addUserPwd(lqUserInfo);
            userInfoMapper.addUserAsset(lqUserInfo.getMobile());
            return ResultEnum.SUCCESS;
        }
    }

    @Override
    public ResultEnum LoginUser(LqUser lqUser, ReturnObject returnObject) {
        if(lqUser.getUsername() == null || lqUser.getUsername().length() == 0){
            returnObject.setSuccess(false);
            returnObject.setError(ResultEnum.USERNAME_MISS.getMessage());
            return ResultEnum.USERNAME_MISS;
        }else if (lqUser.getPassword() == null || lqUser.getPassword().length() ==0){
            returnObject.setSuccess(false);
            returnObject.setError(ResultEnum.PSDDWORD_ERROR.getMessage());
            return ResultEnum.PSDDWORD_ERROR;
        }else if(userInfoMapper.isFreeze(lqUser.getUsername(),"YES")!=0){
            returnObject.setSuccess(false);
            returnObject.setError("账户已被冻结");
            return ResultEnum.FREEZE_ERROR;
        }
        Integer isRegister = userInfoMapper.checkLogin(lqUser);
        if(isRegister != 0){
            JSONObject jsonObject = new JSONObject();
                jsonObject.put("mobile", userInfoMapper.getMobile(lqUser));
                returnObject.setData(jsonObject);
                returnObject.setError("");
                returnObject.setSuccess(true);
            return ResultEnum.SUCCESS;
        }else {
            returnObject.setSuccess(false);
            returnObject.setError(ResultEnum.LOGIN_ERROR.getMessage());
            return ResultEnum.LOGIN_ERROR;
        }
    }

    @Override
    public ResultEnum GetInfoUser(String mobile, ReturnObject returnObject) {
        LqUserInfo lqUserInfo = userInfoMapper.getCommonInfo(mobile);
        LqAsset lqAsset = userInfoMapper.getAssetInfo(mobile);
        JSONObject data = new JSONObject();
        data.put("email", lqUserInfo.getEmail());
        data.put("total_assets", lqAsset.getAll());
        data.put("balance", lqAsset.getBalance());
        data.put("money_management", lqAsset.getMoney_management());
        data.put("cardnum", lqUserInfo.getCardnum());
        data.put("funds", lqAsset.getFunds());
        data.put("gold", lqAsset.getGold());
        returnObject.setError("");
        returnObject.setSuccess(true);
        returnObject.setData(data);
        return ResultEnum.SUCCESS;
    }

    @Override
    public ResultEnum GetExpense(String mobile, ReturnObject returnObject) {
        List<LqExpense> lqExpense = userInfoMapper.getExpennseInfo(mobile);
        String data = JSON.toJSONString(lqExpense);
        JSONArray jsonArray = JSONObject.parseArray(data);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("bill_list",jsonArray);
        //System.out.println(jsonObject);
        returnObject.setData(jsonObject);
        returnObject.setSuccess(true);
        returnObject.setError("");
        return ResultEnum.SUCCESS;
    }

    @Override
    public ResultEnum GetUserName(String mobile, ReturnObject returnObject) {
        String username = userInfoMapper.getUserName(mobile);
        if(username == null ||username.equals("")){
            returnObject.setSuccess(false);
            returnObject.setError("用户不存在");
            returnObject.setData(null);
        }else {
            JSONObject data = new JSONObject();
            data.put("username",username);
            returnObject.setData(data);
            returnObject.setError("");
            returnObject.setSuccess(true);
        }
        return ResultEnum.SUCCESS;
    }
}
