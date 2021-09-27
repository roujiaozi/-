package com.ssm.service;

import com.ssm.entity.Sassess;
import com.ssm.entity.Tassess;

import java.util.List;

public interface TassessService {
    public void TassessAdd(Tassess tassess);
    //根据学生编号，课程编号，教师编号 删除选课记录
    public void TassessDelete(String tid,String cid ,String tid1);
    public List<Tassess> FindAllTassess(int pageIndex, int pageSize, String tname, String cname);
    public List<Tassess> FindAllTassess(int pageIndex, int pageSize, String tname, String cname,String tid1);

    public int FindAllTassessNum(int pageIndex, int pageSize, String tname, String cname);
    public int FindAllTassessNum(int pageIndex, int pageSize, String tname, String cname,String tid1);
    public int FindAllNum();
    public Tassess FindOneTassess(String tid, String cid, String tid1);
    public List<Tassess> FindAllTassess(String tid,String cid);
}
