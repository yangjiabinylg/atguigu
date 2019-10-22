package com.unicom.atguigu.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: atguigu <br/>
 * @Date: 2019/10/22 19:20 <br/>
 * @Author: yangjiabin
 */
@Configuration
public class MyCacheConfig {


    @Bean("myKeyGenerator")
    public KeyGenerator keyGenerator(){
        return new  KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                //cache缓存key的自定义规则
                return method.getName()+"*["+ Arrays.asList(objects).toString()+"]*";
            }
        };
    }

}
