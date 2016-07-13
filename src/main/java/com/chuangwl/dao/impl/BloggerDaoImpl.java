package com.chuangwl.dao.impl;

import com.chuangwl.dao.BloggerDao;
import com.chuangwl.entity.Blogger;
import org.springframework.stereotype.Repository;

/**
 * 说明:
 *
 * @author Liu Guangjie
 * @date 16-7-13
 */
@Repository
public class BloggerDaoImpl implements BloggerDao {
    @Override
    public Blogger find() {
        return null;
    }

    @Override
    public Blogger getByUserName(String userName) {
        return null;
    }

    @Override
    public Integer update(Blogger blogger) {
        return null;
    }
}
