package com.example.test_mysql.controller;

import com.example.test_mysql.domain.AccountDomain;
import com.example.test_mysql.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountDomain accountDomain;

    @RequestMapping(value = "/insert/account" , method = RequestMethod.POST)
    public int insert(@RequestBody Account account ){
        return accountDomain.insertAccount(account);
    }

    @RequestMapping(value = "/account/selectById" , method = RequestMethod.POST)
    public Account SelectById(@RequestBody String id){
        System.out.println("kaishi");
        return accountDomain.selectById(id);
    }

    @RequestMapping(value = "/insert/account/TkMapper" , method = RequestMethod.POST)
    public int insertUseTkMapper(@RequestBody Account account ){
        return accountDomain.insertAccountUseTkMapper(account);
    }

    @RequestMapping(value = "/account/queryByName", method = RequestMethod.POST)
    public Account queryAccountByName(@RequestBody Account account){
        return accountDomain.queryAccountByName(account);
    }


}
