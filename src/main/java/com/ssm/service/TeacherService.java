package com.ssm.service;

import com.ssm.entity.Teacher;

import java.util.List;
import java.util.Map;

public interface TeacherService {
     public void addTeacher(Teacher teacher);
     public void updateTeacher(Teacher teacher);
     public void deleteTeacher(String tid);
     public boolean loginTeacher(String tid,String password);
     public List<Teacher> findAllFenYeTeacher (int pageIndex, int pageSize, String tname);
     public int findAllFenYeTeacherNum (int pageIndex, int pageSize, String tname);
     public String getTid();
     public Teacher findOneTeacher(String tid);
     public int findTeacherAllNum();
     public List<Teacher> findAllTeacher();
}
