package com.chuangwl.controller;


import com.chuangwl.entity.Blog;
import com.chuangwl.entity.PageBean;
import com.chuangwl.service.BlogService;
import com.chuangwl.util.PageUtil;
import com.chuangwl.util.StringUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 主页Controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private BlogService blogService;


    /**
     * 请求主页
     * @return
     * @throws Exception
     */
    @RequestMapping("/index")
    public String index(Integer page,@RequestParam(value="typeId",required=false)String typeId,@RequestParam(value="releaseDateStr",required=false)String releaseDateStr,HttpServletRequest request)throws Exception{
        if (page==null || page==0) {
            page = 1;
        }
        PageBean pageBean=new PageBean(page,10);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        map.put("typeId", typeId);
        map.put("releaseDateStr", releaseDateStr);
        List<Blog> blogList=blogService.list(map);
        for(Blog blog:blogList){
            List<String> imagesList=blog.getImagesList();
            String blogInfo=blog.getContent();
            Document doc=Jsoup.parse(blogInfo);
            Elements jpgs=doc.select("img[src$=.jpg]"); //　查找扩展名是jpg的图片
            for(int i=0;i<jpgs.size();i++){
                Element jpg=jpgs.get(i);
                imagesList.add(jpg.toString());
                if(i==2){
                    break;
                }
            }
        }
        request.setAttribute("blogList",blogList);
        StringBuffer param=new StringBuffer(); // 查询参数
        if(StringUtil.isNotEmpty(typeId)){
            param.append("typeId="+typeId+"&");
        }
        if(StringUtil.isNotEmpty(releaseDateStr)){
            param.append("releaseDateStr="+releaseDateStr+"&");
        }
        request.setAttribute("pageCode",PageUtil.genPagination(request.getContextPath() + "/index.html", blogService.getTotal(map), page, 10, param.toString()));
        request.setAttribute("mainPage","foreground/blog/list.jsp");
        request.setAttribute("pageTitle","Java开源系统");
        return "mainTemp";
    }

    /**
     * 源码下载
     * @return
     * @throws Exception
     */
    @RequestMapping("/download")
    public ModelAndView download()throws Exception{
        ModelAndView mav=new ModelAndView();
        mav.addObject("mainPage", "foreground/system/download.jsp");
        mav.addObject("pageTitle","本站源码下载页面_Java开源博客系统");
        mav.setViewName("mainTemp");
        return mav;
    }
}
