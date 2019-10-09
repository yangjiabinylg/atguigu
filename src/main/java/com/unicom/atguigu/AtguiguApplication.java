package com.unicom.atguigu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *    启动类
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
