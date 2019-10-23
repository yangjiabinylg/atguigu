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
 *
 *
 *   二 快速体验缓存
 *      步骤
 *         1.开启基于注解的缓存（主类上）@EnableCaching
 *         2.标注缓存注解即可
 *             @Cacheable
 *             @CacheEvict
 *             @CachePut
 *   默认使用的是ConcurentMapCacheManager==ConcurrentMapCache;将数据保存在ConcurrentMap<Object,Objcect>
 *   开发中间件使用缓存中间件  redis  mencached  ehcache;
 *
 *
 *   默认使用的是concurentMap   实际中一般使用的是redis这种缓存中间件
 *
 *
 *   三 整合redis作为缓存
 *   Redis 是一个开源（BSD许可）的，内存中的数据结构存储系统，它可以用作数据库、
 *   缓存和消息中间件。 它支持多种类型的数据结构，如 字符串（strings）， 散列（hashes），
 *   列表（lists）， 集合（sets）， 有序集合（sorted sets） 与范围查询， bitmaps，
 *   hyperloglogs 和 地理空间（geospatial） 索引半径查询。 Redis 内置了 复制（replication），
 *   LUA脚本（Lua scripting）， LRU驱动事件（LRU eviction），事务（transactions）
 *   和不同级别的 磁盘持久化（persistence）， 并通过 Redis哨兵（Sentinel）
 *   和自动 分区（Cluster）提供高可用性（high availability）。
 *
 *
 *   1.安装redis 使用docker；
 *   2.引入redis的starter
 *   3.配置redis
 *   4.测试缓存
 *      原理：CacheManager===Cache  缓存组件来实际中存取数据
 *      1）引入redis的starter，容器中保存的是 RedisCacheManager;
 *      2)RedisCacheManager 帮我们创建RedisCache来作为缓存组件，
 *      RedisCache通过操作redis缓存数据的
 *      3）默认保存k-v都是Object；利用序列化保存；如何保存为json
 *          1.引入redis的starter；cacheManager变成RedisCacheManager
 *          2.默认创建的RedisCacheManger操作redis的时候使用的是RedisTemplate<Object,Object>
 *          3.RedisTemplate<Object,Object>是默认使用jdk的序列化机制
 *      4) 自定义CacheManger（默认redisManger是用jdk序列化，只能自定义变为json）
 *
 *
 *
 *
 *
 */
/**  @MapperScan指定需要扫描的Mapper的接口所在包   */
@MapperScan("com.unicom.atguigu.dao")
@SpringBootApplication
/**   1.开启基于注解的缓存（主类上）@EnableCaching   */
@EnableCaching
public class AtguiguApplication {



    public static void main(String[] args) {
        // spring应用启动起来
        SpringApplication.run(AtguiguApplication.class, args);
    }

}
