package com.example.test_mysql.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisClient {

    @Autowired
    private StringRedisTemplate redisTemplate;

    //获取redis中的数据
    public String getStringValue(String key){
        String value = null;
        try {
            value = redisTemplate.opsForValue().get(key);
        } catch (Exception e){
            e.printStackTrace();
        }
        return value;
    }

    //获取int类型的返回值
    public int getIntValue(String key){
        int value = 0;
        try {
            String stringValue = getStringValue(key);
            if (!stringValue.isEmpty()){
                value = Integer.parseInt(stringValue);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return value;
    }

    //保存数据
    public void saveString(String key, String value, Long time, TimeUnit unit){
        if (time == null){
            redisTemplate.opsForValue().set(key, value);
            return;
        }
        if (unit == null){
            unit = TimeUnit.MILLISECONDS;
        }
        if (time < 0){
            time = 1000L;
            unit = TimeUnit.MILLISECONDS;
        }
        redisTemplate.opsForValue().set(key, value, time, unit);
    }
    public void saveString(String key, String value){
        saveString(key, value, null, null);
        redisTemplate.opsForValue();
    }

}
