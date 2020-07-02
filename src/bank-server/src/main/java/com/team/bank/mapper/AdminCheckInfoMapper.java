package com.team.bank.mapper;

import com.team.bank.model.LqAsset;
import com.team.bank.model.LqUserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminCheckInfoMapper {

    @Select("SELECT COUNT(*) FROM lq_userinfo WHERE mobile = #{mobile}")
    Integer isExisted(LqUserInfo lqUserInfo);

    @Select("SELECT email from lq_userinfo WHERE mobile = #{mobile}")
    String getEmail(LqUserInfo lqUserInfo);

    @Select("SELECT cardnum from lq_userinfo WHERE mobile = #{mobile}")
    String getCardnum(LqUserInfo lqUserInfo);

    @Select("SELECT balance from lq_asset WHERE mobile = #{mobile}")
    String getBalance(LqAsset lqAsset);

    @Select("SELECT money_management from lq_asset WHERE mobile = #{mobile}")
    String getMoneyManagement(LqAsset lqAsset);

    @Select("SELECT funds from lq_asset WHERE mobile = #{mobile}")
    String getFunds(LqAsset lqAsset);

    @Select("SELECT gold from lq_asset WHERE mobile = #{mobile}")
    String getGold(LqAsset lqAsset);
}
