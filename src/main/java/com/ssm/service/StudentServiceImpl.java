package com.ssm.service;

import com.ssm.dao.StudentDao;
import com.ssm.entity.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sun.tools.doclint.Entity.and;

@Service("StudentServiceImpl")
public class StudentServiceImpl implements StudentService {
    @Resource(name="StudentDaoImpl")
    private StudentDao stuDao;
    @Override
    public int findAllNum() {
        return stuDao.findAllNum();
    }

    @Override
    public List<Student> findAllStudent(int pageIndex, int pageSize) {
        Map<String,Object> map= new  HashMap<String,Object>();
        map.put("zongshu",pageIndex*pageSize);
        map.put("pageSize",pageSize);
        return stuDao.findAllStudent(map);
    }

    @Override
    public void addStudent(Student student) {
    stuDao.addStudent(student);
    }

    @Override
    public void updateStudent(Student student) {
    stuDao.updateStudent(student);
    }

    @Override
    public Student findOneStudent(String sid) {
        return stuDao.findOneStudent(sid);
    }


    @Override
    public void deleteStudent(String sid) {
        stuDao.deleteStudent(sid);
    }
    public List<Student>  findAllFenYeStudent(int pageIndex, int pageSize, String sname, int type){
        Map<String,Object> map= new  HashMap<String,Object>();
        map.put("zongshu",pageIndex*pageSize);
        map.put("pageSize",pageSize);
        map.put("sname",sname);
        map.put("type",type);
        if(sname!=null && type!=0) {
            return stuDao.findAllFenYeStudent1(map);
        }
        else if (sname==null && type!=0 )
        {
            return stuDao.findAllFenYeStudent2(map);
        }
        else if (sname!=null && type==0)
        {
            return stuDao.findAllFenYeStudent3(map);
        }
        else {
            return stuDao.findAllFenYeStudent4(map);
        }
    }

    @Override
    public int findAllFenYeStudentNum(int pageIndex, int pageSize, String sname, int type) {
        Map<String,Object> map= new  HashMap<String,Object>();
        map.put("zongshu",pageIndex*pageSize);
        map.put("pageSize",pageSize);
        map.put("sname",sname);
        map.put("type",type);
        if(sname!=null && type!=0) {
            return stuDao.findAllFenYeStudentNum1(map);
        }
        else if (sname==null && type!=0 )
        {
            return stuDao.findAllFenYeStudentNum2(map);
        }
        else if (sname!=null && type==0)
        {
            return stuDao.findAllFenYeStudentNum3(map);
        }
        else {
            return stuDao.findAllFenYeStudentNum4(map);
        }
    }

    @Override
    public String getSid() {
        String sid=stuDao.getSid();
        if (sid==null){
            return "tongda202000000001";
        }
        return sid;
    }

    @Override
    public List<Student> findAllStudentList() {
        return stuDao.findAllStudentList();
    }
}
