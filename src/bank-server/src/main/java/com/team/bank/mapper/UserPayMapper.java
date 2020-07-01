package com.team.bank.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.sql.Date;

@Mapper
public interface UserPayMapper {

    @Update("UPDATE lq_asset SET balance = #{balance} WHERE mobile = #{mobile}")
    void updateBalance(Double balance, String mobile);

    @Insert("INSERT INTO lq_expense(mobile, date, money, balance, method, details) VALUES(#{mobile}, #{date}, #{money}, #{balance}, #{method}, #{details})")
    void insertExpense(String mobile, Date date, Double money, Double balance, Integer method, String details);
}
