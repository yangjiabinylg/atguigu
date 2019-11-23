package com.unicom.atguigu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AtguiguApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    public void contextLoads() {

        SimpleMailMessage message = new SimpleMailMessage();
        //邮件设置
        message.setSubject("通知-今晚开发");
        message.setText("今晚7:30开发  有内鬼！取消交易！");

        message.setTo("1091947832@qq.com");
        message.setFrom("1091947832@qq.com");

        mailSender.send(message);

    }


    @Test
    public void test() throws MessagingException {

        //1.创建一个复杂的消息邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        //邮件设置
        mimeMessageHelper.setSubject("通知-今晚开发");
        mimeMessageHelper.setText("<b style='color:red'>有内鬼，取消交易！<b>",true);

        mimeMessageHelper.setTo("1091947832@qq.com");
        mimeMessageHelper.setFrom("1091947832@qq.com");

        mimeMessageHelper.addAttachment("1.jpg",new File("C:\\Users\\Administrator\\Desktop\\image\\1.jpg"));
        mimeMessageHelper.addAttachment("2.jpg",new File("C:\\Users\\Administrator\\Desktop\\蔡\\2.jpg"));

        mailSender.send(mimeMessage);

    }

}
