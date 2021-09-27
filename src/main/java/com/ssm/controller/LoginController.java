package com.ssm.controller;

import com.alibaba.fastjson.JSONObject;
import com.ssm.entity.Sassess;
import com.ssm.entity.Student;
import com.ssm.entity.Teacher;
import com.ssm.service.ChooseService;
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
@Controller
public class LoginController {
    @RequestMapping(value = "/login")
    public void Login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("UTF-8");
        String json = req.getParameter("data");
        JSONObject jsonObject = JSONObject.parseObject(json);
        String username=jsonObject.getString("username");
        String pwd=jsonObject.getString("pwd");
        String gender=jsonObject.getString("gender");
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        if("1".equals(gender)){
        //学生
            StudentService userService=(StudentService)context.getBean("StudentServiceImpl");
            Student oneStudent = userService.findOneStudent(username);
            if(oneStudent!=null){
                if(oneStudent.getSid().equals(username) && oneStudent.getPassword().equals(pwd)) {
                    req.setAttribute("sid", username);
                    resp.getWriter().print("../../pages/student/index.html");
                }
                else{
                    resp.getWriter().print("账户密码不匹配");
                }
            }

            else
            {
                resp.getWriter().print("账户错误");
            }
        }
        else if ("2".equals(gender)){
        //老师
            TeacherService userService=(TeacherService)context.getBean("TeacherServiceImpl");
            Teacher oneTeacher = userService.findOneTeacher(username);
            if(oneTeacher!=null){
                if(oneTeacher.getTid().equals(username) && oneTeacher.getPassword().equals(pwd))

                   {
                       req.setAttribute("tid", username);
                       resp.getWriter().print("../../pages/teacher/index.html");
                   }
                else{
                    resp.getWriter().print("账户密码不匹配");
                }
            }

            else
            {
                resp.getWriter().print("账户错误");
            }
        }
        else{
        //管理员

            if("aaa111".equals(username)&&"123456".equals(pwd)){
                resp.getWriter().print("../../pages/studentinfo/index.html");
            }
            else
            {
                resp.getWriter().print("账户密码不匹配");
            }
        }

    }

}
