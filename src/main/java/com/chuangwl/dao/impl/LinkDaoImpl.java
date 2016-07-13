package com.chuangwl.dao.impl;

import com.chuangwl.dao.LinkDao;
import com.chuangwl.entity.Link;
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
public class LinkDaoImpl implements LinkDao {
    @Override
    public int add(Link link) {
        return 0;
    }

    @Override
    public int update(Link link) {
        return 0;
    }

    @Override
    public List<Link> list(Map<String, Object> map) {
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
