package com.unicom.atguigu.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: atguigu <br/>
 * @Date: 2019/10/28 13:51 <br/>
 * @Author: yangjiabin
 */
@Configuration
public class MyAMQPConfig {

    /**
     *   不使用默认的jdk序列化模式
     *   如果想要使用json的序列化模式    则需要自定义序列化的规则
     *
     *
     * @return
     */
    @Bean
    public MessageConverter messageConverter(){


        return new Jackson2JsonMessageConverter() ;
    }


}
