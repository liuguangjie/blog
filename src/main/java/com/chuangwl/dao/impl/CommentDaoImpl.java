package com.chuangwl.dao.impl;

import com.chuangwl.dao.CommentDao;
import com.chuangwl.entity.Comment;
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
public class CommentDaoImpl implements CommentDao {
    @Override
    public int add(Comment comment) {
        return 0;
    }

    @Override
    public int update(Comment comment) {
        return 0;
    }

    @Override
    public List<Comment> list(Map<String, Object> map) {
        return null;
    }

    @Override
    public Long getTotal(Map<String, Object> map) {
        return null;
    }

    @Override
    public Integer delete(Integer id) {
        return null;
    }
}
