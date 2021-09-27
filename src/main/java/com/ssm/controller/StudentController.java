package com.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ssm.dao.StudentDao;
import com.ssm.entity.Choose;
import com.ssm.entity.Student;
import com.ssm.service.ChooseService;
import com.ssm.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Resource(name = "StudentServiceImpl")
    private StudentService userService;
@RequestMapping(value="/studentlist")
    public void StudentList(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    req.setCharacterEncoding("utf-8");
    resp.setCharacterEncoding("UTF-8");
    String method = req.getParameter("method");
    String pageIndex = req.getParameter("pageIndex");
    String pageSize = req.getParameter("pageSize");
    int index = Integer.parseInt(pageIndex);
    int size = Integer.parseInt(pageSize);
    String chaxunbookname = req.getParameter("chaxunbookname");
    if(req.getParameter("chaxunbooktype") != null || req.getParameter("chaxunbookname") != null ){
        int chaxunbooktype;
        //字符转int的非""判断
        if("".equals(req.getParameter("chaxunbooktype"))) {
            chaxunbooktype=0;
        }
        else if (req.getParameter("chaxunbooktype")==null)
        {
            chaxunbooktype=0;
        }else
            {
            chaxunbooktype = Integer.parseInt(req.getParameter("chaxunbooktype"));
        }
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService userService=(StudentService)context.getBean("StudentServiceImpl");
        int count = userService.findAllFenYeStudentNum(index, size, chaxunbookname.trim(), chaxunbooktype);
        // 获取学生信息（默认第一页）
        List<Student> boList = userService.findAllFenYeStudent(index, size, chaxunbookname.trim(), chaxunbooktype);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", count);
        map.put("data", boList);
        String jsonString = JSON.toJSONString(map);
        resp.getWriter().write(jsonString);


    }
    else{

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService userService = (StudentService) context.getBean("StudentServiceImpl");
        int count = userService.findAllFenYeStudentNum(index, size,null,0);
        // 获取学生信息（默认第一页）
        List<Student> boList = userService.findAllStudent(index, size);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", count);
        map.put("data", boList);
        String jsonString = JSON.toJSONString(map);
        System.out.println(jsonString);
        resp.getWriter().write(jsonString);

    }
    }



    @RequestMapping(value = "/deleteStudent")
    public void  deleteStudent (HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("UTF-8");
        List<String> listSuccess=new ArrayList<>();
        List<String> listFail=new ArrayList<>();
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService userService=(StudentService)context.getBean("StudentServiceImpl");
        ChooseService chooseService=(ChooseService)context.getBean("ChooseServiceImpl");
        String ids=req.getParameter("id");
        String[] arr = ids.split(",");
        for (int i=0;i<arr.length;i++){
            if(chooseService.ExistChoose(arr[i])!=null){
                listFail.add(arr[i]);
            }
            else {
                listSuccess.add(arr[i]);
                userService.deleteStudent(arr[i]);
            }
        }
        String msg1=Arrays.toString(listSuccess.toArray());
        msg1="[]".equals(msg1)?"":msg1+"删除成功";
        String msg2=Arrays.toString(listFail.toArray());
        msg2="[]".equals(msg2)?"":msg2+"存在选课记录无法删除";
        resp.getWriter().print(msg1+"<br/>"+msg2);
    }
    @RequestMapping(value = "/updateStudent")
    public void  updateStudent (HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("UTF-8");
        String id;
        String method=req.getParameter("method");
        id=req.getParameter("id");
        //根据id找到实体类的数据并json
        if(method.equals("findStudent")) {
            ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
            StudentService userService=(StudentService)context.getBean("StudentServiceImpl");
            Student stu=userService.findOneStudent(id);
            String jsonString = JSON.toJSONString(stu);
            System.out.println(jsonString);
            resp.getWriter().print(jsonString);
        }
        else if(method.equals("editStudent")){
            ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
            StudentService userService=(StudentService)context.getBean("StudentServiceImpl");
            String data=req.getParameter("data");
            Student student= JSONObject.parseObject(data,Student.class);
            userService.updateStudent(student);

        }
    }
    @RequestMapping("addStudent")
    public void addStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");
        System.out.println("addStudent");
        //设置修改借阅页面的数据
        if (method != null && method.equals("getborrowid")) {
            ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
            StudentService userService=(StudentService)context.getBean("StudentServiceImpl");
            String sid = userService.getSid();
            System.out.println(sid);
            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            Map<String, Object> map = new HashMap();
            map.put("sid", sid);
            list.add(map);
            String str = JSON.toJSON(list).toString();
            System.out.println(str);
            resp.getWriter().print(str);
        }
        else {
            String data=req.getParameter("data");
            Student bb=JSONObject.parseObject(data,Student.class);
            ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
            StudentService userService=(StudentService)context.getBean("StudentServiceImpl");
            System.out.println(bb.toString());
            userService.addStudent(bb);
        }


    }
    @RequestMapping("ChooseAddStudent")
    public void ChooseAddStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("UTF-8");
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService userService=(StudentService)context.getBean("StudentServiceImpl");
        List<Student> student = userService.findAllStudentList();
        String jsonString = JSON.toJSONString(student);
        resp.getWriter().print(jsonString);
    }
    @RequestMapping("ChooseAddStudentName")
    public void ChooseAddStudentName(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("UTF-8");
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService userService=(StudentService)context.getBean("StudentServiceImpl");
        String id=req.getParameter("id");
        Student student = userService.findOneStudent(id);
        resp.getWriter().print(student.getSname());
    }
    }


