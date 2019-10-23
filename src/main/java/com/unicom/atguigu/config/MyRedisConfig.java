package com.unicom.atguigu.config;

import com.unicom.atguigu.bean.Department;
import com.unicom.atguigu.bean.Employee;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ResourceLoader;

import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.net.UnknownHostException;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: atguigu <br/>
 * @Date: 2019/10/23 13:59 <br/>
 * @Author: yangjiabin
 */
@Configuration
public class MyRedisConfig {


    @Bean
    public RedisTemplate<Object, Employee> employeeRedisTemplate
            (RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, Employee> template = new RedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Employee> employeeJackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Employee.class);
        template.setDefaultSerializer(employeeJackson2JsonRedisSerializer);
        return template;
    }


    @Bean
    public RedisTemplate<Object, Department> deptRedisTemplate
            (RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, Department> template = new RedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Department> departmentJackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Department.class);
        template.setDefaultSerializer(departmentJackson2JsonRedisSerializer);
        return template;
    }


    /**
     *   这个是尚硅谷那个讲师讲的  用不了？？？
     */
//    @Bean
//    public RedisCacheManager employeeCacheManager
//            (RedisTemplate<Object, Employee> employeeRedisTemplate) {
//        RedisCacheManager  redisCacheManager = new RedisCacheManager(employeeRedisTemplate) ;
//        redisCacheManager.setUseProfix(true);
//
//        return redisCacheManager;
//    }

    /**   字母哥讲解的  定制缓存规则  可以使用   尚硅谷可能是版本不同吧
     *
     *    本节的重点配置，让缓存的序列化方式使用redisTemplate.getValueSerializer()
     *
     *     @Primary必须指定一个主的CacheManager
     * */
    @Primary
    @Bean
    public RedisCacheManager employeeRedisCacheManager
    (RedisTemplate<Object, Employee> employeeRedisTemplate) {
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.
                nonLockingRedisCacheWriter(employeeRedisTemplate.getConnectionFactory());
        RedisCacheConfiguration redisCacheConfiguration =
                RedisCacheConfiguration.defaultCacheConfig()
                .serializeValuesWith(RedisSerializationContext.SerializationPair.
                        fromSerializer(employeeRedisTemplate.getValueSerializer()));
        return new RedisCacheManager(redisCacheWriter, redisCacheConfiguration);
    }


    @Bean
    public RedisCacheManager deptRedisCacheManager
            (RedisTemplate<Object, Department> departmentRedisTemplate) {
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.
                nonLockingRedisCacheWriter(departmentRedisTemplate.getConnectionFactory());
        RedisCacheConfiguration redisCacheConfiguration =
                RedisCacheConfiguration.defaultCacheConfig()
                        .serializeValuesWith(RedisSerializationContext.SerializationPair.
                                fromSerializer(departmentRedisTemplate.getValueSerializer()));
        return new RedisCacheManager(redisCacheWriter, redisCacheConfiguration);
    }
}
