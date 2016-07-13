package com.chuangwl.mongo.impl;


import com.chuangwl.mongo.BaseMongoDAO;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;


public abstract class BaseMongoDAOImpl<T> implements BaseMongoDAO<T> {
  
    private static final int DEFAULT_SKIP = 0;  
    private static final int DEFAULT_LIMIT = 200;  
      
    /** 
     * spring mongodb　集成操作类　 
     */  
    protected MongoTemplate mongoTemplate;  
  
    @Override  
    public List<T> find(Query query) {  
        //return mongoTemplate.find(query, this.getEntityClass());
        return null;
    }  
  
    @Override  
    public T findOne(Query query) {  

        //return mongoTemplate.findOne(query, this.getEntityClass());
        return null;
    }
  
    @Override  
    public void update(Query query, Update update) {  
        //mongoTemplate.findAndModify(query, update, this.getEntityClass());
    }  
  
    @Override  
    public T save(T entity) {  
        mongoTemplate.insert(entity);  
        return entity;  
    }  
  
    @Override  
    public T findById(String id) {  
        //return mongoTemplate.findById(id, this.getEntityClass());
        return null;
    }
  
    @Override  
    public T findById(String id, String collectionName) {  
        //return mongoTemplate.findById(id, this.getEntityClass(), collectionName);
        return null;
    }  
      
    /*@Override
    public Page<T> findPage(Page<T> page,Query query){  
        long count = this.count(query);  
        page.setCount(count);  
        int pageNumber = page.getPageNo();  
        int pageSize = page.getPageSize();  
        query.skip((pageNumber - 1) * pageSize).limit(pageSize);  
        List<T> rows = this.find(query);  
        page.setList(rows);  
        return page;  
    }  */
      
    @Override  
    public long count(Query query){  
        //return mongoTemplate.count(query, this.getEntityClass());
        return 0;
    }
      
  
    /** 
     * 获取需要操作的实体类class 
     *  
     * @return 
     */  
   /* private Class<T> getEntityClass(){
        return ReflectionUtils.getSuperClassGenricType(getClass());  
    }  */
  
    /** 
     * 注入mongodbTemplate 
     *  
     * @param mongoTemplate 
     */  
    public  void setMongoTemplate(MongoTemplate mongoTemplate){
    	
    	this.mongoTemplate=mongoTemplate;
    }
  
}  