package com.unicom.atguigu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: atguigu <br/>
 * @Date: 2019/10/15 18:44 <br/>
 * @Author: yangjiabin
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    @Autowired
    private LoginHandlerInterceptor loginInterceptor;

    /** 这个方法是用来配置静态资源的，比如html，js，css，等等 */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    }

    /** 这个方法用来注册拦截器，
     * 我们自己写好的拦截器需要通过这里添加注册才能生效*/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns("/**") 表示拦截所有的请求，
        // excludePathPatterns("/login", "/register") 表示除了登陆与注册之外，
        // 因为登陆注册不需要登陆也可以访问
//        registry.addInterceptor(loginInterceptor)
//                .addPathPatterns("/**")
//                .excludePathPatterns("/","/index.html",
//                        "/login","/static/**","/asserts/**" );

        //可以注册很多个拦截器
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**")
                //去除拦截主页，登录页面，注册页面，忘记密码页面
                //静态资源拦截springboot2.1.7 自动配置好的不用设置 （不知道是不是2.X版本都不用设置）
                .excludePathPatterns("/", "/index.html", "/user/login",
                        "/asserts/**",
                        "/kid/kid-list.html",
                        "/login","/register","/forgotPassword");

    }
}
