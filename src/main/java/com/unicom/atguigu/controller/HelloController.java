package com.unicom.atguigu.controller;

import com.unicom.atguigu.bean.Alipay;
import com.unicom.atguigu.bean.Dog;
import com.unicom.atguigu.bean.Dog2;
import com.unicom.atguigu.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    /**   */


    /**   单个属性注入  */
    @Value("${imageService.imageBaseUrl}")
    String imageBaseUrl;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "imageBaseUrl:   "+ imageBaseUrl;
    }





    /**   复杂属性注入     */
    @Autowired
    Person person;

    @ResponseBody
    @RequestMapping("/hello2")
    public String hello2(){
        return "person:   "+ person;
    }


    /** 所有的配置都写配置主文件里面   太大了
     *  独立一个文件写配置
     *  复杂属性注入     */
    @Autowired
    Alipay alipay;

    @ResponseBody
    @RequestMapping("/alipay")
    public String alipay(){
        return "Alipay:   "+ alipay;
    }


    /*  com.unicom.atguigu.config.MyAppConfig 中Dog设置为bean了   */
    @Autowired
    Dog dog;

    @ResponseBody
    @RequestMapping("/dog")
    public String dog(){

        Dog2 dog2 = null;
        System.out.println(dog2);
        /*  return "Dog2:   "+ dog2.toString(); 报错java.lang.NullPointerException: null  */
        /*  同样时Dog  和 Dog2  就是不一样的  下面这个正常运行Dog: Dog(name=null, age=null)   */
        return "Dog:   "+ dog.toString();
    }




}
