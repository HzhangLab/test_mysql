package com.example.test_mysql.domain;

import com.example.test_mysql.model.Account;
import com.example.test_mysql.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountDomain {

    @Autowired
    private AccountService accountService;

    public int insertAccount(Account account){
        return accountService.insertAccount(account);
    }

    public Account selectById(String id){
        return accountService.selectById(id);
    }

    public int insertAccountUseTkMapper(Account account){
        return accountService.insertUseTkMapper(account);
    }

    public Account queryAccountByName(Account account) {
        return accountService.queryAccountByName(account);
    }
}
