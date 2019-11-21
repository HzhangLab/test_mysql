package com.example.test_mysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.example.test_mysql.dao" , "com.example.test_mysql.mapper"})
public class TestMysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestMysqlApplication.class, args);
    }

}
