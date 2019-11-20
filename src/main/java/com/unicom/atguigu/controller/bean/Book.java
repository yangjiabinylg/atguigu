package com.unicom.atguigu.controller.bean;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: atguigu <br/>
 * @Date: 2019/11/20 14:41 <br/>
 * @Author: yangjiabin
 */
@Data
@Document(indexName = "atguigu_database" ,type = "book_table")
public class Book {

    private Integer id;

    private String bookName;

    private String author;

}
