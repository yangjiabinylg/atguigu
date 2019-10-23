package com.unicom.atguigu.service.imp;

import com.unicom.atguigu.bean.Department;
import com.unicom.atguigu.dao.DepartmentMapper;
import com.unicom.atguigu.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: atguigu <br/>
 * @Date: 2019/10/23 14:50 <br/>
 * @Author: yangjiabin
 */
@Service
@Slf4j
public class DeptServiceImp implements DeptService {

    @Resource
    DepartmentMapper departmentMapper;


    /**
     * 缓存的数据能存入redis；
     * 第二次从缓存中查询就不能反序列化回来；
     * 存的是dept的json数据；CacheManager默认使用RedisTemplate<Object,Employee>操作redis
     *
     *
     *   多个cacheManager 就要指定   cacheManager = "deptRedisCacheManager"
     *
     * @param id
     * @return
     */
    @Override
    /**    cacheNames = "dept",cacheManager = "deptRedisCacheManager"
     *     这2个都可以放到类上面去
     *
     * */
    @Cacheable(cacheNames = "dept",cacheManager = "deptRedisCacheManager")
    public Department getDeptById(Integer id) {

        log.info("查询部门：{}",id);
        Department department = departmentMapper.selectByPrimaryKey(id);

        return department;
    }






    /**      和上面的方法是等效的   还是不要用这个方式了  代码长很多        */
    @Qualifier("deptRedisCacheManager")
    @Autowired
    RedisCacheManager deptRedisCacheManager;

    @Override
    @Cacheable(cacheNames = "dept")
    public Department getDeptById2(Integer id) {

        log.info("查询部门：{}",id);
        Department department = departmentMapper.selectByPrimaryKey(id);
        //获取某个缓存
        Cache dept = deptRedisCacheManager.getCache("dept");
        dept.put("detp:2",department);
        return department;
    }



}
