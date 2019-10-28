package com.unicom.atguigu;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *    启动类
 *
 *   @SpringBootApplication  标注主程序，说明是一个spring应用
 *
 *
 *   自动配置
 *   1.RabbitAutoConfiguration
 *   2.有自动配置了连接工厂ConnectionFactory;
 *   3.RabbitProperties封装了RabbitMQ的配置
 *   4.RabbitTemplate:给RabbitMQ发送和接受消息
 *   5.AMqpAdmin:RabbitMQ 系统管理功能组件
 *       AmqpAdmin:创建和删除 Queue,Exchange,Binding
 *   6.@EnableRabbit+@RabbitListener 监听消息队列的内容
 *
 *
 *
 */
@SpringBootApplication
//开启基于RabbitMQ的模式
@EnableRabbit
public class AtguiguApplication {

    public static void main(String[] args) {
        // spring应用启动起来
        SpringApplication.run(AtguiguApplication.class, args);
    }

}
