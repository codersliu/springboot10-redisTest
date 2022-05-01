package com.sliu.springboot10redistest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class Springboot10RedisTestApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    @Qualifier("redisTemplate")
    RedisTemplate redisTemplate;

    @Test
    void redisTest(){
        //  redisTemplate   操作不同数据类型，api和指令一致
        //  opsForValue     操作字符串   类似String
        //  opsForList      操纵List    类似List
        //  opsForSet
        //  opsForHash
        //  opsForZSet
        //  opsForGeo
        //  opsForHyperLogLog

        //  除了基本操作，常用方法直接通过redisTemplate操作，比如事务和基本CRUD

        //  获取redis连接对象
//        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
//        connection.flushDb();
//        connection.flushAll();
        redisTemplate.opsForValue().set("mykey","sliu's redis test");
        System.out.println(redisTemplate.opsForValue().get("mykey"));
    }
}
