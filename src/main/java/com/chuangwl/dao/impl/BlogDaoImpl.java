package com.chuangwl.dao.impl;

import com.chuangwl.dao.BlogDao;
import com.chuangwl.entity.Blog;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 说明:
 *
 * @author Liu Guangjie
 * @date 16-7-13
 */
@Repository
public class BlogDaoImpl implements BlogDao {
    @Override
    public List<Blog> countList() {
        return null;
    }

    @Override
    public List<Blog> list(Map<String, Object> map) {
        return null;
    }

    @Override
    public Long getTotal(Map<String, Object> map) {
        return null;
    }

    @Override
    public Blog findById(Integer id) {
        return null;
    }

    @Override
    public Integer update(Blog blog) {
        return null;
    }

    @Override
    public Blog getLastBlog(Integer id) {
        return null;
    }

    @Override
    public Blog getNextBlog(Integer id) {
        return null;
    }

    @Override
    public Integer add(Blog blog) {
        return null;
    }

    @Override
    public Integer delete(Integer id) {
        return null;
    }

    @Override
    public List<Blog> selectAll() {
        return null;
    }
}
