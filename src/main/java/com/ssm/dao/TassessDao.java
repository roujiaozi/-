package com.ssm.dao;

import com.ssm.entity.Sassess;
import com.ssm.entity.Tassess;

import java.util.List;
import java.util.Map;

public interface TassessDao {
    //增 删 改  分页  全部
    public void TassessAdd(Tassess tassess);
    //根据学生编号，课程编号，教师编号 删除选课记录
    public void TassessDelete(Map<String, Object> map);
    public List<Tassess> FindAllTassess1(Map<String,Object> map);
    public List<Tassess> FindAllTassess2(Map<String,Object> map);
    public List<Tassess> FindAllTassess3(Map<String,Object> map);
    public List<Tassess> FindAllTassess4(Map<String,Object> map);
    public List<Tassess> FindAllTassess5(Map<String,Object> map);
    public List<Tassess> FindAllTassess6(Map<String,Object> map);
    public List<Tassess> FindAllTassess7(Map<String,Object> map);
    public List<Tassess> FindAllTassess8(Map<String,Object> map);
    public List<Tassess> FindAllTassess(Map<String,Object> map);

    public int FindAllTassessNum1(Map<String,Object> map);
    public int FindAllTassessNum2(Map<String,Object> map);
    public int FindAllTassessNum3(Map<String,Object> map);
    public int FindAllTassessNum4(Map<String,Object> map);
    public int FindAllTassessNum5(Map<String,Object> map);
    public int FindAllTassessNum6(Map<String,Object> map);
    public int FindAllTassessNum7(Map<String,Object> map);
    public int FindAllTassessNum8(Map<String,Object> map);
    public int FindAllTassessNum();
    public Tassess FindOneTassess(Map<String, Object> map);
}
