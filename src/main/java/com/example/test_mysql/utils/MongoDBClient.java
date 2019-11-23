package com.example.test_mysql.utils;

import com.example.test_mysql.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

public class MongoDBClient {

    //
    @Autowired
    private MongoTemplate mongoTemplate;

}
