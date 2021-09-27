package com.ssm.service;

import com.ssm.entity.Choose;

import java.util.List;
import java.util.Map;

public interface ChooseService {
    public void chooseAdd(Choose choose);
    //根据学生编号，课程编号，教师编号 删除选课记录
    public void chooseDelete(String sid,String cid ,String tid);
    public List<Choose> FindAllChoose(int pageIndex, int pageSize, String tname, String cname);
    public List<Choose> FindAllChoose(int pageIndex, int pageSize, String tname, String cname,String sid);
    public int FindAllChooseNum(int pageIndex, int pageSize, String tname, String cname);
    public int FindAllChooseNum(int pageIndex, int pageSize, String tname, String cname,String sid);
    public int FindAllNum();
    public Choose FindOneChoose(String sid, String cid, String tid);
    public List<Choose> ExistChoose(String sid);
    //此课程是否存在选课记录
    public List<Choose> ExistCid(String cid);

}
