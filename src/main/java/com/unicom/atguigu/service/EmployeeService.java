package com.unicom.atguigu.service;

import com.unicom.atguigu.bean.Employee;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: atguigu <br/>
 * @Date: 2019/10/22 16:34 <br/>
 * @Author: yangjiabin
 */
public interface EmployeeService {


    Employee getEmp(Integer id);

    Employee updateEmp(Employee employee);

    void deleteEmp(Integer id);
}
