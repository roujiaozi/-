package com.ssm.dao;

import com.ssm.entity.Teacher;

import java.util.List;
import java.util.Map;

public interface TeacherDao {
    //添加
    public void  addTeacher(Teacher teacher);
    //删除
    public void deleteTeacher(String tid);
    //修改
    public void  updateTeacher(Teacher teacher);
    //登录
    public boolean loginTeacher(String tid,String password);
    //查找
    public List<Teacher> findAllFenYeTeacher1 (Map<String,Object> map);
    public List<Teacher> findAllFenYeTeacher2 (Map<String,Object> map);
    public int findAllFenYeTeacherNum1 (Map<String,Object> map);
    public int findAllFenYeTeacherNum2 (Map<String,Object> map);
    //老师编号
    public String getTid();
    //查找单个老师
    public Teacher findOneTeacher(String tid);
    //条数
    public int findTeacherAllNum();
    //查询所有老师信息
    public List<Teacher> findAllTeacher();
}
