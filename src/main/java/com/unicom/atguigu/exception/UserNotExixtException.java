package com.unicom.atguigu.exception;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: atguigu <br/>
 * @Date: 2019/10/15 20:08 <br/>
 * @Author: yangjiabin
 */

public class UserNotExixtException extends RuntimeException {


    public UserNotExixtException() {
        super("用户没有登录");
    }
}
