package com.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ssm.entity.Choose;
import com.ssm.entity.Course;
import com.ssm.entity.Student;
import com.ssm.service.*;
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
@RequestMapping("/choose")
public class ChooseController {
    @Resource(name = "ChooseServiceImpl")
    private ChooseServiceImpl chooseService;
    @RequestMapping(value = "/chooselist")
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
        ChooseService chooseService=(ChooseService)context.getBean("ChooseServiceImpl");

        if(req.getParameter("chaxunbooktype") != null || req.getParameter("chaxunbookname") != null ){
            if ("".equals(chaxunbookname)){
                chaxunbookname=null;
            }
            if ("".equals(chaxunbooktype)){
                chaxunbooktype=null;
            }

            int count = chooseService.FindAllChooseNum(index,size,chaxunbookname,chaxunbooktype);
            List<Choose> boList = chooseService.FindAllChoose(index, size, chaxunbookname, chaxunbooktype);
            List<Map<String, Object>> list= new ArrayList<Map<String,Object>>();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("total", count);
            map.put("data", boList);
            String jsonString = JSON.toJSONString(map);
            resp.getWriter().write(jsonString);
        }
        else{
            int count = chooseService.FindAllChooseNum(index,size,null,null);
            List<Choose> boList = chooseService.FindAllChoose(index, size, null,null);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("total", count);
            map.put("data", boList);

            String jsonString = JSON.toJSONString(map);
            resp.getWriter().write(jsonString);

        }
    }
    @RequestMapping(value = "/chooseAdd")
    public void ChooseAdd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("UTF-8");
        String json = req.getParameter("data");
        Choose choose = JSONObject.parseObject(json, Choose.class);
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        ChooseService chooseService=(ChooseService)context.getBean("ChooseServiceImpl");
        CourseService courseService=(CourseService)context.getBean("CourseServiceImpl");
        //判断此课程是否有次老师教授
        if (courseService.FindOneCourse(choose.getCid()).getTid().equals(choose.getTid())) {

            //判断数量是否大于0
            if (courseService.FindOneCourse(choose.getCid()).getRemain() > 0) {
                //判断次课程是否被选过
                if(chooseService.FindOneChoose(choose.getSid(),choose.getCid(),choose.getTid())==null) {
                    int num = courseService.FindOneCourse(choose.getCid()).getRemain();
                    Course course = courseService.FindOneCourse(choose.getCid());
                    course.setRemain(num-1);
                    courseService.courseUpdate(course);
                    chooseService.chooseAdd(choose);
                    resp.getWriter().print("选课成功");
                }
                else
                {
                    resp.getWriter().print("您已经选过此课程");
                }
            }
            else {
                resp.getWriter().print("数量不足，选课失败");
            }
        }
        else {
            resp.getWriter().print("此老师未教授次课程，请重新选择");
        }
    }


}
