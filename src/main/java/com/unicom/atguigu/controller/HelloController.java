package com.unicom.atguigu.controller;

import com.unicom.starter.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: atguigu <br/>
 * @Date: 2019/10/9 18:55 <br/>
 * @Author: yangjiabin
 */

@Controller
public class HelloController {

    @Autowired
    HelloService helloService;


    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "hello world1111   "+helloService.sayHelloUnicom("   杨加彬  ");
    }

    /**
     *     需要自定义的stater在 zip里面（spring-boot-08-starter.zip）
     */

}
