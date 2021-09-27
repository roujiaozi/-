package com.ssm.service;

import com.ssm.entity.Course;
import com.ssm.entity.Student;

import java.util.List;

public interface CourseService {
    public void courseAdd(Course course);
    public void courseDelete(String cid);
    public void courseUpdate(Course course);
    public int FindAllNum();
    public Course FindOneCourse(String cid);
    public List<Course>  FindAllCourse(int pageIndex, int pageSize, String cname, String type);
    public List<Course>  FindAllCourse(int pageIndex, int pageSize, String cname, String type,String tid);
    public int  FindAllCourseNum(int pageIndex, int pageSize, String cname, String type);
    public int FindAllCourseNum(int pageIndex, int pageSize, String cname, String type,String tid);
    public List<Course>  FindAllCourse();
    public List<Course>  FindAllTidCourse(String tid);
    public String getCourseId();
    public List<Course> ExistCourse(String tid);
}
