package com.unicom.atguigu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *    启动类
 *
 *   @SpringBootApplication  标注主程序，说明是一个spring应用
 *
 *   SpringBoot默认支持两种技术和Elasticsearch交互
 *   1.Jest（默认不生效）
 *   需要导入jest的工具包（io.searchbox.client.JestClient;）
 *   2.SpringData ElasticSearch[elasticsearch-6.4.3.jar]
 *      [服务器用5.6.9    ElasticSearch有可能不合适 ]
 *      https://github.com/spring-projects/spring-data-elasticsearch
 *      版本适配信息
 *      https://docs.spring.io/spring-data/elasticsearch/docs/3.2.0.RC3/reference/html/#preface.versions
 *      1）、Clinet节点信息ClusterNodes；clusterName
 *      2） ElasticsearchTemplate操作ElasticSearch
 *      3)  编写一个ElasticSearchRepository的子接口操作ElasticSearch
 *      spring-boot-starter-data-elasticsearch 2.1.9.RELEASE  不适配
 *      spring-data-elasticsearch   3.1.11.RELEASE
 *
 */
@SpringBootApplication
public class AtguiguApplication {

    public static void main(String[] args) {
        // spring应用启动起来
        SpringApplication.run(AtguiguApplication.class, args);
    }



}
