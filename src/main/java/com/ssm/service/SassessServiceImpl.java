package com.ssm.service;

import com.ssm.dao.ChooseDao;
import com.ssm.dao.SassessDao;
import com.ssm.entity.Sassess;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("SassessServiceImpl")
public class SassessServiceImpl implements SassessService {
    @Resource(name="SassessDaoImpl")
    private SassessDao sassessDao;
    @Override
    public void SassessAdd(Sassess sassess) {
        sassessDao.SassessAdd(sassess);
    }

    @Override
    public void SassessDelete(String sid, String cid, String tid) {
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("sid",sid);
        map.put("cid",cid);
        map.put("tid",tid);
        sassessDao.SassessDelete(map);
    }

    @Override
    public List<Sassess> FindAllSassess(int pageIndex, int pageSize, String tname, String cname) {
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("zongshu",pageIndex*pageSize);
        map.put("pageSize",pageSize);
        map.put("cname",cname);
        map.put("tname",tname);
        if(cname!=null && tname!=null) {
            return sassessDao.FindAllSassess1(map);
        }
        else if (cname==null && tname!=null )
        {
            return sassessDao.FindAllSassess2(map);
        }
        else if (cname!=null && tname==null)
        {
            return sassessDao.FindAllSassess3(map);
        }
        else {
            return sassessDao.FindAllSassess4(map);
        }
    }

    @Override
    public List<Sassess> FindAllSassess(int pageIndex, int pageSize, String tname, String cname, String sid) {
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("zongshu",pageIndex*pageSize);
        map.put("pageSize",pageSize);
        map.put("cname",cname);
        map.put("tname",tname);
        map.put("sid",sid);
        if(cname!=null && tname!=null) {
            return sassessDao.FindAllSassess5(map);
        }
        else if (cname==null && tname!=null )
        {
            return sassessDao.FindAllSassess6(map);
        }
        else if (cname!=null && tname==null)
        {
            return sassessDao.FindAllSassess7(map);
        }
        else {
            return sassessDao.FindAllSassess8(map);
        }
    }

    @Override
    public int FindAllSassessNum(int pageIndex, int pageSize, String tname, String cname) {
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("zongshu",pageIndex*pageSize);
        map.put("pageSize",pageSize);
        map.put("cname",cname);
        map.put("tname",tname);
        if(cname!=null && tname!=null) {
            return sassessDao.FindAllSassessNum1(map);
        }
        else if (cname==null && tname!=null )
        {
            return sassessDao.FindAllSassessNum2(map);
        }
        else if (cname!=null && tname==null)
        {
            return sassessDao.FindAllSassessNum3(map);
        }
        else {
            return sassessDao.FindAllSassessNum4(map);
        }
    }

    @Override
    public int FindAllSassessNum(int pageIndex, int pageSize, String tname, String cname, String sid) {
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("zongshu",pageIndex*pageSize);
        map.put("pageSize",pageSize);
        map.put("cname",cname);
        map.put("tname",tname);
        map.put("sid",sid);
        if(cname!=null && tname!=null) {
            return sassessDao.FindAllSassessNum5(map);
        }
        else if (cname==null && tname!=null )
        {
            return sassessDao.FindAllSassessNum6(map);
        }
        else if (cname!=null && tname==null)
        {
            return sassessDao.FindAllSassessNum7(map);
        }
        else {
            return sassessDao.FindAllSassessNum8(map);
        }
    }

    @Override
    public List<Sassess> FindAllSassess(String tid,String cid) {
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("tid",tid);
        map.put("cid",cid);
        return sassessDao.FindAllSassess(map);
    }

    @Override
    public int FindAllNum() {
        return sassessDao.FindAllSassessNum();
    }

    @Override
    public Sassess FindOneSassess(String sid, String cid, String tid) {
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("sid",sid);
        map.put("cid",cid);
        map.put("tid",tid);
        return sassessDao.FindOneSassess(map);
    }
}
