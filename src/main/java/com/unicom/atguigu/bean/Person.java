package com.unicom.atguigu.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: atguigu <br/>
 * @Date: 2019/10/11 10:02 <br/>
 * @Author: yangjiabin
 */

/**
 *   将配置文件中的每一个属性的值，映射到组件中
 *
 *   @ConfigurationProperties:告诉springboot将本类中的所有属性
 *   和配置文件中的配置进行绑定
 *   prefix = "person"  配置文件中那个下面的所有属性进行一一映射
 *
 *
 *   @Component：只有组件时容器的组件，
 *   才能用容器提供的@ConfigurationProperties功能
 *
 * */
@Component
@ConfigurationProperties(prefix = "person")
@Data
@Validated
public class Person {

    @Email
    private String lastName;
    private Integer age;
    private Boolean boss;
    private Date birth;


    private Map<String,Object> maps;
    private List<Object> lists;
    private Dog dog;


}
