package com.unicom.atguigu.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: atguigu <br/>
 * @Date: 2019/10/17 20:54 <br/>
 * @Author: yangjiabin
 */

/**    */
/**  使用jpa注解配置映射关系   */
@Entity/**  告诉jpa这是一个实体类 （和数据表映射的类）  */
@Table(name = "tbl_user")/**  @Table来指定和那个表对应；如果忽略默认表名为user  */
@Data
public class User {

    /**  这是一个主键  */
    @Id
    /** 自动自增主键   */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**  这是和数据表对应的一个列  */
    @Column(name = "last_name",length = 50)
    private String lastName;

    /**  省略默认列名就是属性名   */
    @Column
    private String email;



}
