package com.unicom.atguigu.controller;

import com.unicom.atguigu.bean.Department;
import com.unicom.atguigu.bean.Employee;
import com.unicom.atguigu.mapper.DepartmentMapper;
import com.unicom.atguigu.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: atguigu <br/>
 * @Date: 2019/10/9 18:55 <br/>
 * @Author: yangjiabin
 */

@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "hello world";
    }



    @Resource
    DepartmentMapper departmentMapper;


    @ResponseBody
    @GetMapping("/dept/{id}")
    public Department getDepartMent(@PathVariable("id") Integer id){
        return departmentMapper.getDeptById(id);
    }

    @ResponseBody
    @GetMapping("/dept")
    public Department insertDept(Department department){
       departmentMapper.insertDept(department);
       return department;
    }

    @Resource
    EmployeeMapper employeeMapper;

    @ResponseBody
    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id){
        return employeeMapper.getEmployeeById(id);
    }

}
