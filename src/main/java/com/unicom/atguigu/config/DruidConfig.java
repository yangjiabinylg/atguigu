package com.unicom.atguigu.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;


/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: atguigu <br/>
 * @Date: 2019/10/17 18:37 <br/>
 * @Author: yangjiabin
 */
@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource() ;
    }


    /** 配置Druid的监控 */
    /** 1.配置一个管理后台的servlet  */
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        HashMap<Object, Object> initParams = new HashMap<>();
        initParams.put("loginUsername","admin");
        initParams.put("loginPassword","123456");
        //默认就允许所有访问
        initParams.put("allow","");
        initParams.put("deny","192.168.15.21");

        servletRegistrationBean.setInitParameters(initParams);
        return servletRegistrationBean;
    }


    /**  2.配置一个监控的filter   */
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        HashMap<String, String> initParams = new HashMap<>();
        //排除js，css，druid下面的请求
        initParams.put("exclusions","*.js ,*.css,/druid/*");
        bean.setInitParameters(initParams);
        //拦截所有请求
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }

    /**
     * http://localhost:8080/druid/websession.html
     * 启动项目访问上面的路径
     */

}
