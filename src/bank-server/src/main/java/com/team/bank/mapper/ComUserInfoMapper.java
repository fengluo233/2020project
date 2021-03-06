package com.team.bank.mapper;

import org.apache.ibatis.annotations.*;
import com.team.bank.model.*;

import java.util.List;

@Mapper
public interface ComUserInfoMapper {
    @Insert("INSERT INTO com_userinfo(ID,number,address,pwd,name) VALUES (#{ID},#{number},#{address},#{pwd},#{name})")
    int addComUserInfo(ComUserInfo comUserInfo);

    @Insert("INSERT INTO com_user(ID,pwd) VALUES (#{ID},#{pwd})")
    int addComUserPwd(ComUserInfo comUserInfo);

    @Select("SELECT COUNT(*) FROM com_user WHERE (ID = #{ID} AND pwd = #{pwd})")
    Integer checkLogin(ComUser comUser);

    @Select("SELECT COUNT(*) FROM com_userinfo WHERE ID = #{ID}")
    Integer isUsed(String ID);

    @Select("SELECT number from com_userinfo WHERE ID = #{ID}")
    String getNumber(ComUser comUser);

    @Select("SELECT * from com_userinfo WHERE ID = #{ID}")
    ComUserInfo getCommonInfo(String ID);

    @Select("SELECT * from com_asset WHERE ID = #{ID}")
    ComAsset getAssetInfo(String ID);

    @Select("SELECT * FROM com_expense WHERE ID = #{ID}")
    List<ComExpense> getExpennseInfo(String ID);

    @Select("SELECT name FROM com_userinfo WHERE ID = #{ID}")
    String getName(String ID);

    @Select("SELECT pwd FROM com_user WHERE ID = #{ID}")
    String getPassWord(String ID);

}
