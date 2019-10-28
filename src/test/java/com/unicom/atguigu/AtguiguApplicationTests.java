package com.unicom.atguigu;

import com.unicom.atguigu.bean.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.concurrent.DelayQueue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AtguiguApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;


    /**
     *   1.单播（点对点）
     */
    @Test
    public void contextLoads() {
        //Message需要自己构造一个；定义消息体内容和消息头；
        //参数（交换器，路由器，消息）
        //rabbitTemplate.send(exchage,routekey,message);


        //object默认当成消息体，只需要传入要发送的对象，自动序列化发送给rabbitMQ
        //rabbitTemplate.convertAndSend(exchage,routekey,object);
        Map<String,Object> map = new HashMap<>();
        map.put("msg","这是第一条消息");
        map.put("data", Arrays.asList("hello_word",123,true));
        //默认对象被序列化以后发送出去（jdk）
//        rabbitTemplate.
//                convertAndSend("exchange.direct",
//                        "atguigu.news",map);
        rabbitTemplate.
                convertAndSend("exchange.direct",
                        "atguigu.news",new Book("西游记","吴承恩"));


    }

    /**
     *   1.单播（点对点）   获取消息(jdk默认)
     *   获取消息(修改为json)
     *   接受数据，如何讲数据自动转为json发出去
     *   com.unicom.atguigu.config.MyAMQPConfig
     *   加上这个类就可以了
     */
    @Test
    public void test01() {
        Object o = rabbitTemplate
                .receiveAndConvert("atguigu.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    /**
         上面是单播  1对1发数据
         这里是广播   所有的消息队列  都会收到数据
     */
    @Test
    public void test02() {
//        rabbitTemplate
//                .convertAndSend
//                        ("exchange.fanout","",
//                                new Book("三国演义","罗贯中"));
        rabbitTemplate
                .convertAndSend
                        ("exchange.fanout","",
                                new Book("红楼梦","曹雪芹23"));
    }




    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    public void test03() {

        amqpAdmin.declareExchange
                (new DirectExchange("qmqpadmin.exchange"));
        System.out.println("exchange创建完成");

    }

    @Test
    public void test04() {

//        amqpAdmin.declareQueue
//                (new DelayQueue("qmqpadmin.queue",true));
//        System.out.println("queue创建完成");

    }


}
