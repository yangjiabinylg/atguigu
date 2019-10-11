package com.unicom.atguigu.config;

import com.unicom.atguigu.bean.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: atguigu <br/>
 * @Date: 2019/10/11 16:07 <br/>
 * @Author: yangjiabin
 */
@Configuration
public class MyAppConfig {

    /*    */
    /**
    将方法的返回值添加到容器中，
    容器中这个组件默认的id就时方法名
    方法名就是bean的名字
    */
    @Bean
    public Dog dog(){
        return new Dog();
    }




}
