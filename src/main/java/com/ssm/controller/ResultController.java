package com.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.ssm.entity.Course;
import com.ssm.entity.Sassess;
import com.ssm.entity.Tassess;
import com.ssm.service.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class ResultController {
    @RequestMapping("/result")
    public void ChooseList(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("UTF-8");
        String cid = req.getParameter("cid");
        String tid = req.getParameter("tid");
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        SassessService sassessService=(SassessService)context.getBean("SassessServiceImpl");
        TassessService tassessService=(TassessService)context.getBean("TassessServiceImpl");
        List<Tassess> tassessesList = tassessService.FindAllTassess(tid, cid);
        List<Sassess> sassessList = sassessService.FindAllSassess(tid, cid);
        LongSummaryStatistics lss1 = tassessesList.stream().collect(Collectors.summarizingLong(Tassess::getQuestion1));
         double tquestion1 = lss1.getAverage();
        BigDecimal t1=new BigDecimal(tquestion1+"");
        LongSummaryStatistics lss2 = tassessesList.stream().collect(Collectors.summarizingLong(Tassess::getQuestion2));
         double tquestion2 = lss2.getAverage();
        BigDecimal t2=new BigDecimal(tquestion2+"");
        LongSummaryStatistics lss3 = tassessesList.stream().collect(Collectors.summarizingLong(Tassess::getQuestion3));
         double tquestion3 = lss3.getAverage();
        BigDecimal t3=new BigDecimal(tquestion3+"");
        LongSummaryStatistics lss4 = tassessesList.stream().collect(Collectors.summarizingLong(Tassess::getQuestion4));
         double tquestion4 = lss4.getAverage();
        BigDecimal t4=new BigDecimal(tquestion4+"");
        LongSummaryStatistics lss5 = tassessesList.stream().collect(Collectors.summarizingLong(Tassess::getQuestion5));
         double tquestion5 = lss5.getAverage();
        BigDecimal t5=new BigDecimal(tquestion5+"");

         LongSummaryStatistics lss6 = sassessList.stream().collect(Collectors.summarizingLong(Sassess::getQuestion1));
        double squestion1 = lss6.getAverage();
        BigDecimal s1=new BigDecimal(squestion1+"");
        LongSummaryStatistics lss7 = sassessList.stream().collect(Collectors.summarizingLong(Sassess::getQuestion2));
        double squestion2 = lss7.getAverage();
        BigDecimal s2=new BigDecimal(squestion2+"");
        LongSummaryStatistics lss8 = sassessList.stream().collect(Collectors.summarizingLong(Sassess::getQuestion3));
        double squestion3 = lss8.getAverage();
        BigDecimal s3=new BigDecimal(squestion3+"");
        LongSummaryStatistics lss9 = sassessList.stream().collect(Collectors.summarizingLong(Sassess::getQuestion4));
        double squestion4 = lss9.getAverage();
        BigDecimal s4=new BigDecimal(squestion4+"");
        LongSummaryStatistics lss10 = sassessList.stream().collect(Collectors.summarizingLong(Sassess::getQuestion5));
        double squestion5 = lss10.getAverage();
        BigDecimal s5=new BigDecimal(squestion5+"");



        BigDecimal t=new BigDecimal("0.3");
        BigDecimal s=new BigDecimal("0.7");
        double question1=s1.multiply(s).doubleValue()+t1.multiply(t).doubleValue();
        double question2=s2.multiply(s).doubleValue()+t2.multiply(t).doubleValue();
        double question3=s3.multiply(s).doubleValue()+t3.multiply(t).doubleValue();
        double question4=s4.multiply(s).doubleValue()+t4.multiply(t).doubleValue();
        double question5=s5.multiply(s).doubleValue()+t5.multiply(t).doubleValue();
        System.out.println("squestion1"+squestion1);
        System.out.println("squestion1*0.7"+squestion1*0.7);
        Map<String, Object> newmap = new HashMap<String, Object>();
        System.out.println("tquestion1"+tquestion1);
        System.out.println("tquestion1*0.3"+tquestion1*0.3);
        newmap.put("question1",question1);
        newmap.put("question2",question2);
        newmap.put("question3",question3);
        newmap.put("question4",question4);
        newmap.put("question5",question5);
        String jsonString = JSON.toJSONString(newmap);
        System.out.println(jsonString);
        resp.getWriter().write(jsonString);
    }
    @RequestMapping("/resultlist")
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

            int count = courseService.FindAllNum();
            List<Course> boList = courseService.FindAllCourse(index, size, chaxunbookname, chaxunbooktype);
            List<Map<String, Object>> list= new ArrayList<Map<String,Object>>();
            for(Course cc:boList) {
                SassessService sassessService = (SassessService) context.getBean("SassessServiceImpl");
                TassessService tassessService = (TassessService) context.getBean("TassessServiceImpl");
                List<Tassess> tassessesList = tassessService.FindAllTassess(cc.getTid(), cc.getCid());
                List<Sassess> sassessList = sassessService.FindAllSassess(cc.getTid(), cc.getCid());
                if (tassessesList.size() >= 2 && sassessList.size() >= 2) {
                    LongSummaryStatistics lss1 = tassessesList.stream().collect(Collectors.summarizingLong(Tassess::getQuestion1));
                    double tquestion1 = lss1.getAverage();
                    BigDecimal t1 = new BigDecimal(tquestion1 + "");
                    LongSummaryStatistics lss2 = tassessesList.stream().collect(Collectors.summarizingLong(Tassess::getQuestion2));
                    double tquestion2 = lss2.getAverage();
                    BigDecimal t2 = new BigDecimal(tquestion2 + "");
                    LongSummaryStatistics lss3 = tassessesList.stream().collect(Collectors.summarizingLong(Tassess::getQuestion3));
                    double tquestion3 = lss3.getAverage();
                    BigDecimal t3 = new BigDecimal(tquestion3 + "");
                    LongSummaryStatistics lss4 = tassessesList.stream().collect(Collectors.summarizingLong(Tassess::getQuestion4));
                    double tquestion4 = lss4.getAverage();
                    BigDecimal t4 = new BigDecimal(tquestion4 + "");
                    LongSummaryStatistics lss5 = tassessesList.stream().collect(Collectors.summarizingLong(Tassess::getQuestion5));
                    double tquestion5 = lss5.getAverage();
                    BigDecimal t5 = new BigDecimal(tquestion5 + "");

                    LongSummaryStatistics lss6 = sassessList.stream().collect(Collectors.summarizingLong(Sassess::getQuestion1));
                    double squestion1 = lss6.getAverage();
                    BigDecimal s1 = new BigDecimal(squestion1 + "");
                    LongSummaryStatistics lss7 = sassessList.stream().collect(Collectors.summarizingLong(Sassess::getQuestion2));
                    double squestion2 = lss7.getAverage();
                    BigDecimal s2 = new BigDecimal(squestion2 + "");
                    LongSummaryStatistics lss8 = sassessList.stream().collect(Collectors.summarizingLong(Sassess::getQuestion3));
                    double squestion3 = lss8.getAverage();
                    BigDecimal s3 = new BigDecimal(squestion3 + "");
                    LongSummaryStatistics lss9 = sassessList.stream().collect(Collectors.summarizingLong(Sassess::getQuestion4));
                    double squestion4 = lss9.getAverage();
                    BigDecimal s4 = new BigDecimal(squestion4 + "");
                    LongSummaryStatistics lss10 = sassessList.stream().collect(Collectors.summarizingLong(Sassess::getQuestion5));
                    double squestion5 = lss10.getAverage();
                    BigDecimal s5 = new BigDecimal(squestion5 + "");
                    BigDecimal t = new BigDecimal("0.3");
                    BigDecimal s = new BigDecimal("0.7");
                    double question1 = s1.multiply(s).doubleValue() + t1.multiply(t).doubleValue();
                    double question2 = s2.multiply(s).doubleValue() + t2.multiply(t).doubleValue();
                    double question3 = s3.multiply(s).doubleValue() + t3.multiply(t).doubleValue();
                    double question4 = s4.multiply(s).doubleValue() + t4.multiply(t).doubleValue();
                    double question5 = s5.multiply(s).doubleValue() + t5.multiply(t).doubleValue();
                    Map<String, Object> newmap = new HashMap<String, Object>();
                    newmap.put("cid", cc.getCid());
                    newmap.put("cname", cc.getCname());
                    newmap.put("tid", cc.getTid());
                    if (teacherService.findOneTeacher(cc.getTid()) != null)
                        newmap.put("tname", teacherService.findOneTeacher(cc.getTid()).getTname());
                    newmap.put("credit", cc.getCredit());
                    newmap.put("shape", cc.getShape());

                    if (question1 == 0 && question2 == 0 && question3 == 0 && question4 == 0 && question5 == 0) {
                        newmap.put("zongfen", "暂无评价");
                        newmap.put("question1", "");
                        newmap.put("question2", "");
                        newmap.put("question3", "");
                        newmap.put("question4", "");
                        newmap.put("question5", "");
                    } else {
                        newmap.put("zongfen", (question1 + question2 + question3 + question4 + question5) * 0.2);
                        newmap.put("question1", question1);
                        newmap.put("question2", question2);
                        newmap.put("question3", question3);
                        newmap.put("question4", question4);
                        newmap.put("question5", question5);
                    }
                    list.add(newmap);
                }
                else {
                    Map<String, Object> newmap = new HashMap<String, Object>();
                    newmap.put("cid", cc.getCid());
                    newmap.put("cname", cc.getCname());
                    newmap.put("tid", cc.getTid());
                    if (teacherService.findOneTeacher(cc.getTid()) != null) newmap.put("tname", teacherService.findOneTeacher(cc.getTid()).getTname());
                    newmap.put("credit", cc.getCredit());
                    newmap.put("shape", cc.getShape());
                    newmap.put("zongfen", "暂未评价");
                    newmap.put("question1", "");
                    newmap.put("question2", "");
                    newmap.put("question3", "");
                    newmap.put("question4", "");
                    newmap.put("question5", "");
                    list.add(newmap);
                }


            }
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("total", count);
            map.put("data", list);

            String jsonString = JSON.toJSONString(map);
            resp.getWriter().write(jsonString);


        }
        else{
            int count = courseService.FindAllNum();
            List<Course> boList = courseService.FindAllCourse(index, size, null,null);
            List<Map<String, Object>> list= new ArrayList<Map<String,Object>>();
            for(Course cc:boList) {
                SassessService sassessService=(SassessService)context.getBean("SassessServiceImpl");
                TassessService tassessService=(TassessService)context.getBean("TassessServiceImpl");
                List<Tassess> tassessesList = tassessService.FindAllTassess(cc.getTid(), cc.getCid());
                List<Sassess> sassessList = sassessService.FindAllSassess(cc.getTid(), cc.getCid());
                LongSummaryStatistics lss1 = tassessesList.stream().collect(Collectors.summarizingLong(Tassess::getQuestion1));
                double tquestion1 = lss1.getAverage();
                BigDecimal t1=new BigDecimal(tquestion1+"");
                LongSummaryStatistics lss2 = tassessesList.stream().collect(Collectors.summarizingLong(Tassess::getQuestion2));
                double tquestion2 = lss2.getAverage();
                BigDecimal t2=new BigDecimal(tquestion2+"");
                LongSummaryStatistics lss3 = tassessesList.stream().collect(Collectors.summarizingLong(Tassess::getQuestion3));
                double tquestion3 = lss3.getAverage();
                BigDecimal t3=new BigDecimal(tquestion3+"");
                LongSummaryStatistics lss4 = tassessesList.stream().collect(Collectors.summarizingLong(Tassess::getQuestion4));
                double tquestion4 = lss4.getAverage();
                BigDecimal t4=new BigDecimal(tquestion4+"");
                LongSummaryStatistics lss5 = tassessesList.stream().collect(Collectors.summarizingLong(Tassess::getQuestion5));
                double tquestion5 = lss5.getAverage();
                BigDecimal t5=new BigDecimal(tquestion5+"");

                LongSummaryStatistics lss6 = sassessList.stream().collect(Collectors.summarizingLong(Sassess::getQuestion1));
                double squestion1 = lss6.getAverage();
                BigDecimal s1=new BigDecimal(squestion1+"");
                LongSummaryStatistics lss7 = sassessList.stream().collect(Collectors.summarizingLong(Sassess::getQuestion2));
                double squestion2 = lss7.getAverage();
                BigDecimal s2=new BigDecimal(squestion2+"");
                LongSummaryStatistics lss8 = sassessList.stream().collect(Collectors.summarizingLong(Sassess::getQuestion3));
                double squestion3 = lss8.getAverage();
                BigDecimal s3=new BigDecimal(squestion3+"");
                LongSummaryStatistics lss9 = sassessList.stream().collect(Collectors.summarizingLong(Sassess::getQuestion4));
                double squestion4 = lss9.getAverage();
                BigDecimal s4=new BigDecimal(squestion4+"");
                LongSummaryStatistics lss10 = sassessList.stream().collect(Collectors.summarizingLong(Sassess::getQuestion5));
                double squestion5 = lss10.getAverage();
                BigDecimal s5=new BigDecimal(squestion5+"");
                BigDecimal t=new BigDecimal("0.3");
                BigDecimal s=new BigDecimal("0.7");
                double question1=s1.multiply(s).doubleValue()+t1.multiply(t).doubleValue();
                double question2=s2.multiply(s).doubleValue()+t2.multiply(t).doubleValue();
                double question3=s3.multiply(s).doubleValue()+t3.multiply(t).doubleValue();
                double question4=s4.multiply(s).doubleValue()+t4.multiply(t).doubleValue();
                double question5=s5.multiply(s).doubleValue()+t5.multiply(t).doubleValue();
                Map<String, Object> newmap = new HashMap<String, Object>();
                newmap.put("cid", cc.getCid());
                newmap.put("cname", cc.getCname());
                newmap.put("tid",cc.getTid());
                if(teacherService.findOneTeacher(cc.getTid())!=null)
                    newmap.put("tname",teacherService.findOneTeacher(cc.getTid()).getTname() );

                newmap.put("credit", cc.getCredit());
                newmap.put("shape", cc.getShape());

                if(question1==0 && question2==0 && question3==0 && question4==0 && question5==0) {
                    newmap.put("zongfen", "暂无评价");
                    newmap.put("question1", "");
                    newmap.put("question2", "");
                    newmap.put("question3", "");
                    newmap.put("question4", "");
                    newmap.put("question5", "");
                }
                else {
                    newmap.put("zongfen",(question1+question2+question3+question4+question5)*0.2);
                    newmap.put("question1", question1);
                    newmap.put("question2", question2);
                    newmap.put("question3", question3);
                    newmap.put("question4", question4);
                    newmap.put("question5", question5);
                }
                list.add(newmap);
            }
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("total", count);
            map.put("data", list);

            String jsonString = JSON.toJSONString(map);
            resp.getWriter().write(jsonString);

        }
    }
    @RequestMapping("/resultteacherlist")
    public void ResultTeacherList(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");
        String pageIndex = req.getParameter("pageIndex");
        String pageSize = req.getParameter("pageSize");
        String tid = req.getParameter("tid");
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

            int count = courseService.FindAllNum();
            List<Course> boList = courseService.FindAllCourse(index, size, chaxunbookname, chaxunbooktype,tid);
            List<Map<String, Object>> list= new ArrayList<Map<String,Object>>();
            for(Course cc:boList) {
                SassessService sassessService = (SassessService) context.getBean("SassessServiceImpl");
                TassessService tassessService = (TassessService) context.getBean("TassessServiceImpl");
                List<Tassess> tassessesList = tassessService.FindAllTassess(cc.getTid(), cc.getCid());
                List<Sassess> sassessList = sassessService.FindAllSassess(cc.getTid(), cc.getCid());
                if (tassessesList.size() >= 2 && sassessList.size() >= 2) {
                    LongSummaryStatistics lss1 = tassessesList.stream().collect(Collectors.summarizingLong(Tassess::getQuestion1));
                    double tquestion1 = lss1.getAverage();
                    BigDecimal t1 = new BigDecimal(tquestion1 + "");
                    LongSummaryStatistics lss2 = tassessesList.stream().collect(Collectors.summarizingLong(Tassess::getQuestion2));
                    double tquestion2 = lss2.getAverage();
                    BigDecimal t2 = new BigDecimal(tquestion2 + "");
                    LongSummaryStatistics lss3 = tassessesList.stream().collect(Collectors.summarizingLong(Tassess::getQuestion3));
                    double tquestion3 = lss3.getAverage();
                    BigDecimal t3 = new BigDecimal(tquestion3 + "");
                    LongSummaryStatistics lss4 = tassessesList.stream().collect(Collectors.summarizingLong(Tassess::getQuestion4));
                    double tquestion4 = lss4.getAverage();
                    BigDecimal t4 = new BigDecimal(tquestion4 + "");
                    LongSummaryStatistics lss5 = tassessesList.stream().collect(Collectors.summarizingLong(Tassess::getQuestion5));
                    double tquestion5 = lss5.getAverage();
                    BigDecimal t5 = new BigDecimal(tquestion5 + "");

                    LongSummaryStatistics lss6 = sassessList.stream().collect(Collectors.summarizingLong(Sassess::getQuestion1));
                    double squestion1 = lss6.getAverage();
                    BigDecimal s1 = new BigDecimal(squestion1 + "");
                    LongSummaryStatistics lss7 = sassessList.stream().collect(Collectors.summarizingLong(Sassess::getQuestion2));
                    double squestion2 = lss7.getAverage();
                    BigDecimal s2 = new BigDecimal(squestion2 + "");
                    LongSummaryStatistics lss8 = sassessList.stream().collect(Collectors.summarizingLong(Sassess::getQuestion3));
                    double squestion3 = lss8.getAverage();
                    BigDecimal s3 = new BigDecimal(squestion3 + "");
                    LongSummaryStatistics lss9 = sassessList.stream().collect(Collectors.summarizingLong(Sassess::getQuestion4));
                    double squestion4 = lss9.getAverage();
                    BigDecimal s4 = new BigDecimal(squestion4 + "");
                    LongSummaryStatistics lss10 = sassessList.stream().collect(Collectors.summarizingLong(Sassess::getQuestion5));
                    double squestion5 = lss10.getAverage();
                    BigDecimal s5 = new BigDecimal(squestion5 + "");
                    BigDecimal t = new BigDecimal("0.3");
                    BigDecimal s = new BigDecimal("0.7");
                    double question1 = s1.multiply(s).doubleValue() + t1.multiply(t).doubleValue();
                    double question2 = s2.multiply(s).doubleValue() + t2.multiply(t).doubleValue();
                    double question3 = s3.multiply(s).doubleValue() + t3.multiply(t).doubleValue();
                    double question4 = s4.multiply(s).doubleValue() + t4.multiply(t).doubleValue();
                    double question5 = s5.multiply(s).doubleValue() + t5.multiply(t).doubleValue();
                    Map<String, Object> newmap = new HashMap<String, Object>();
                    newmap.put("cid", cc.getCid());
                    newmap.put("cname", cc.getCname());
                    newmap.put("tid", cc.getTid());
                    if (teacherService.findOneTeacher(cc.getTid()) != null)
                        newmap.put("tname", teacherService.findOneTeacher(cc.getTid()).getTname());
                    newmap.put("credit", cc.getCredit());
                    newmap.put("shape", cc.getShape());

                    if (question1 == 0 && question2 == 0 && question3 == 0 && question4 == 0 && question5 == 0) {
                        newmap.put("zongfen", "暂无评价");
                        newmap.put("question1", "");
                        newmap.put("question2", "");
                        newmap.put("question3", "");
                        newmap.put("question4", "");
                        newmap.put("question5", "");
                    } else {
                        newmap.put("zongfen", (question1 + question2 + question3 + question4 + question5) * 0.2);
                        newmap.put("question1", question1);
                        newmap.put("question2", question2);
                        newmap.put("question3", question3);
                        newmap.put("question4", question4);
                        newmap.put("question5", question5);
                    }
                    list.add(newmap);
                }
                else {
                    Map<String, Object> newmap = new HashMap<String, Object>();
                    newmap.put("cid", cc.getCid());
                    newmap.put("cname", cc.getCname());
                    newmap.put("tid", cc.getTid());
                    if (teacherService.findOneTeacher(cc.getTid()) != null) newmap.put("tname", teacherService.findOneTeacher(cc.getTid()).getTname());
                    newmap.put("credit", cc.getCredit());
                    newmap.put("shape", cc.getShape());
                    newmap.put("zongfen", "暂未评价");
                    newmap.put("question1", "");
                    newmap.put("question2", "");
                    newmap.put("question3", "");
                    newmap.put("question4", "");
                    newmap.put("question5", "");
                    list.add(newmap);
                }


            }
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("total", count);
            map.put("data", list);

            String jsonString = JSON.toJSONString(map);
            resp.getWriter().write(jsonString);


        }
        else{
            int count = courseService.FindAllNum();
            List<Course> boList = courseService.FindAllCourse(index, size, null,null,tid);
            List<Map<String, Object>> list= new ArrayList<Map<String,Object>>();
            for(Course cc:boList) {
                SassessService sassessService=(SassessService)context.getBean("SassessServiceImpl");
                TassessService tassessService=(TassessService)context.getBean("TassessServiceImpl");
                List<Tassess> tassessesList = tassessService.FindAllTassess(cc.getTid(), cc.getCid());
                List<Sassess> sassessList = sassessService.FindAllSassess(cc.getTid(), cc.getCid());
                LongSummaryStatistics lss1 = tassessesList.stream().collect(Collectors.summarizingLong(Tassess::getQuestion1));
                double tquestion1 = lss1.getAverage();
                BigDecimal t1=new BigDecimal(tquestion1+"");
                LongSummaryStatistics lss2 = tassessesList.stream().collect(Collectors.summarizingLong(Tassess::getQuestion2));
                double tquestion2 = lss2.getAverage();
                BigDecimal t2=new BigDecimal(tquestion2+"");
                LongSummaryStatistics lss3 = tassessesList.stream().collect(Collectors.summarizingLong(Tassess::getQuestion3));
                double tquestion3 = lss3.getAverage();
                BigDecimal t3=new BigDecimal(tquestion3+"");
                LongSummaryStatistics lss4 = tassessesList.stream().collect(Collectors.summarizingLong(Tassess::getQuestion4));
                double tquestion4 = lss4.getAverage();
                BigDecimal t4=new BigDecimal(tquestion4+"");
                LongSummaryStatistics lss5 = tassessesList.stream().collect(Collectors.summarizingLong(Tassess::getQuestion5));
                double tquestion5 = lss5.getAverage();
                BigDecimal t5=new BigDecimal(tquestion5+"");

                LongSummaryStatistics lss6 = sassessList.stream().collect(Collectors.summarizingLong(Sassess::getQuestion1));
                double squestion1 = lss6.getAverage();
                BigDecimal s1=new BigDecimal(squestion1+"");
                LongSummaryStatistics lss7 = sassessList.stream().collect(Collectors.summarizingLong(Sassess::getQuestion2));
                double squestion2 = lss7.getAverage();
                BigDecimal s2=new BigDecimal(squestion2+"");
                LongSummaryStatistics lss8 = sassessList.stream().collect(Collectors.summarizingLong(Sassess::getQuestion3));
                double squestion3 = lss8.getAverage();
                BigDecimal s3=new BigDecimal(squestion3+"");
                LongSummaryStatistics lss9 = sassessList.stream().collect(Collectors.summarizingLong(Sassess::getQuestion4));
                double squestion4 = lss9.getAverage();
                BigDecimal s4=new BigDecimal(squestion4+"");
                LongSummaryStatistics lss10 = sassessList.stream().collect(Collectors.summarizingLong(Sassess::getQuestion5));
                double squestion5 = lss10.getAverage();
                BigDecimal s5=new BigDecimal(squestion5+"");
                BigDecimal t=new BigDecimal("0.3");
                BigDecimal s=new BigDecimal("0.7");
                double question1=s1.multiply(s).doubleValue()+t1.multiply(t).doubleValue();
                double question2=s2.multiply(s).doubleValue()+t2.multiply(t).doubleValue();
                double question3=s3.multiply(s).doubleValue()+t3.multiply(t).doubleValue();
                double question4=s4.multiply(s).doubleValue()+t4.multiply(t).doubleValue();
                double question5=s5.multiply(s).doubleValue()+t5.multiply(t).doubleValue();
                Map<String, Object> newmap = new HashMap<String, Object>();
                newmap.put("cid", cc.getCid());
                newmap.put("cname", cc.getCname());
                newmap.put("tid",cc.getTid());
                if(teacherService.findOneTeacher(cc.getTid())!=null)
                    newmap.put("tname",teacherService.findOneTeacher(cc.getTid()).getTname() );

                newmap.put("credit", cc.getCredit());
                newmap.put("shape", cc.getShape());

                if(question1==0 && question2==0 && question3==0 && question4==0 && question5==0) {
                    newmap.put("zongfen", "暂无评价");
                    newmap.put("question1", "");
                    newmap.put("question2", "");
                    newmap.put("question3", "");
                    newmap.put("question4", "");
                    newmap.put("question5", "");
                }
                else {
                    newmap.put("zongfen",(question1+question2+question3+question4+question5)*0.2);
                    newmap.put("question1", question1);
                    newmap.put("question2", question2);
                    newmap.put("question3", question3);
                    newmap.put("question4", question4);
                    newmap.put("question5", question5);
                }
                list.add(newmap);
            }
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("total", count);
            map.put("data", list);

            String jsonString = JSON.toJSONString(map);
            resp.getWriter().write(jsonString);

        }
    }
}
