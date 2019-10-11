package com.unicom.atguigu.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: atguigu <br/>
 * @Date: 2019/10/11 15:59 <br/>
 * @Author: yangjiabin
 */
@Data
/**  所有的配置都写配置主文件里面   太大了
 *  独立一个文件写配置
 *  */
@PropertySource(value = {"classpath:alipay.properties"})
@Component
@ConfigurationProperties(prefix = "alipay")
public class Alipay {
    private String callback;
    private String username;
    private String password;
}
