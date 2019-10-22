package com.unicom.atguigu.service.imp;

import com.unicom.atguigu.bean.Employee;
import com.unicom.atguigu.dao.EmployeeMapper;
import com.unicom.atguigu.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: atguigu <br/>
 * @Date: 2019/10/22 16:35 <br/>
 * @Author: yangjiabin
 */
@Service
@Slf4j
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;


    /**
     * 将方法的运行结果进行缓存，以后要相同的数据，直接从缓存中获取，不用调用方法
     *
     * CacheManager管理多个Cache组件的，对缓存的真正CRUD操作在cache组件中，
     * 每一个缓存组又自己唯一一个名字  几个属性
     *      cacheNames/value:指定缓存组件的名字
     *      key：缓存数据使用的key;可以用它来指定。默认是使用方法参数的值
     *           1-方法的返回值   编写SpEl; #id;参数的id的值； 等效于 #a0 #p0 #root.args[0]
     *      keyGenerator: key的生成器；可以自己指定key的生成器的组件id
     *           key/keyGenerator:2选一使用
     *      cacheManager: 指定缓存管理器，或者cacheResolver指定获取解析器
     *      condition:指定符合条件的情况下才缓存；
     *          ，condition="#id>0"
     *      unless:否定缓存；当unless指定的条件为true，方法的返回值就不会缓存；
     *           可以获得到结果进行判断  unless = "#result == null"
     *      sync: 是否使用异步
     *
     *
     *      （cacheNames缓存组的名字
     *      缓存管理器cacheManager管理很多的cache组  一个组内id作为主键）
     *
     *
     * @param id
     * @return
     */
    @Override
    //@Cacheable(cacheNames = {"emp"},key = "#id")
    @Cacheable(cacheNames = {"emp"}  )
    public Employee getEmp(Integer id) {
        log.info("查询 ：{} 号员工",id);
        Employee employee = employeeMapper.selectByPrimaryKey(id);
        return employee;
    }


}
