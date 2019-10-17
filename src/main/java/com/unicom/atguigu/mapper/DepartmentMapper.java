package com.unicom.atguigu.mapper;

import com.unicom.atguigu.bean.Department;
import org.apache.ibatis.annotations.*;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: atguigu <br/>
 * @Date: 2019/10/17 19:56 <br/>
 * @Author: yangjiabin
 */

/**  指定这是一个操作数据库的mapper   */
/**  @Mapper 每个类都加太麻烦了  */
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    public Department getDeptById(Integer id);

    @Delete("delete from department where id=#{id}")
    public int deletDeptById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(departmentName) values(#{departmentName})")
    public int insertDept(Department department);

    @Update("update department set departmentName=#{departmentName} where id=#{id}")
    public int updateDept(Department department);

}
