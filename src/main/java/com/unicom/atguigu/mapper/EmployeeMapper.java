package com.unicom.atguigu.mapper;

import com.unicom.atguigu.bean.Employee;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: atguigu <br/>
 * @Date: 2019/10/17 20:28 <br/>
 * @Author: yangjiabin
 */

/**  @Mapper或者@MapperScan将接口扫描装配到容器中   */
public interface EmployeeMapper {


    public Employee getEmployeeById(Integer id);

    public void insertEmp(Employee employee);

}
