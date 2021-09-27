package com.ssm.dao;

import com.ssm.entity.Choose;
import com.ssm.entity.Course;
import com.ssm.entity.Sassess;

import java.util.List;
import java.util.Map;

public interface SassessDao {
    //增 删 改  分页  全部
    public void SassessAdd(Sassess sassess);
    //根据学生编号，课程编号，教师编号 删除选课记录
    public void SassessDelete(Map<String, Object> map);
    public List<Sassess> FindAllSassess1(Map<String,Object> map);
    public List<Sassess> FindAllSassess2(Map<String,Object> map);
    public List<Sassess> FindAllSassess3(Map<String,Object> map);
    public List<Sassess> FindAllSassess4(Map<String,Object> map);
    public List<Sassess> FindAllSassess5(Map<String,Object> map);
    public List<Sassess> FindAllSassess6(Map<String,Object> map);
    public List<Sassess> FindAllSassess7(Map<String,Object> map);
    public List<Sassess> FindAllSassess8(Map<String,Object> map);
    public List<Sassess> FindAllSassess(Map<String,Object> map);
    public int FindAllSassessNum1(Map<String,Object> map);
    public int FindAllSassessNum2(Map<String,Object> map);
    public int FindAllSassessNum3(Map<String,Object> map);
    public int FindAllSassessNum4(Map<String,Object> map);
    public int FindAllSassessNum5(Map<String,Object> map);
    public int FindAllSassessNum6(Map<String,Object> map);
    public int FindAllSassessNum7(Map<String,Object> map);
    public int FindAllSassessNum8(Map<String,Object> map);
    public int FindAllSassessNum();
    public Sassess FindOneSassess(Map<String, Object> map);
}
