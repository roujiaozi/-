package com.ssm.service;

import com.ssm.dao.SassessDao;
import com.ssm.dao.TassessDao;
import com.ssm.entity.Sassess;
import com.ssm.entity.Tassess;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("TassessServiceImpl")
public class TassessServiceImpl implements TassessService{
    @Resource(name="TassessDaoImpl")
    private TassessDao tassessDao;
    @Override
    public void TassessAdd(Tassess tassess) {
        tassessDao.TassessAdd(tassess);
    }

    @Override
    public void TassessDelete(String tid, String cid, String tid1) {
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("tid",tid);
        map.put("cid",cid);
        map.put("tid1",tid1);
        tassessDao.TassessDelete(map);
    }

    @Override
    public List<Tassess> FindAllTassess(int pageIndex, int pageSize, String tname, String cname) {
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("zongshu",pageIndex*pageSize);
        map.put("pageSize",pageSize);
        map.put("cname",cname);
        map.put("tname",tname);
        if(cname!=null && tname!=null) {
            return tassessDao.FindAllTassess1(map);
        }
        else if (cname==null && tname!=null )
        {
            return tassessDao.FindAllTassess2(map);
        }
        else if (cname!=null && tname==null)
        {
            return tassessDao.FindAllTassess3(map);
        }
        else {
            return tassessDao.FindAllTassess4(map);
        }
    }

    @Override
    public List<Tassess> FindAllTassess(int pageIndex, int pageSize, String tname, String cname, String tid1) {
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("zongshu",pageIndex*pageSize);
        map.put("pageSize",pageSize);
        map.put("cname",cname);
        map.put("tname",tname);
        map.put("tid1",tid1);
        if(cname!=null && tname!=null) {
            return tassessDao.FindAllTassess5(map);
        }
        else if (cname==null && tname!=null )
        {
            return tassessDao.FindAllTassess6(map);
        }
        else if (cname!=null && tname==null)
        {
            return tassessDao.FindAllTassess7(map);
        }
        else {
            return tassessDao.FindAllTassess8(map);
        }
    }

    @Override
    public int FindAllTassessNum(int pageIndex, int pageSize, String tname, String cname) {
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("zongshu",pageIndex*pageSize);
        map.put("pageSize",pageSize);
        map.put("cname",cname);
        map.put("tname",tname);
        if(cname!=null && tname!=null) {
            return tassessDao.FindAllTassessNum1(map);
        }
        else if (cname==null && tname!=null )
        {
            return tassessDao.FindAllTassessNum2(map);
        }
        else if (cname!=null && tname==null)
        {
            return tassessDao.FindAllTassessNum3(map);
        }
        else {
            return tassessDao.FindAllTassessNum4(map);
        }
    }

    @Override
    public int FindAllTassessNum(int pageIndex, int pageSize, String tname, String cname, String tid1) {
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("zongshu",pageIndex*pageSize);
        map.put("pageSize",pageSize);
        map.put("cname",cname);
        map.put("tname",tname);
        map.put("tid1",tid1);
        if(cname!=null && tname!=null) {
            return tassessDao.FindAllTassessNum5(map);
        }
        else if (cname==null && tname!=null )
        {
            return tassessDao.FindAllTassessNum6(map);
        }
        else if (cname!=null && tname==null)
        {
            return tassessDao.FindAllTassessNum7(map);
        }
        else {
            return tassessDao.FindAllTassessNum8(map);
        }
    }

    @Override
    public int FindAllNum() {
        return tassessDao.FindAllTassessNum();
    }

    @Override
    public Tassess FindOneTassess(String tid, String cid, String tid1) {

        Map<String,Object> map= new HashMap<String,Object>();
        map.put("tid1",tid1);
        map.put("cid",cid);
        map.put("tid",tid);
        return tassessDao.FindOneTassess(map);
    }

    @Override
    public List<Tassess> FindAllTassess(String tid,String cid) {
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("tid",tid);
        map.put("cid",cid);
        return tassessDao.FindAllTassess(map);
    }
}
