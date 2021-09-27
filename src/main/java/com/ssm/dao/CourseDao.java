package com.ssm.dao;

import com.ssm.entity.Course;

import java.util.List;
import java.util.Map;

public interface CourseDao {
    public void courseAdd(Course course);
    public void courseDelete(String cid);
    public void courseUpdate(Course course);
    public List<Course> FindAllCourse1(Map<String,Object> map);
    public List<Course> FindAllCourse2(Map<String,Object> map);
    public List<Course> FindAllCourse3(Map<String,Object> map);
    public List<Course> FindAllCourse4(Map<String,Object> map);
    public List<Course> FindAllCourse5(Map<String,Object> map);
    public List<Course> FindAllCourse6(Map<String,Object> map);
    public List<Course> FindAllCourse7(Map<String,Object> map);
    public List<Course> FindAllCourse8(Map<String,Object> map);
    public int FindAllCourseNum1(Map<String,Object> map);
    public int FindAllCourseNum2(Map<String,Object> map);
    public int FindAllCourseNum3(Map<String,Object> map);
    public int FindAllCourseNum4(Map<String,Object> map);
    public int FindAllCourseNum5(Map<String,Object> map);
    public int FindAllCourseNum6(Map<String,Object> map);
    public int FindAllCourseNum7(Map<String,Object> map);
    public int FindAllCourseNum8(Map<String,Object> map);
    public List<Course> FindAllCourse();
    public List<Course> FindAllTidCourse(String tid);
    public int FindAllNum();
    public Course FindOneCourse(String cid);
    public  String getCourseId();
    public List<Course> ExistCourse(String tid);
}
