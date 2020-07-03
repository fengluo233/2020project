package com.team.bank.service.serviceimpl;

import com.alibaba.fastjson.JSONObject;
import com.team.bank.enums.ComResultEnum;
import com.team.bank.mapper.ComUserInfoMapper;
import com.team.bank.mapper.ComUserPayMapper;
import com.team.bank.model.ComAsset;
import com.team.bank.model.ReturnObject;
import com.team.bank.service.ComUserInfoService;
import com.team.bank.service.ComUserPayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Calendar;

@Service("ComUserPayServiceimpl")
public class ComUserPayServiceimpl implements ComUserPayService {
    @Resource
    ComUserInfoMapper comUserInfoMapper;
    @Resource
    ComUserPayMapper comUserPayMapper;
    @Override
    public ComResultEnum ComUserPay(JSONObject jsonObject, ReturnObject returnObject) {

        if(jsonObject.get("mode").equals("transfer")){
            double money = Double.parseDouble(jsonObject.getString("money"));
            String payee = jsonObject.getString("payee");
            String payer = jsonObject.getString("payer");
            String password = jsonObject.getString("password");
            String description = jsonObject.getString("description");
            String number = jsonObject.getString("number");
            ComAsset payerAsset = comUserInfoMapper.getAssetInfo(payer);
            ComAsset payeeAsset = comUserInfoMapper.getAssetInfo(payee);
            //System.out.println(payerAsset.getBalance());
            if(payerAsset.getTotal_assets() < money){
                returnObject.setSuccess(false);
                returnObject.setError("余额不足");
            } else {
                String payerName = comUserInfoMapper.getName(payerAsset.getID());
                String payerPassword = comUserInfoMapper.getPassWord(payerName);
                if(payerPassword.equals(password)){
                    Date date = new Date();
                    java.sql.Date dateTime = new java.sql.Date(date.getTime());
                    double payerBalance = payerAsset.getTotal_assets() - money;
                    double payeeBalance = payeeAsset.getTotal_assets() + money;
                    //System.out.println(dateTime);
                    comUserPayMapper.updateComTotal_assets(payerBalance, payer);
                    comUserPayMapper.updateComTotal_assets(payeeBalance, payee);
                    comUserPayMapper.insertComExpense(payer, dateTime, description, number, 0, payerBalance);
                    comUserPayMapper.insertComExpense(payee, dateTime, description, number, 4, payeeBalance);
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
            return ComResultEnum.SUCCESS;
        }else if(jsonObject.get("mode").equals("mobilepay")){

            String ID = jsonObject.getString("ID");
            Double money = Double.parseDouble(jsonObject.getString("money"));
            String password = jsonObject.getString("password");
            String number = jsonObject.getString("number");
            ComAsset comAsset = comUserInfoMapper.getAssetInfo(ID);
            String name = comUserInfoMapper.getName(ID);
            String payerPassword = comUserInfoMapper.getPassWord(name);
            if(comAsset.getTotal_assets() < money){
                returnObject.setSuccess(false);
                returnObject.setError("余额不足");
                return ComResultEnum.SUCCESS;
            }else{
                if(payerPassword.equals(password)){
                    Date date = new Date();
                    java.sql.Date dateTime = new java.sql.Date(date.getTime());
                    Double payerBalance = comAsset.getTotal_assets() - money;
                    comUserPayMapper.updateComTotal_assets(payerBalance, ID);
                    comUserPayMapper.insertComExpense(ID, dateTime, "手机缴费", number, 1, payerBalance);
                    returnObject.setSuccess(true);
                    returnObject.setError("");
                    JSONObject data = new JSONObject();
                    data.put("balance", payerBalance);
                    returnObject.setData(data);
                    return ComResultEnum.SUCCESS;
                }else {
                    returnObject.setSuccess(false);
                    returnObject.setError("密码错误");
                }
            }
        }
        return ComResultEnum.SUCCESS;
    }
}
