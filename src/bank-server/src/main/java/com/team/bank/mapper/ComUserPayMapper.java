package com.team.bank.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.sql.Date;

@Mapper
public interface ComUserPayMapper {
    @Update("UPDATE com_asset SET total_assets = #{total_assets} WHERE ID = #{ID}")
    void updateComTotal_assets(Double total_assets, String ID);

    @Insert("INSERT INTO com_expense(ID, date, description, number, method, total_assets) VALUES(#{ID}, #{date}, #{description}, #{number}, #{method}, #{total_assets})")
    void insertComExpense(String ID, Date date, String description, String number, Integer method, Double tatal_assets);

}
