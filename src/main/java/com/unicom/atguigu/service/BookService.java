package com.unicom.atguigu.service;

import com.unicom.atguigu.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: atguigu <br/>
 * @Date: 2019/10/28 15:47 <br/>
 * @Author: yangjiabin
 */
@Service
public class BookService {

    @RabbitListener(queues = "atguigu.news")
    public void receive(Book book){
        System.out.println("收到消息"+book);
    }

    @RabbitListener(queues = "atguigu")
    public void receive(Message message){
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }

}
