package com.unicom.atguigu.controller.repository;

import com.unicom.atguigu.controller.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: atguigu <br/>
 * @Date: 2019/11/20 14:42 <br/>
 * @Author: yangjiabin
 */
public interface BookRepository extends ElasticsearchRepository<Book,Integer> {


    public List<Book> findByBookNameLike(String bookName);

}
