package com.example.test_mysql.service;

import com.example.test_mysql.dao.AccountDao;
import com.example.test_mysql.mapper.AccountMapper;
import com.example.test_mysql.model.Account;
import com.example.test_mysql.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service
public class AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private MongoTemplate mongoTemplate;

    public int insertAccount(Account account){
       return accountMapper.insertAccount(account);
    }

    public Account selectById(String id){
        return accountMapper.selectById(id);
    }

    public int insertUseTkMapper(Account account) {
        return accountDao.insert(account);
    }

    public Account queryAccountByName(Account account) {
        Example example =new Example(Account.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("name", account.getName());
        return accountDao.selectOneByExample(example);
    }

    public Student insertStudentIntoMongo(Student student){
        return mongoTemplate.insert(student , "student");
    }
}
