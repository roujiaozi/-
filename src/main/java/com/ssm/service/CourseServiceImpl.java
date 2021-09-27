package com.ssm.service;

import com.ssm.dao.CourseDao;
import com.ssm.dao.StudentDao;
import com.ssm.entity.Course;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("CourseServiceImpl")
public class CourseServiceImpl implements CourseService{
    @Resource(name="CourseDaoImpl")
    private CourseDao courseDao;
    @Override
    public void courseAdd(Course course) {
        courseDao.courseAdd(course);
    }

    @Override
    public void courseDelete(String cid) {
        courseDao.courseDelete(cid);
    }

    @Override
    public void courseUpdate(Course course) {
        courseDao.courseUpdate(course);
    }

    @Override
    public int FindAllNum() {
        return courseDao.FindAllNum();
    }

    @Override
    public Course FindOneCourse(String cid) {
        return courseDao.FindOneCourse(cid);
    }

    @Override
    public List<Course> FindAllCourse(int pageIndex, int pageSize, String cname, String type) {
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("zongshu",pageIndex*pageSize);
        map.put("pageSize",pageSize);
        map.put("cname",cname);
        map.put("type",type);
        if(cname!=null && type!=null) {
            return courseDao.FindAllCourse1(map);
        }
        else if (cname==null && type!=null )
        {
            return courseDao.FindAllCourse2(map);
        }
        else if (cname!=null && type==null)
        {
             return courseDao.FindAllCourse3(map);
        }
        else {
            return courseDao.FindAllCourse4(map);
        }
    }

    @Override
    public List<Course> FindAllCourse(int pageIndex, int pageSize, String cname, String type, String tid) {
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("zongshu",pageIndex*pageSize);
        map.put("pageSize",pageSize);
        map.put("cname",cname);
        map.put("type",type);
        map.put("tid",tid);
        if(cname!=null && type!=null) {
            return courseDao.FindAllCourse5(map);
        }
        else if (cname==null && type!=null )
        {
            return courseDao.FindAllCourse6(map);
        }
        else if (cname!=null && type==null)
        {
            return courseDao.FindAllCourse7(map);
        }
        else {
            return courseDao.FindAllCourse8(map);
        }
    }

    @Override
    public int FindAllCourseNum(int pageIndex, int pageSize, String cname, String type) {
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("zongshu",pageIndex*pageSize);
        map.put("pageSize",pageSize);
        map.put("cname",cname);
        map.put("type",type);
        if(cname!=null && type!=null) {
            return courseDao.FindAllCourseNum1(map);
        }
        else if (cname==null && type!=null )
        {
            return courseDao.FindAllCourseNum2(map);
        }
        else if (cname!=null && type==null)
        {
            return courseDao.FindAllCourseNum3(map);
        }
        else {
            return courseDao.FindAllCourseNum4(map);
        }
    }

    @Override
    public int FindAllCourseNum(int pageIndex, int pageSize, String cname, String type, String tid) {
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("zongshu",pageIndex*pageSize);
        map.put("pageSize",pageSize);
        map.put("cname",cname);
        map.put("type",type);
        map.put("tid",tid);
        if(cname!=null && type!=null) {
            return courseDao.FindAllCourseNum5(map);
        }
        else if (cname==null && type!=null )
        {
            return courseDao.FindAllCourseNum6(map);
        }
        else if (cname!=null && type==null)
        {
            return courseDao.FindAllCourseNum7(map);
        }
        else {
            return courseDao.FindAllCourseNum8(map);
        }
    }

    @Override
    public List<Course> FindAllCourse() {
        return courseDao.FindAllCourse();
    }

    @Override
    public List<Course> FindAllTidCourse(String tid) {
        return courseDao.FindAllTidCourse(tid);
    }

    @Override
    public String getCourseId() {
        String cid=courseDao.getCourseId();
        if (cid==null){
            return "kecheng202000000001";
        }
        return cid;
    }

    @Override
    public List<Course> ExistCourse(String tid) {
        return courseDao.ExistCourse(tid);
    }
}
