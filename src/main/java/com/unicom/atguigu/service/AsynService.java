package com.unicom.atguigu.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: atguigu <br/>
 * @Date: 2019/11/21 10:57 <br/>
 * @Author: yangjiabin
 */
@Service
@Slf4j
public class AsynService {


    /**  告诉spring这是一个异步方法
     *   这样spring会自己开一个线程池  来自己调用这个方法
     */
    @Async
    public void hello(){
        //假设这是一个耗时任务需要耗时10秒
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("执行任务完成。。。。");
    }


}
