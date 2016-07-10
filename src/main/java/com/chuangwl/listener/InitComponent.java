package com.chuangwl.listener;

import com.chuangwl.entity.Blog;
import com.chuangwl.entity.BlogType;
import com.chuangwl.entity.Blogger;
import com.chuangwl.entity.Link;
import com.chuangwl.service.BlogService;
import com.chuangwl.service.BlogTypeService;
import com.chuangwl.service.BloggerService;
import com.chuangwl.service.LinkService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Enumeration;
import java.util.List;

/**
 * 初始化组件 把博主信息 根据博客类别分类信息
 * 根据日期归档分类信息
 * 存放到application中，用以提供页面请求性能
 * @author Administrator
 */
public class InitComponent implements ServletContextListener {



    public void contextInitialized(ServletContextEvent servletContextEvent) {

        ServletContext application = servletContextEvent.getServletContext();

        ApplicationContext  applicationContext=WebApplicationContextUtils.getRequiredWebApplicationContext(application);

        BlogTypeService blogTypeService = applicationContext.getBean(BlogTypeService.class);
        List<BlogType> blogTypeCountList = blogTypeService.countList(); // 查询博客类别以及博客的数量
        application.setAttribute("blogTypeCountList", blogTypeCountList);

        BlogService blogService =  applicationContext.getBean(BlogService.class);
        List<Blog> blogCountList = blogService.countList(); // 根据日期分组查询博客
        application.setAttribute("blogCountList", blogCountList);

        LinkService linkService = applicationContext.getBean(LinkService.class);
        List<Link> linkList = linkService.list(null); // 查询所有的友情链接信息
        application.setAttribute("linkList", linkList);
    }

    public void contextDestroyed(ServletContextEvent sce) {
        //释放
        ServletContext servletContext=sce.getServletContext();
        Enumeration<String> attrs=servletContext.getAttributeNames();
        while(attrs.hasMoreElements()){
            servletContext.removeAttribute(attrs.nextElement());
        }

    }

}
