package com.example.test_mysql.dao;

import com.example.test_mysql.BaseMapper;
import com.example.test_mysql.model.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountDao extends BaseMapper<Account> {

}
