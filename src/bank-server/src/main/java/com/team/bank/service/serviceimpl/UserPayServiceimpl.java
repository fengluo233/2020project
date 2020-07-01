package com.team.bank.service.serviceimpl;

import com.alibaba.fastjson.JSONObject;
import com.team.bank.enums.ResultEnum;
import com.team.bank.mapper.UserInfoMapper;
import com.team.bank.mapper.UserPayMapper;
import com.team.bank.model.LqAsset;
import com.team.bank.model.ReturnObject;
import com.team.bank.service.UserInfoService;
import com.team.bank.service.UserPayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Calendar;

@Service("UserPayServiceimpl")
public class UserPayServiceimpl implements UserPayService {
    @Resource
    UserInfoMapper userInfoMapper;
    @Resource
    UserPayMapper userPayMapper;
    @Override
    public ResultEnum UserPay(JSONObject jsonObject, ReturnObject returnObject) {

        if(jsonObject.get("mode").equals("transfer")){
            double money = Double.parseDouble(jsonObject.getString("money"));
            String detail = jsonObject.getString("detail");
            String payee = jsonObject.getString("payee");
            String payer = jsonObject.getString("payer");
            String password = jsonObject.getString("password");
            LqAsset payerAsset = userInfoMapper.getAssetInfo(payer);
            LqAsset payeeAsset = userInfoMapper.getAssetInfo(payee);
            System.out.println(payerAsset.getBalance());
            if(payerAsset.getBalance() < money){
                returnObject.setSuccess(false);
                returnObject.setError("余额不足");
            } else {
                String payerName = userInfoMapper.getUserName(payerAsset.getMobile());
                String payerPassword = userInfoMapper.getPassWord(payerName);
                if(payerPassword.equals(password)){
                    Date date = new Date();
                    java.sql.Date dateTime = new java.sql.Date(date.getTime());
                    double payerBalance = payerAsset.getBalance() - money;
                    double payeeBalance = payeeAsset.getBalance() + money;
                    //System.out.println(dateTime);
                    userPayMapper.updateBalance(payerBalance, payer);
                    userPayMapper.updateBalance(payeeBalance, payee);
                    userPayMapper.insertExpense(payer, dateTime, money, payerBalance,0, detail);
                    userPayMapper.insertExpense(payee, dateTime, money, payeeBalance,4, detail);
                    returnObject.setSuccess(true);
                    returnObject.setError("");
                    JSONObject data = new JSONObject();
                    data.put("balance", payerBalance);
                    returnObject.setData(data);
                }else {
                    returnObject.setSuccess(false);
                    returnObject.setError("密码错误");
                }
            }
            return ResultEnum.SUCCESS;
        }else if(jsonObject.get("mode").equals("mobilepay")){

            String mobile = jsonObject.getString("mobile");
            Double money = Double.parseDouble(jsonObject.getString("money"));
            String password = jsonObject.getString("password");
            LqAsset lqAsset = userInfoMapper.getAssetInfo(mobile);
            String username = userInfoMapper.getUserName(mobile);
            String payerPassword = userInfoMapper.getPassWord(username);
            if(lqAsset.getBalance() < money){
                returnObject.setSuccess(false);
                returnObject.setError("余额不足");
                return ResultEnum.SUCCESS;
            }else{
                if(payerPassword.equals(password)){
                    Date date = new Date();
                    java.sql.Date dateTime = new java.sql.Date(date.getTime());
                    Double payerBalance = lqAsset.getBalance() - money;
                    userPayMapper.updateBalance(payerBalance, mobile);
                    userPayMapper.insertExpense(mobile, dateTime, money, payerBalance, 1, "手机缴费");
                    returnObject.setSuccess(true);
                    returnObject.setError("");
                    JSONObject data = new JSONObject();
                    data.put("balance", payerBalance);
                    returnObject.setData(data);
                    return ResultEnum.SUCCESS;
                }else {
                    returnObject.setSuccess(false);
                    returnObject.setError("密码错误");
                }
            }
        }
        return ResultEnum.SUCCESS;
    }
}
