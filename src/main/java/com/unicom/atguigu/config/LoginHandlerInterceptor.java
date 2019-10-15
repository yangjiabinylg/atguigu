package com.unicom.atguigu.config;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: atguigu <br/>
 * @Date: 2019/10/15 18:35 <br/>
 * @Author: yangjiabin
 */

import com.unicom.atguigu.exception.UserNotExixtException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *   登录检查
 */
@Component
public class LoginHandlerInterceptor implements HandlerInterceptor {


    /**
      在目标方法执行之前执行
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Object username = request.getSession().getAttribute("username");
        if(username == null){
            //未登录
            request.setAttribute("msg","未登录");
            //throw new RuntimeException("未登录");
            throw new UserNotExixtException();
            //return false;
        }

        //已登录  放行请求
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
