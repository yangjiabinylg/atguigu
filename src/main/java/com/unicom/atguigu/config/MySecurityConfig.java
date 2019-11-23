package com.unicom.atguigu.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: atguigu <br/>
 * @Date: 2019/11/23 17:50 <br/>
 * @Author: yangjiabin
 */
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        //定制请求的授权规则
        http.authorizeRequests()
                //允许所有人访问   ”/“  表示首页  所有人可以访问
                .antMatchers("/").permitAll()
                //指定角色访问
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");


        //开启自动配置的登陆功能    自定义登录页面
        http.formLogin().usernameParameter("user")
                .passwordParameter("pwd")
                .loginPage("/userlogin");
        //1./login来到登录页面
        //2.重定向到/login?error表示登录失败
        //3.更多详细规定
        //4.默认post形式的/login代表处理登录
        //5.一旦定制login页面，妈妈loginPage的post请求是登录


        //开启自动配置的注销功能    注销成功返回首页  / 表示首页
        http.logout().logoutSuccessUrl("/");
        //1.访问 /logout 表示用户注销，清空session
        //2.注销成功会返回 /login?logout 页面


        //开启记住我功能   记住密码功能    自定义记住密码
        http.rememberMe().rememberMeParameter("remember");
        //登录成功后，将cookie发给浏览器保存，以后访问页面带上这个cookie，只要通过检查就可以免登录了
        //点击注销会删除cookie

    }


    /**
     *  定义认证规则
     *
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);   本来是从数据库拿的这里来就写再缓存里面了
        auth.inMemoryAuthentication()
                .withUser("vip1").password("1111111").roles("VIP1","VIP2")
                .and()
                .withUser("vip2").password("1111111").roles("VIP1","VIP3")
                .and()
                .withUser("vip3").password("1111111").roles("VIP2","VIP3");




    }
}
