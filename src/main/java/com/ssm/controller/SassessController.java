package com.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.ssm.entity.Choose;
import com.ssm.entity.Sassess;
import com.ssm.service.ChooseService;
import com.ssm.service.CourseServiceImpl;
import com.ssm.service.SassessService;
import com.ssm.service.SassessServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/sassess")
public class SassessController {
    @Resource(name = "SassessServiceImpl")
    private SassessServiceImpl sassessService;
    @RequestMapping(value = "/sassesslist")
    public void ChooseList(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");
        String pageIndex = req.getParameter("pageIndex");
        String pageSize = req.getParameter("pageSize");
        int index = Integer.parseInt(pageIndex);
        int size = Integer.parseInt(pageSize);
        String chaxunbookname = req.getParameter("chaxunbookname");
        String chaxunbooktype=req.getParameter("chaxunbooktype");
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        SassessService sassessService=(SassessService)context.getBean("SassessServiceImpl");

        if(req.getParameter("chaxunbooktype") != null || req.getParameter("chaxunbookname") != null ){
            if ("".equals(chaxunbookname)){
                chaxunbookname=null;
            }
            if ("".equals(chaxunbooktype)){
                chaxunbooktype=null;
            }

            int count = sassessService.FindAllSassessNum(index, size, chaxunbookname, chaxunbooktype);
            List<Sassess> boList = sassessService.FindAllSassess(index, size, chaxunbookname, chaxunbooktype);
            List<Map<String, Object>> list= new ArrayList<Map<String,Object>>();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("total", count);
            map.put("data", boList);
            String jsonString = JSON.toJSONString(map);
            resp.getWriter().write(jsonString);
        }
        else{
            int count = sassessService.FindAllSassessNum(index, size, null,null);
            List<Sassess> boList = sassessService.FindAllSassess(index, size, null,null);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("total", count);
            map.put("data", boList);

            String jsonString = JSON.toJSONString(map);
            resp.getWriter().write(jsonString);

        }
    }
}
