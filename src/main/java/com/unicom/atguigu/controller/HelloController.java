package com.unicom.atguigu.controller;

import com.unicom.atguigu.service.AsynService;
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
    AsynService asynService;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        //调用耗时任务10秒后才会响应  hello_world
        asynService.hello();
        return "hello_world";
    }


}
