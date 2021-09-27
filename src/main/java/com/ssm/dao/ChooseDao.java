package com.ssm.dao;

import com.ssm.entity.Choose;
import com.ssm.entity.Course;

import java.util.List;
import java.util.Map;

public interface ChooseDao {
    public void chooseAdd(Choose choose);
    //根据学生编号，课程编号，教师编号 删除选课记录
    public void chooseDelete(Map<String, Object> map);
    public List<Choose> FindAllChoose1(Map<String,Object> map);
    public List<Choose> FindAllChoose2(Map<String,Object> map);
    public List<Choose> FindAllChoose3(Map<String,Object> map);
    public List<Choose> FindAllChoose4(Map<String,Object> map);
    public List<Choose> FindAllChoose5(Map<String,Object> map);
    public List<Choose> FindAllChoose6(Map<String,Object> map);
    public List<Choose> FindAllChoose7(Map<String,Object> map);
    public List<Choose> FindAllChoose8(Map<String,Object> map);
    public int FindAllChooseNum1(Map<String,Object> map);
    public int FindAllChooseNum2(Map<String,Object> map);
    public int FindAllChooseNum3(Map<String,Object> map);
    public int FindAllChooseNum4(Map<String,Object> map);
    public int FindAllChooseNum5(Map<String,Object> map);
    public int FindAllChooseNum6(Map<String,Object> map);
    public int FindAllChooseNum7(Map<String,Object> map);
    public int FindAllChooseNum8(Map<String,Object> map);
    public int FindAllChooseNum();
    public Choose FindOneChoose(Map<String, Object> map);
    //是否存在选课记录
    public List<Choose> ExistChoose(String sid);
    public List<Choose> ExistCid(String cid);
}
