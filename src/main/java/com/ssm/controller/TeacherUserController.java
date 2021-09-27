package com.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ssm.entity.*;
import com.ssm.service.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
@RequestMapping("/teacherUser")
public class TeacherUserController {
    @RequestMapping("/teacherUserDetail")
    public void StudentDetail(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("UTF-8");
        String tid = req.getParameter("tid");
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        TeacherService teacherService = (TeacherService) context.getBean("TeacherServiceImpl");
        Teacher oneTeacher = teacherService.findOneTeacher(tid);
        String json = JSON.toJSONString(oneTeacher);
        resp.getWriter().print(json);

    }

    @RequestMapping("/teacherUserUpdate")
    public void StudentUpdate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("UTF-8");
        String sid = req.getParameter("tid");
        String data = req.getParameter("data");
        JSONObject jsonObject = JSONObject.parseObject(data);
        String pwd1 = jsonObject.getString("pwd1");
        System.out.println("sid"+sid);
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        TeacherService teacherService = (TeacherService) context.getBean("TeacherServiceImpl");
        Teacher oneTeacher = teacherService.findOneTeacher(sid);
        System.out.println("aaaaaa"+oneTeacher.toString());
        oneTeacher.setPassword(pwd1);
        teacherService.updateTeacher(oneTeacher);
        resp.getWriter().print("修改成功");
    }
    @RequestMapping("/teacherTassess")
    public void StudentTassess(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("UTF-8");
        String data = req.getParameter("data");
        Tassess tassess = JSONObject.parseObject(data, Tassess.class);
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        TassessService tassessService = (TassessService) context.getBean("TassessServiceImpl");
        if(tassessService.FindOneTassess(tassess.getTid(),tassess.getCid(),tassess.getTid1())!=null)
        {
            resp.getWriter().print("您已经对此老师的此课程进行了测评");
        }
        else {
            tassessService.TassessAdd(tassess);
            resp.getWriter().print("测评成功");
        }
    }
    @RequestMapping("/teachertassesslist")
    public void StudentTassessList(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");
        String pageIndex = req.getParameter("pageIndex");
        String pageSize = req.getParameter("pageSize");
        int index = Integer.parseInt(pageIndex);
        int size = Integer.parseInt(pageSize);
        String chaxunbookname = req.getParameter("chaxunbookname");
        String chaxunbooktype = req.getParameter("chaxunbooktype");
        String tid1 = req.getParameter("sid");
        System.out.println("tid1"+tid1);
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        TassessService tassessService = (TassessService) context.getBean("TassessServiceImpl");

        if (req.getParameter("chaxunbooktype") != null || req.getParameter("chaxunbookname") != null) {
            if ("".equals(chaxunbookname)) {
                chaxunbookname = null;
            }
            if ("".equals(chaxunbooktype)) {
                chaxunbooktype = null;
            }

            int count = tassessService.FindAllNum();
            List<Tassess> boList = tassessService.FindAllTassess(index, size, chaxunbookname, chaxunbooktype, tid1);
            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("total", count);
            map.put("data", boList);
            String jsonString = JSON.toJSONString(map);
            resp.getWriter().write(jsonString);
        } else {
            int count = tassessService.FindAllNum();
            List<Tassess> boList = tassessService.FindAllTassess(index, size, null, null, tid1);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("total", count);
            map.put("data", boList);

            String jsonString = JSON.toJSONString(map);
            resp.getWriter().write(jsonString);

        }

    }
}
