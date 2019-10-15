package com.unicom.atguigu.controller;

import com.unicom.atguigu.common.ServerResponse;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: atguigu <br/>
 * @Date: 2019/10/9 18:55 <br/>
 * @Author: yangjiabin
 */
@RequestMapping("/user")
@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public ServerResponse hello(){
        return ServerResponse.createBySuccess("hello world1");
    }

    @ResponseBody
    @GetMapping("/hello2")
    public ServerResponse hello2(){
        return ServerResponse.createBySuccess("hello world2");
    }

    /**
     *    这样是无法让前端拿到数据json的   必须是Object类型ServerResponse
     */
    @ResponseBody
    @GetMapping("/hello3")
    public String hello3(){
        return "hello string";
    }

    /**
     *
     */
    /**
     *    这样是无法让前端拿到数据json的   必须是Object类型ServerResponse
     */
    @ResponseBody
    @PostMapping("/login")
    public ServerResponse login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session){
        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            session.setAttribute("username",username);
            return ServerResponse.createBySuccess("登录成功");
        }
        return ServerResponse.createByErrorMessage("用户名或者密码错误");
    }


}
