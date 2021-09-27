package com.ssm.dao;

import com.ssm.entity.Student;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    //学生数据条数
    public int findAllNum();
    //全部学生信息
    public List<Student> findAllStudent(Map<String,Object> map);
    //添加学生信息
    public void addStudent(Student student);
    //修改信息
    public void updateStudent(Student student);
    //查看单条记录
    public  Student findOneStudent(String sid);
    //删除学生信息
    public void deleteStudent(String id);
    //条件分页查询
    public List<Student> findAllFenYeStudent1(Map<String,Object> map);
    public List<Student> findAllFenYeStudent2(Map<String,Object> map);
    public List<Student> findAllFenYeStudent3(Map<String,Object> map);
    public List<Student> findAllFenYeStudent4(Map<String,Object> map);
    public int findAllFenYeStudentNum1(Map<String,Object> map);
    public int findAllFenYeStudentNum2(Map<String,Object> map);
    public int findAllFenYeStudentNum3(Map<String,Object> map);
    public int findAllFenYeStudentNum4(Map<String,Object> map);
    //学号
    public String getSid();
    public List<Student> findAllStudentList();
}
