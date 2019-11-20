package com.unicom.atguigu;

import com.unicom.atguigu.controller.bean.Article;
import com.unicom.atguigu.controller.bean.Book;
import com.unicom.atguigu.controller.repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.rmi.runtime.NewThreadAction;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AtguiguApplicationTests {

    @Autowired
    JestClient jestClient;

    @Autowired
    BookRepository bookRepository;

    @Test
    public void contextLoads() {

        //1.给ES中索引（保存）一个文档
        Article article = new Article();
        article.setId(2);
        article.setTitle("好消息");
        article.setAuthor("zhangsan");
        article.setContent("你好世界");

        //构建一个索引功能
        Index index = new Index.Builder(article).index("atguigu_database").type("news_table").build();


        try {
            //执行
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    //测试搜索
    @Test
    public void search()  {
        //查询表达式
        String json = "{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"content\" : \"你\"\n" +
                "        }\n" +
                "    } \n" +
                "}";
        //构建搜索功能
        Search search = new Search.Builder(json).addIndex("atguigu_database").addType("news_table").build();


        try {
            //执行
            SearchResult execute = jestClient.execute(search);
            log.info("execute {}",execute.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    //测试搜索
    @Test
    public void test1()  {
        Book book = new Book();
        book.setId(4);
        book.setBookName("西游记");
        book.setAuthor("吴承恩");
        bookRepository.index(book);
    }

    //测试搜索
    @Test
    public void test2()  {
        List<Book> books = bookRepository.findByBookNameLike("游");

        for (Book book :books){
            log.info("book {}",book);
        }
    }


}
