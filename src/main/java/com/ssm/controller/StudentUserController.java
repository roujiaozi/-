package com.ssm.controller;

import com.alibaba.druid.support.json.JSONUtils;
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
@RequestMapping("/studentUser")
public class StudentUserController {

    @RequestMapping("/studentUserDetail")
    public void StudentDetail(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("UTF-8");
        String sid = req.getParameter("sid");
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService userService = (StudentService) context.getBean("StudentServiceImpl");
        Student oneStudent = userService.findOneStudent(sid);
        String json = JSON.toJSONString(oneStudent);
        resp.getWriter().print(json);

    }

    @RequestMapping("/studentUserUpdate")
    public void StudentUpdate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("UTF-8");
        String sid = req.getParameter("sid");
        String data = req.getParameter("data");
        JSONObject jsonObject = JSONObject.parseObject(data);
        String pwd1 = jsonObject.getString("pwd1");
        System.out.println(pwd1);
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService userService = (StudentService) context.getBean("StudentServiceImpl");
        Student oneStudent = userService.findOneStudent(sid);
        oneStudent.setPassword(pwd1);
        userService.updateStudent(oneStudent);
        resp.getWriter().print("修改成功");
    }

    //学生用户选课
    @RequestMapping("/studentcouese")
    public void StudentCourse(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("UTF-8");
        String sid = req.getParameter("sid");
        String cid = req.getParameter("cid");
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CourseService courseService = (CourseService) context.getBean("CourseServiceImpl");
        ChooseService chooseService = (ChooseService) context.getBean("ChooseServiceImpl");
        TeacherService teacherService = (TeacherService) context.getBean("TeacherServiceImpl");
        //判断此课程是否被选过
        List<Choose> list = chooseService.FindAllChoose(0, chooseService.FindAllNum(), null, null);
        boolean result = false;
        for (Choose choose : list) {
            if (choose.getCid().equals(cid) && choose.getSid().equals(sid)) {
                result = true;
            }
        }
        if (result) {
            resp.getWriter().print("选课失败，您已经选过此课程");
        } else {
            //判断此课程数量是否大于0
            if(courseService.FindOneCourse(cid).getRemain()>0) {
                Course course = courseService.FindOneCourse(cid);
                int num=course.getRemain();
                course.setRemain(num-1);
                courseService.courseUpdate(course);
                Teacher teacher = teacherService.findOneTeacher(course.getTid());
                Choose choose = new Choose();
                choose.setCid(course.getCid());
                choose.setCname(course.getCname());
                choose.setSid(sid);
                choose.setTid(course.getTid());
                choose.setTname(teacher.getTname());
                chooseService.chooseAdd(choose);
                resp.getWriter().print("选课成功");
            }
            else {
                resp.getWriter().print("课程数量不足");
            }
        }
    }

    //选课记录查看
    @RequestMapping("/studentchooselist")
    public void StudentChooseList(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");
        String pageIndex = req.getParameter("pageIndex");
        String pageSize = req.getParameter("pageSize");
        int index = Integer.parseInt(pageIndex);
        int size = Integer.parseInt(pageSize);
        String chaxunbookname = req.getParameter("chaxunbookname");
        String chaxunbooktype = req.getParameter("chaxunbooktype");
        String sid = req.getParameter("sid");
        System.out.println("sid=" + sid);
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ChooseService chooseService = (ChooseService) context.getBean("ChooseServiceImpl");

        if (req.getParameter("chaxunbooktype") != null || req.getParameter("chaxunbookname") != null) {
            if ("".equals(chaxunbookname)) {
                chaxunbookname = null;
            }
            if ("".equals(chaxunbooktype)) {
                chaxunbooktype = null;
            }

            int count = chooseService.FindAllChooseNum(index, size, chaxunbookname, chaxunbooktype, sid);
            List<Choose> boList = chooseService.FindAllChoose(index, size, chaxunbookname, chaxunbooktype, sid);
            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("total", count);
            map.put("data", boList);
            String jsonString = JSON.toJSONString(map);
            resp.getWriter().write(jsonString);
        } else {
            int count = chooseService.FindAllChooseNum(index, size, null, null, sid);
            List<Choose> boList = chooseService.FindAllChoose(index, size, null, null, sid);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("total", count);
            map.put("data", boList);

            String jsonString = JSON.toJSONString(map);
            resp.getWriter().write(jsonString);

        }

    }

    //学生对老师评价添加
    @RequestMapping("/sassess")
    public void Sassess(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("UTF-8");
        //判断是否对此老师已经测评
        String data = req.getParameter("data");
        Sassess sassess = JSONObject.parseObject(data, Sassess.class);
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SassessService sassessService = (SassessService) context.getBean("SassessServiceImpl");
        if(sassessService.FindOneSassess(sassess.getSid(),sassess.getCid(),sassess.getTid())!=null)
        {
            resp.getWriter().print("您已经对此老师的此课程进行了测评");
        }
        else {
            sassessService.SassessAdd(sassess);
            resp.getWriter().print("测评成功");
        }
    }
    //学生个人的评价记录
    @RequestMapping("/sassesslist")
    public void SassessList(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");
        String pageIndex = req.getParameter("pageIndex");
        String pageSize = req.getParameter("pageSize");
        int index = Integer.parseInt(pageIndex);
        int size = Integer.parseInt(pageSize);
        String chaxunbookname = req.getParameter("chaxunbookname");
        String chaxunbooktype = req.getParameter("chaxunbooktype");
        String sid = req.getParameter("sid");
        System.out.println("sid=" + sid);
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SassessService sassessService = (SassessService) context.getBean("SassessServiceImpl");

        if (req.getParameter("chaxunbooktype") != null || req.getParameter("chaxunbookname") != null) {
            if ("".equals(chaxunbookname)) {
                chaxunbookname = null;
            }
            if ("".equals(chaxunbooktype)) {
                chaxunbooktype = null;
            }

            int count = sassessService.FindAllSassessNum(index, size, chaxunbookname, chaxunbooktype, sid);
            List<Sassess> boList = sassessService.FindAllSassess(index, size, chaxunbookname, chaxunbooktype, sid);
            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("total", count);
            map.put("data", boList);
            String jsonString = JSON.toJSONString(map);
            resp.getWriter().write(jsonString);
        } else {
            int count = sassessService.FindAllSassessNum(index, size, null, null, sid);
            List<Sassess> boList = sassessService.FindAllSassess(index, size, null, null, sid);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("total", count);
            map.put("data", boList);

            String jsonString = JSON.toJSONString(map);
            resp.getWriter().write(jsonString);

        }

    }
}
