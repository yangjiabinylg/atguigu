package com.unicom.atguigu.exception;

import com.unicom.atguigu.common.ServerResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: atguigu <br/>
 * @Date: 2019/10/15 20:10 <br/>
 * @Author: yangjiabin
 */
@ControllerAdvice
public class MyExceptionHandler {

    @ResponseBody
    @ExceptionHandler(UserNotExixtException.class)
    public ServerResponse handleUserNotLogginExcetpion(Exception e){
        Map<String,Object> map = new HashMap<>();
        map.put("code","user.notlogin");
        map.put("message",e.getMessage());
        return ServerResponse.createByErrorMessage(e.getMessage());
    }


}
