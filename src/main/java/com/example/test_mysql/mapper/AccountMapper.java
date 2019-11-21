package com.example.test_mysql.mapper;

import com.example.test_mysql.model.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AccountMapper {

    @Insert("insert into account value ( #{id}, #{name}, #{money} )")
    int insertAccount(Account account);

    @Select("select * from account where id = #{id}")
    Account selectById(@Param("id") String accountId);

}
