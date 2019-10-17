package com.unicom.atguigu.repository;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: atguigu <br/>
 * @Date: 2019/10/17 21:01 <br/>
 * @Author: yangjiabin
 */

import com.unicom.atguigu.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**  继承JpaRepository来完成对数据库的操作      <实体类，实体类主键>   */
public interface UserRepository extends JpaRepository<User,Integer> {
}
