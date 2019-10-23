package com.unicom.atguigu;

import com.unicom.atguigu.bean.Employee;
import com.unicom.atguigu.dao.EmployeeMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AtguiguApplicationTests {

    @Resource
    EmployeeMapper employeeMapper;

    @Test
    public void contextLoads() {

        Employee employee = employeeMapper.selectByPrimaryKey(1);
        System.out.println(employee.toString());

        log.info("employee: {}",employee.toString());

    }


    /**
     *     redis 专门操作k-v都时字符串的
     *
     *
     *     Redis常见的五大数据类型
     *     string[字符串] list[列表] set[集合] hash[散列] zset(有序集合)
     *
     *
     *     stringRedisTemplate.opsForValue();（string[字符串]）
     *     stringRedisTemplate.opsForList();（list[列表]）
     *     stringRedisTemplate.opsForSet();（set[集合]）
     *     stringRedisTemplate.opsForHash();（hash[散列]）
     *     stringRedisTemplate.opsForZSet();（zset(有序集合)）
     *
     *
     *
     *
     */
    @Autowired
    StringRedisTemplate stringRedisTemplate;


    /**
     *    k-v都时对象的
     */
    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void test01() {
        //给redis中保存数据
        stringRedisTemplate.opsForValue().append("yangjiabin","hello_world");
        stringRedisTemplate.opsForValue().append("yangjiabin","你好世界");
    }

    @Test
    public void test02() {
        String yangjiabin = stringRedisTemplate.opsForValue().get("yangjiabin");
        log.info("杨加彬:{}",yangjiabin);
    }


    @Test
    public void test03() {
        redisTemplate.opsForList().leftPush("mylistyjb","1");
        redisTemplate.opsForList().leftPush("mylistyjb","2");

        //log.info("杨加彬:{}",yangjiabin);
    }


    @Test
    public void test04() {

        Employee employee = employeeMapper.selectByPrimaryKey(8);
        //默认如果保存对象，使用jdk序列化机制（二进制数据），
        // 序列化后的数据保存到redis中
        redisTemplate.opsForValue().set("emp-01",employee);
        log.info("employee:{}",employee);
        //1.将数据以json的方式保存
        //(1)自己将对象转为json
        //(2)redisTemplate默认的序列化规则

    }


    @Autowired
    RedisTemplate<Object,Employee> employeeRedisTemplate;

    @Test
    public void test05() {

        Employee employee = employeeMapper.selectByPrimaryKey(8);
        //默认如果保存对象，使用jdk序列化机制（二进制数据），
        // 序列化后的数据保存到redis中
        //自定义的redisTemplate  com.unicom.atguigu.config.MyRedisConfig
        //不用使用jdk序列化   用json的序列化   改变默认的序列化规则
        employeeRedisTemplate.opsForValue().set("emp-02",employee);
        log.info("employee:{}",employee);

    }




}
