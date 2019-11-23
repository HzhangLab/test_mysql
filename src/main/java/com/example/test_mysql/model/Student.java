package com.example.test_mysql.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable {

    private String studentId;
    private String studentName;
    private Integer studentAge;

}
