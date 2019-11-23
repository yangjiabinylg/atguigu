package com.unicom.atguigu.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: atguigu <br/>
 * @Date: 2019/11/21 14:01 <br/>
 * @Author: yangjiabin
 */
@Service
@Slf4j
public class ScheduleService {

    /**
     *    second(秒) minute（分） hour(时) day of month(日) month(月) day of week(周几)
     *    0 * * * * MON-FRI  周一到周五每分钟启动一次
     *    * * * * * MON-FRI  周一到周五每秒钟启动一次
     *    0 * * * * MON-SAT  周一到周六每分钟启动一次
     *    0,1,2,3,4 * * * * MON-SAT  周一到周六每分钟的0,1,2,3,4秒启动一次
     *    0-4 * * * * MON-SAT  周一到周六每分钟的0-4秒启动一次
     *    0/4 * * * * MON-SAT  周一到周六每隔4秒启动一次
     */
    @Scheduled(cron = "0/4 * * * * MON-SAT")
    public void hello(){

        log.info("你好...");
    }


}
