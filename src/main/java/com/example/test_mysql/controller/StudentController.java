package com.example.test_mysql.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.test_mysql.dao.StudentDao;
import com.example.test_mysql.model.Student;
import com.example.test_mysql.redis.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

@RestController
public class StudentController {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private RedisClient redisClient;

    //增
    @RequestMapping(value = "/student/insert", method = RequestMethod.POST)
    public int studentInsert(@RequestBody Student student){
        return studentDao.insert(student);
    }

    //删
    @RequestMapping(value = "/student/delete", method = RequestMethod.POST)
    public int deleteStudent(@RequestBody Student student){
        Example example = new Example(Student.class);
        example.createCriteria().andEqualTo("studentId", student.getStudentId());
        return studentDao.deleteByExample(example);
    }

    //改
    @RequestMapping(value = "/student/update", method = RequestMethod.POST)
    public int studentUpdate(@RequestBody Student student){
        //设置筛选条件
        Example example =new Example(Student.class);
        example.createCriteria().andEqualTo("studentId", student.getStudentId());
        return studentDao.updateByExampleSelective(student, example);
    }

    //查
    @RequestMapping(value = "/student/query", method = RequestMethod.POST)
    public Student qeuryStudent(@RequestBody Student student){
        return studentDao.selectOne(student);
    }

    //进行redisTest
    @RequestMapping(value = "/student/saveCache", method = RequestMethod.POST)
    public void studentSaveInCache(@RequestBody Student student){
        String key = "id"+student.getStudentId()+"name"+student.getStudentName();
        redisClient.saveString(key, JSONObject.toJSONString(student));
    }

    @RequestMapping(value = "/student/getCache", method = RequestMethod.POST)
    public Student getStudentFromCache(@RequestBody Student student){
        String key = "id"+student.getStudentId()+"name"+student.getStudentName();
        String value = redisClient.getStringValue(key);
        return JSONObject.parseObject(value, Student.class);
    }

    @RequestMapping(value =  "Coupon/saveInCache", method = RequestMethod.POST)
    public void saveCouponInCache(@RequestBody Coupon coupon){
        String key = "couponName:"+coupon.getCouponName();
        redisClient.saveString(key, coupon.getCouponNumber().toString());
    }

    @RequestMapping(value = "Coupon/getNumber", method = RequestMethod.POST)
    public int getCouponNumberFromCache(@RequestBody Coupon coupon){
        String key = "couponName:"+coupon.getCouponName();
        int value = redisClient.getIntValue(key);
        int last = 0;
        if (value > 0) {
           last = value-1;
           System.out.println("Coupon还有余量，还剩"+ last +"张");
           redisClient.saveString(key, String.valueOf(last));
        } else {
            System.out.println("coupon已无余量");
        }
        return value;

    }

}
