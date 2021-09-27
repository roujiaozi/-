package com.ssm.service;

import com.ssm.dao.TeacherDao;
import com.ssm.entity.Teacher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("TeacherServiceImpl")
public class TeacherServiceImpl implements TeacherService {
    @Resource(name="TeacherDaoImpl")
    private TeacherDao teacherDao;
    @Override
    public void addTeacher(Teacher teacher) {
        teacherDao.addTeacher(teacher);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teacherDao.updateTeacher(teacher);
    }

    @Override
    public void deleteTeacher(String tid) {
        teacherDao.deleteTeacher(tid);
    }

    @Override
    public boolean loginTeacher(String tid, String password) {

        return teacherDao.loginTeacher(tid,password);
    }

    @Override
    public List<Teacher> findAllFenYeTeacher(int pageIndex, int pageSize, String tname) {
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("zongshu",pageIndex*pageSize);
        map.put("pageSize",pageSize);
        map.put("tname",tname);
        if(tname!=null) {
            return teacherDao.findAllFenYeTeacher1(map);
        }else {
            return teacherDao.findAllFenYeTeacher2(map);
        }

    }

    @Override
    public int findAllFenYeTeacherNum(int pageIndex, int pageSize, String tname) {
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("zongshu",pageIndex*pageSize);
        map.put("pageSize",pageSize);
        map.put("tname",tname);
        if(tname!=null) {
            return teacherDao.findAllFenYeTeacherNum1(map);
        }else {
            return teacherDao.findAllFenYeTeacherNum2(map);
        }

    }

    @Override
    public String getTid() {
        String tid=teacherDao.getTid();
        if (tid==null){
            return "teacher202000000001";
        }
        return tid;
    }

    @Override
    public Teacher findOneTeacher(String tid) {
        return teacherDao.findOneTeacher(tid);
    }

    @Override
    public int findTeacherAllNum() {
        return teacherDao.findTeacherAllNum();
    }

    @Override
    public List<Teacher> findAllTeacher() {
        return teacherDao.findAllTeacher();
    }
}
