package com.unicom.atguigu;

import com.unicom.atguigu.bean.Employee;
import com.unicom.atguigu.dao.EmployeeMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AtguiguApplicationTests {

    @Resource
    EmployeeMapper employeeMapper;


    @Test
    public void contextLoads() {

        Employee employee = employeeMapper.selectByPrimaryKey(1);
        System.out.println(employee.toString());

        log.info("employee: {}",employee.toString());

    }

}
