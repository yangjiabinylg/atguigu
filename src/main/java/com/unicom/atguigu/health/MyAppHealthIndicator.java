package com.unicom.atguigu.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: atguigu <br/>
 * @Date: 2019/11/28 15:17 <br/>
 * @Author: yangjiabin
 */
@Component
public class MyAppHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        //return null;

        //自定义的检查方法
        //Health.up().build()//代表健康
        return Health.down().withDetail("msg","服务异常").build();

    }
}
