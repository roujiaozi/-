package com.ssm.service;

import com.ssm.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {

    //学生数据条数
    public int findAllNum();

    //全部学生信息
    public List<Student> findAllStudent(int pageIndex, int pageSize);

    //添加学生信息
    public void addStudent(Student student);

    //修改信息
    public void updateStudent(Student student);

    //查看单条记录
    public Student findOneStudent(String sid);

    //删除学生记录
    public void deleteStudent(String sid);
    //分页查询
    public List<Student>  findAllFenYeStudent(int pageIndex, int pageSize, String sname, int type);
    public int  findAllFenYeStudentNum(int pageIndex, int pageSize, String sname, int type);
    //获取学号
    public String getSid();
    public List<Student>  findAllStudentList();
}
