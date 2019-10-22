package com.unicom.atguigu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;

/**
 *    启动类
 *
 *   @SpringBootApplication  标注主程序，说明是一个spring应用
 *
 *
 *
 *   一 搭建基本环境
 *   1.导入数据库文件 创建department和employee表
 *   2.创建实体类javabean对象
 *   3.整合MyBatis操作数据库
 *        1.配置数据源信息
 *        2.使用注解版的Mybatis
 *            1)@MapperScan指定需要扫描的Mapper的接口所在包
 *   二 快速体验缓存
 *      步骤
 *         1.开启基于注解的缓存（主类上）@EnableCaching
 *         2.标注缓存注解即可
 *             @Cacheable
 *             @CacheEvict
 *             @CachePut
 *
 */
/** @MapperScan指定需要扫描的Mapper的接口所在包  */
@MapperScan("com.unicom.atguigu.dao")
@SpringBootApplication
/**  1.开启基于注解的缓存（主类上）@EnableCaching   */
@EnableCaching
public class AtguiguApplication {



    public static void main(String[] args) {
        // spring应用启动起来
        SpringApplication.run(AtguiguApplication.class, args);
    }

}
