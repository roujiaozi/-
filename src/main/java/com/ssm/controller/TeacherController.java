package com.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ssm.entity.Course;
import com.ssm.entity.Student;
import com.ssm.entity.Teacher;
import com.ssm.service.CourseService;
import com.ssm.service.StudentService;
import com.ssm.service.TeacherService;
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
@RequestMapping("/teacher")
public class TeacherController {
    @Resource(name = "TeacherServiceImpl")
    private TeacherService teacherService;
    @RequestMapping(value="/teacherlist")
    public void TeacherList(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");
        String pageIndex = req.getParameter("pageIndex");
        String pageSize = req.getParameter("pageSize");
        int index = Integer.parseInt(pageIndex);
        int size = Integer.parseInt(pageSize);
        String chaxunbookname = req.getParameter("chaxunbookname");
        if(chaxunbookname!= null ){
            ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
            TeacherService teacherService=(TeacherService)context.getBean("TeacherServiceImpl");
            int count = teacherService.findAllFenYeTeacherNum(index,size,chaxunbookname);
            // 获取学生信息（默认第一页）
            List<Teacher> boList = teacherService.findAllFenYeTeacher(index,size,chaxunbookname);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("total", count);
            map.put("data", boList);
            String jsonString = JSON.toJSONString(map);
            resp.getWriter().write(jsonString);


        }
        else{

            ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
            TeacherService teacherService = (TeacherService) context.getBean("TeacherServiceImpl");
            int count = teacherService.findAllFenYeTeacherNum(index,size,null);
            // 获取学生信息（默认第一页）
            List<Teacher> boList = teacherService.findAllFenYeTeacher(index,size,null);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("total", count);
            map.put("data", boList);
            String jsonString = JSON.toJSONString(map);
            System.out.println(jsonString);
            resp.getWriter().write(jsonString);

        }

    }
    @RequestMapping(value="/teacheradd")
    public void TeacherAdd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String method = req.getParameter("method");
        //设置修改借阅页面的数据
        if (method != null && method.equals("getborrowid")) {
            ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
            TeacherService teacherService=(TeacherService)context.getBean("TeacherServiceImpl");
            String tid = teacherService.getTid();
            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            Map<String, Object> map = new HashMap();
            map.put("tid", tid);
            list.add(map);
            String str = JSON.toJSON(list).toString();
            System.out.println(str);
            resp.getWriter().print(str);
        }
        else {
            String data=req.getParameter("data");
            Teacher bb=JSONObject.parseObject(data,Teacher.class);
            ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
            TeacherService teacherService=(TeacherService)context.getBean("TeacherServiceImpl");
            System.out.println(bb.toString());
            teacherService.addTeacher(bb);
        }


    }
    @RequestMapping(value="/teacherdelete")
    public void TeacherDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("UTF-8");
        List<String> listSuccess=new ArrayList<>();
        List<String> listFail=new ArrayList<>();
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        TeacherService teacherService=(TeacherService)context.getBean("TeacherServiceImpl");
        CourseService courseService=(CourseService)context.getBean("CourseServiceImpl");
        String ids=req.getParameter("id");
        String[] arr = ids.split(",");
        for (int i=0;i<arr.length;i++){
            System.out.println("aaaa"+arr[i]);
            if(courseService.ExistCourse(arr[i]).size()!=0){
                System.out.println("不能删除"+arr[i]);
                listFail.add(arr[i]);
            }
            else{
                System.out.println("删除"+arr[i]);
                listSuccess.add(arr[i]);
                teacherService.deleteTeacher(arr[i]);
            }
        }
        String msg1=Arrays.toString(listSuccess.toArray());
        msg1="[]".equals(msg1)?"":msg1+"删除成功";
        String msg2=Arrays.toString(listFail.toArray());
        msg2="[]".equals(msg2)?"":msg2+"存在未归还记录无法删除";
        resp.getWriter().print(msg1+"<br/>"+msg2);

    }
    @RequestMapping(value="/teacherupdate")
    public void TeacherUpdate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("UTF-8");
        String id;
        String method=req.getParameter("method");
        id=req.getParameter("id");
        //根据id找到实体类的数据并json
        if(method.equals("findStudent")) {
            ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
            TeacherService teacherService=(TeacherService)context.getBean("TeacherServiceImpl");
            Teacher stu=teacherService.findOneTeacher(id);
            String jsonString = JSON.toJSONString(stu);
            System.out.println(jsonString);
            resp.getWriter().print(jsonString);
        }
        else if(method.equals("editStudent")){
            ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
            TeacherService teacherService=(TeacherService)context.getBean("TeacherServiceImpl");
            String data=req.getParameter("data");
            Teacher teacher= JSONObject.parseObject(data,Teacher.class);
            teacherService.updateTeacher(teacher);

        }

    }
    @RequestMapping(value="/ChooseTeacherAdd")
    public void ChooseTeacherAdd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("UTF-8");
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        TeacherService teacherService=(TeacherService)context.getBean("TeacherServiceImpl");
        List<Teacher> allTeacher = teacherService.findAllTeacher();
        String jsonString = JSON.toJSONString(allTeacher);
        resp.getWriter().print(jsonString);
    }
    @RequestMapping(value="/ChooseTeacherAddName")
    public void ChooseTeacherAddName(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("UTF-8");
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        TeacherService teacherService=(TeacherService)context.getBean("TeacherServiceImpl");
        String id = req.getParameter("id");
        Teacher teacher = teacherService.findOneTeacher(id);
        resp.getWriter().print(teacher.getTname());
    }
}
