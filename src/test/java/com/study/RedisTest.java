package com.study;

import com.study.config.redis.RedisUtils;
import com.study.sys.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test(){
        String key = "634151dba3104576bb06312327480ae0";

        System.out.println(redisUtils.set(key,"666",0));
    }
}
