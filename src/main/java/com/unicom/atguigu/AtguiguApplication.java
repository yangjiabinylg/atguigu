package com.unicom.atguigu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *    启动类
 *
 *   @SpringBootApplication  标注主程序，说明是一个spring应用
 */
@SpringBootApplication
/** 开启异步注解功能 */
@EnableAsync
/** 开启基于注解的定时任务 */
@EnableScheduling
public class AtguiguApplication {

    public static void main(String[] args) {
        // spring应用启动起来
        SpringApplication.run(AtguiguApplication.class, args);
    }

}
/**
 *  spring security的使用
 *  1.引入spring security依赖  pom文件中
 *
 *  2.编写spring security的配置
 *   @EnableWebSecurity
 *   public class MySecurityConfig extends WebSecurityConfigurerAdapter {
 *
 *  3.控制请求的访问权限
 *
 *
 *
 *
 */
