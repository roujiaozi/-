package com.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ssm.entity.Course;
import com.ssm.entity.Student;
import com.ssm.entity.Teacher;
import com.ssm.service.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Resource(name = "CourseServiceImpl")
    private CourseServiceImpl courseService;
    @RequestMapping(value = "/courselist")
    public void StudentList(HttpServletRequest req, HttpServletResponse resp) throws IOException {
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
        CourseService courseService=(CourseService)context.getBean("CourseServiceImpl");
        TeacherService teacherService=(TeacherService)context.getBean("TeacherServiceImpl");

        if(req.getParameter("chaxunbooktype") != null || req.getParameter("chaxunbookname") != null ){
            if ("".equals(chaxunbookname)){
                chaxunbookname=null;
            }
            if ("".equals(chaxunbooktype)){
                chaxunbooktype=null;
            }

            int count = courseService.FindAllCourseNum(index, size, chaxunbookname, chaxunbooktype);
            List<Course> boList = courseService.FindAllCourse(index, size, chaxunbookname, chaxunbooktype);
            List<Map<String, Object>> list= new ArrayList<Map<String,Object>>();
            for(Course cc:boList) {
                Map<String, Object> newmap = new HashMap<String, Object>();
                newmap.put("cid", cc.getCid());
                newmap.put("cname", cc.getCname());
                newmap.put("tid",cc.getTid());
                if(teacherService.findOneTeacher(cc.getTid())!=null)
                    newmap.put("tname",teacherService.findOneTeacher(cc.getTid()).getTname() );
                newmap.put("credit", cc.getCredit());
                newmap.put("shape", cc.getShape());
                newmap.put("remain", cc.getRemain());
                list.add(newmap);
            }
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("total", count);
            map.put("data", list);

            String jsonString = JSON.toJSONString(map);
            resp.getWriter().write(jsonString);


        }
        else{
            int count = courseService.FindAllCourseNum(index, size, null,null);
            List<Course> boList = courseService.FindAllCourse(index, size, null,null);
            List<Map<String, Object>> list= new ArrayList<Map<String,Object>>();
            for(Course cc:boList) {
                Map<String, Object> newmap = new HashMap<String, Object>();
                newmap.put("cid", cc.getCid());
                newmap.put("cname", cc.getCname());
                newmap.put("tid",cc.getTid());
                if(teacherService.findOneTeacher(cc.getTid())!=null)
                    newmap.put("tname",teacherService.findOneTeacher(cc.getTid()).getTname() );

                newmap.put("credit", cc.getCredit());
                newmap.put("shape", cc.getShape());
                newmap.put("remain", cc.getRemain());
                list.add(newmap);
            }
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("total", count);
            map.put("data", list);

            String jsonString = JSON.toJSONString(map);
            resp.getWriter().write(jsonString);

        }
    }

    @RequestMapping(value = "/deleteCourse")
    public void  deleteCourse (HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("UTF-8");
        List<String> listSuccess=new ArrayList<>();
        List<String> listFail=new ArrayList<>();
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CourseService courseService = (CourseService) context.getBean("CourseServiceImpl");
        ChooseService chooseService = (ChooseService) context.getBean("ChooseServiceImpl");
        String ids = req.getParameter("id");
        if (ids != null) {
            String[] arr = ids.split(",");
            for (int i = 0; i < arr.length; i++) {
                System.out.println("aaaaa"+arr[i]);
                System.out.println("daxiao"+chooseService.ExistCid(arr[i]).size());
                if(chooseService.ExistCid(arr[i]).size()>0){
                    listFail.add(arr[i]);
                }else {
                    listSuccess.add(arr[i]);
                    courseService.courseDelete(arr[i]);
                }
            }
            String msg1=Arrays.toString(listSuccess.toArray());
            msg1="[]".equals(msg1)?"":msg1+"删除成功";
            String msg2=Arrays.toString(listFail.toArray());
            msg2="[]".equals(msg2)?"":msg2+"存在未选课记录无法删除";
            resp.getWriter().print(msg1+"<br/>"+msg2);
        }
    }
    @RequestMapping(value = "/addCourse")
    public void  addCourse (HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String method = req.getParameter("method");
        //设置修改借阅页面的数据
        if (method != null && method.equals("getborrowid")) {
            ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
            CourseService courseService=(CourseService)context.getBean("CourseServiceImpl");
            String cid=courseService.getCourseId();
            System.out.println(cid);
            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            Map<String, Object> map = new HashMap();
            map.put("cid", cid);
            list.add(map);
            String str = JSON.toJSON(list).toString();
            System.out.println(str);
            resp.getWriter().print(str);
        }
        else if(method != null && method.equals("teacherName"))
        {
            ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
            TeacherService teacherService=(TeacherService)context.getBean("TeacherServiceImpl");
            List<Teacher> list=teacherService.findAllTeacher();
            String teacherName=JSON.toJSONString(list);
            resp.getWriter().print(teacherName);
        }
        else {
            String data=req.getParameter("data");
            Course course= JSONObject.parseObject(data,Course.class);
            ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
            CourseService courseService=(CourseService)context.getBean("CourseServiceImpl");
            courseService.courseAdd(course);
        }


    }
    @RequestMapping(value = "/updateCourse")
    public void  updateCourse (HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String method = req.getParameter("method");
        if (method != null && method.equals("findStudent")){
            ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
            CourseService courseService=(CourseService)context.getBean("CourseServiceImpl");
            String cid=req.getParameter("id");
            Course course=courseService.FindOneCourse(cid);
            String json=JSON.toJSONString(course);
            resp.getWriter().print(json);
        }
        else if(method != null && method.equals("teacherName")){
            ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
            TeacherService teacherService=(TeacherService)context.getBean("TeacherServiceImpl");
            List<Teacher> list=teacherService.findAllTeacher();
            String json=JSON.toJSONString(list);
            resp.getWriter().print(json);
        }
        else {
            ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
            CourseService courseService=(CourseService)context.getBean("CourseServiceImpl");
            String data=req.getParameter("data");
            Course course= JSONObject.parseObject(data,Course.class);
            courseService.courseUpdate(course);
        }

    }
    @RequestMapping(value = "/chooseAddCourse")
    public void  chooseCourse (HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        CourseService courseService=(CourseService)context.getBean("CourseServiceImpl");
        List<Course> list = courseService.FindAllCourse();
        String jsonString = JSON.toJSONString(list);
        resp.getWriter().print(jsonString);
    }
    @RequestMapping(value = "/chooseAddCourseName")
    public void  chooseAddCourseName (HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        CourseService courseService=(CourseService)context.getBean("CourseServiceImpl");
        String id = req.getParameter("id");
        Course course = courseService.FindOneCourse(id);
        resp.getWriter().print(course.getCname());
    }
}
