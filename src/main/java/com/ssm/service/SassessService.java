package com.ssm.service;

import com.ssm.entity.Choose;
import com.ssm.entity.Sassess;

import java.util.List;

public interface SassessService {
    public void SassessAdd(Sassess sassess);
    //根据学生编号，课程编号，教师编号 删除选课记录
    public void SassessDelete(String sid,String cid ,String tid);
    public List<Sassess> FindAllSassess(int pageIndex, int pageSize, String tname, String cname);
    public List<Sassess> FindAllSassess(int pageIndex, int pageSize, String tname, String cname,String sid);
    public int FindAllSassessNum(int pageIndex, int pageSize, String tname, String cname);
    public int FindAllSassessNum(int pageIndex, int pageSize, String tname, String cname,String sid);
    public List<Sassess> FindAllSassess(String tid,String cid);

    public int FindAllNum();
    public Sassess FindOneSassess(String sid, String cid, String tid);
}
