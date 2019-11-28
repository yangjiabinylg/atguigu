package com.unicom.atguigu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *  自定义健康状态指示器
 *  1.编写一个指示器，实现HealthIndicator接口
 *  2.指示器的名字  xxxHealthIndicator接口
 *  3.加入容器中
 *
 *
 *    启动类
 *
 *
 *
 *   @SpringBootApplication  标注主程序，说明是一个spring应用
 */
@SpringBootApplication
public class AtguiguApplication {

    public static void main(String[] args) {
        // spring应用启动起来
        SpringApplication.run(AtguiguApplication.class, args);
    }

}
