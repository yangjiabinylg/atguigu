package com.unicom.atguigu.controller.bean;

import io.searchbox.annotations.JestId;
import lombok.Data;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: atguigu <br/>
 * @Date: 2019/11/20 11:09 <br/>
 * @Author: yangjiabin
 */
@Data
public class Article {

    /** @JestId 标识字段为主键 */
    @JestId
    private Integer id;

    private String author;

    private String title;

    private String content;



}
