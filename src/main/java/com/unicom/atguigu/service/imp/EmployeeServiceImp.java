package com.unicom.atguigu.service.imp;

import com.unicom.atguigu.bean.Employee;
import com.unicom.atguigu.dao.EmployeeMapper;
import com.unicom.atguigu.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
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
/** @CacheConfig(cacheNames = "emp")  可以替换每个方法上的value="emp"   抽取公共配置   */
@CacheConfig(cacheNames = "emp")
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
     *          ，condition="#id>0"  id的值>0的时候才进行缓存
     *          ，condition="#a0>1"; 第一个参数的值>1的时候才进行缓存
     *
     *      unless:否定缓存；当unless指定的条件为true，方法的返回值就不会缓存；
     *           可以获得到结果进行判断  unless = "#result == null"
     *           unless = "#a0==2"; 如果第二个参数值为2，结果不进行缓存
     *
     *      sync: 是否使用异步
     *
     *
     *      （cacheNames缓存组的名字
     *      缓存管理器cacheManager管理很多的cache组  一个组内id作为主键）
     *
     *
     *
     *      原理：（讲解一下，为什么第一次会又sql打印，第二次就没有sql打印了）
     *         1.自动配置类；(连续2次shift 查找CacheAutoConfiguration类)
     *
     *         2.缓存配置类
     *         找到selectImports  断点打在 return imports;上 找到这几个类
     *         org.springframework.boot.autoconfigure.cache.GenericCacheConfiguration
     *         org.springframework.boot.autoconfigure.cache.JCacheCacheConfiguration
     *         org.springframework.boot.autoconfigure.cache.EhCacheCacheConfiguration
     *         org.springframework.boot.autoconfigure.cache.HazelcastCacheConfiguration
     *         org.springframework.boot.autoconfigure.cache.InfinispanCacheConfiguration
     *         org.springframework.boot.autoconfigure.cache.CouchbaseCacheConfiguration
     *         org.springframework.boot.autoconfigure.cache.RedisCacheConfiguration
     *         org.springframework.boot.autoconfigure.cache.CaffeineCacheConfiguration
     *         org.springframework.boot.autoconfigure.cache.SimpleCacheConfiguration【默认】
     *         org.springframework.boot.autoconfigure.cache.NoOpCacheConfiguration
     *
     *         3.那个配置类默认生效：SimpleCacheConfiguration
     *
     *         4.给容器中注册了一个cacheManager；ConcurrentMapCacheManager
     *         (这个是没有redis数据库才用)
     *
     *         5.可以获取和创建ConcurrentMapCache类型的缓存组件；
     *         它的作用是将数据保存在concurrentMap中；
     *
     *         运行流程：
     *         @Cacheable:
     *         1.方法运行之前，先去查询Cache（缓存组件），按照cacheName指定的名字获取；
     *            （CacheManager先获取相应的缓存），第一次获取缓存如果没有Cache组件会自动创建
     *
     *         2.去Cache中查找缓存的内容，使用一个key，默认就是方法的参数；
     *         key是按照某种策略生成的，默认使用keyGenerator生成，（SimpleKyeGenerrator生成key）
     *               SimpleKeyGenerator生成key的默认策略
     *                     如果没有参数；key = new SimpKey（）；
     *                     如果一个参数；key = 参数值
     *                     如果多个参数；key = new SimpleKey(param);
     *
     *         3.没有查到缓存就调用目标方法；
     *
     *         4.将目标方法返回的结果，放进缓存中
     *
     *         @Cacheable标注的方法执行之前先来检查缓存中有没有这个数据，默认按照参数
     *         的值作为key去查询缓存，
     *         如果没有就运行方法并将结果放入缓存，以后再来调用就可以直接使用缓存中的数据
     *
     *         核心：
     *             1）使用cacheManager[ConcurrentMapCacheManager]
     *             按照名字得到Cache[ConcurrentMapCache]组件
     *             2）key使用keyGenerator生成的。默认是SimpleKeyGenerator
     *
     *
     *
     *
     *       增加/查找 缓存
     *       @Cacheable获取缓存数据，如果没有就先查数据库，在放缓存，
     *       缓存有数据  就不会去查询数据库
     *
     *
     * @param id
     * @return
     */
    @Override
    /** @Cacheable(cacheNames = {"emp"},key = "#id")   */
    /** @Cacheable(cacheNames = {"emp"}  )  和上面等效 在只有一个参数的情况下   */
    /** @Cacheable(cacheNames = {"emp"},key = "#root.methodName+'['+#id+']'")   */
    /**   上面生成key是   emp::getEmp[1]    这是自定的 key     */
    /**  @Cacheable(cacheNames = {"emp"},keyGenerator = "myKeyGenerator",condition = "#id>1",unless = "#id==2")  */
    /**   上面使用自定义的  myKeyGenerator     */
    @Cacheable(/** cacheNames = {"emp"},*/key = "#id")
    public Employee getEmp(Integer id) {
        log.info("查询 ：{} 号员工",id);
        Employee employee = employeeMapper.selectByPrimaryKey(id);
        return employee;
    }


    /**
     *    更新缓存
     *    @CachePut   既调用方法，有更新数据
     *    修改了数据库的某个数据，同时更新缓存
     *
     *    运行时机：
     *       1.先调用目标方法
     *       2.将目标方法的结果缓存起来
     *
     *
     *    测试步骤：
     *    1.查询3号 员工，查询的结果放在缓存中
     *        key:1  value: lastame张三
     *    2.第二次及以后查询还是之前的结果
     *    3.更新3号员工：{lastName:张飞赵云刘备 }
     *    4.查询下3号员工
     *       key="#employee.id"使用出啊如的参数的员工id为主键
     *       key="#result.id"使用返回后的id作为主键
     *         但hi@Cacheable的key不能使用#result
     *       应该是更新后的数据你（但是没有更新 因为没有指定参数为key  key="#employee.id"）
     *
     *
     *
     *       记住：
     *          主要就是key要保持一致，get的key和update的key要保持一致
     *
     *
     * @return
     */
    @CachePut(/**value = "emp" ,*/key="#employee.id")
    @Override
    public Employee updateEmp(Employee employee){
        log.info("updateEmp:{}",employee);
        employeeMapper.updateByPrimaryKeySelective(employee);
        return employee;
    }


    /**
     * @CacheEvict  删除缓存
     * key:指定要删除的数据
     * ,allEntries = true  指定清除这个缓存中的所有数据
     *
     * beforeInvocation = false: 缓存的清楚是否在方法执行之前
     *    默认时在方法执行之后执行的。如果出现异常不会清空缓存
     *
     * beforeInvocation = true: 缓存的清楚在方法执行之后
     *    无论方法是否出现异常，缓存都清除
     *
     */
    @Override
    /**  @CacheEvict(value = "emp",key = "#id" ,allEntries = true)  */
    /**  @CacheEvict(value = "emp",key = "#id" ,allEntries = true)  */
    /**  ,allEntries = true  删除时全部缓存删除  删除1号  2号也会删除  */
    public void deleteEmp(Integer id){
        log.info("deleteEmp:{}",id);
        // 就不删除了
        employeeMapper.deleteByPrimaryKey(id);
        //int i = 5/0;
        /**
         *      * beforeInvocation = false: 缓存的清楚是否在方法执行之前
         *      *    默认时在方法执行之后执行的。
         */
    }


    /**
     *     这个时复杂的缓存
     *     员工的名字，id，邮箱，都能查询到这个员工
     *
     *
     *
     *     根据用户名查询Employee
     *     访问 http://localhost:8080/emp/last-name/张三   数据库sql执行一次
     *     访问 http://localhost:8080/emp/8  数据库sql没有执行   说明已经缓存了
     *     再次访问 http://localhost:8080/emp/last-name/张三   数据库sql执行又一次
     *     为什么 不是已经缓存过了嘛？？
     *     因为cachePut注解  这个方法一定会执行，
     *     再次执行lastName查询  还是会查询数据库的
     *
     *
     *     @Caching定义复杂的缓存规则
     *
     *
     *
     *
     * @param lastName
     * @return
     */
    @Caching(
            cacheable = {
                    @Cacheable( /** value="emp", */   key = "#lastName")
            } ,
            put = {
                    @CachePut( /** value = "emp", */   key = "#result.id"),
                    @CachePut( /** value = "emp",  */  key = "#result.email")
            }
    )
    @Override
    public Employee getEmpByLastName(String lastName) {
        return employeeMapper.getEmpByLastName(lastName);
    }


}
