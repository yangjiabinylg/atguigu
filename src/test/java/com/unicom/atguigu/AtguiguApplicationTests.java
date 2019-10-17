package com.unicom.atguigu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AtguiguApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    public void contextLoads() throws SQLException {

        System.out.println(dataSource.getClass());

        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();

        /**
              1.class com.zaxxer.hikari.HikariDataSource
              2.HikariProxyConnection@1811975204 wrapping com.mysql.cj.jdbc.ConnectionImpl@216e0771
              这是使用默认的jdbc的连接打印的数据
         */


        /**
               1.class com.alibaba.druid.pool.DruidDataSource
               2.com.mysql.cj.jdbc.ConnectionImpl@15f8701f
               这个是换成阿里巴巴的druid之后的 打印
         */


    }

}
