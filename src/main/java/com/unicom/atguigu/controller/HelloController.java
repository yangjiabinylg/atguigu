package com.unicom.atguigu.controller;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        //日志级别
        //由高到低   trace<debug<info<warn<error
        //可以调整日志输出级别
        log.trace("trace....");
        log.debug("debug....");
        log.info("info....");
        log.warn("warn....");
        log.error("error....");
        return "hello world";
    }


}
