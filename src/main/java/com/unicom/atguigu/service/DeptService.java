package com.unicom.atguigu.service;

import com.unicom.atguigu.bean.Department;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: atguigu <br/>
 * @Date: 2019/10/23 14:49 <br/>
 * @Author: yangjiabin
 */
public interface DeptService {

    Department getDeptById(Integer id);

    Department getDeptById2(Integer id);

}
