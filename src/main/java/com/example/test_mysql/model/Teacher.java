package com.example.test_mysql.model;

import java.io.Serializable;

public class Teacher implements Serializable {

    /**
     * teacherName : zhabsa
     */
    private String teacherName;

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherName() {
        return teacherName;
    }
}
