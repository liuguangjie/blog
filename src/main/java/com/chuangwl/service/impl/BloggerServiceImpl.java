package com.chuangwl.service.impl;

import com.chuangwl.dao.BloggerDao;
import com.chuangwl.entity.Blogger;
import com.chuangwl.service.BloggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 博主Service实现类
 * @author Administrator
 *
 */
@Service
public class BloggerServiceImpl implements BloggerService {

    @Autowired
    private BloggerDao bloggerDao;

    public Blogger find() {
        return bloggerDao.find();
    }

    public Blogger getByUserName(String userName) {
        return bloggerDao.getByUserName(userName);
    }

    public Integer update(Blogger blogger) {
        return bloggerDao.update(blogger);
    }


}
