package com.chuangwl.test;

import com.chuangwl.dao.BlogDao;
import com.chuangwl.entity.Blog;
import com.chuangwl.entity.BlogType;
import com.chuangwl.service.BloggerService;
import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Before;
import org.junit.Test;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2016/7/2.
 */
public class Test1 {
    ApplicationContext ac=null;

    @Before
    public void before(){
        ac =new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void testDao(){

        BlogDao dao=ac.getBean(BlogDao.class);
        System.out.println(dao.countList());
        BasicDataSource bb=ac.getBean(BasicDataSource.class);
        System.out.println(bb);

        /*MapperScannerConfigurer mapperScannerConfigurer=ac.getBean(MapperScannerConfigurer.class);
        mapperScannerConfigurer.setBasePackage("com.chuangwl.dao");
        System.out.println(mapperScannerConfigurer);
        System.out.println(dao);
        Blog blog=new Blog();
        BlogType type=new BlogType();
        type.setId(1);
        blog.setTitle("sadasd");
        blog.setContent("sadasd");
        blog.setSummary("as");
        blog.setBlogType(type);
        blog.setKeyWord("sadasd");

        *//**
         * insert into t_blog values(null,#{title},#{summary},now(),0,0,
         #{content},#{blogType.id},#{keyWord})
         *//*
        dao.add(blog);*/
    }

}
