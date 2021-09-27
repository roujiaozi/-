package com.ssm.service;

import com.ssm.dao.ChooseDao;
import com.ssm.dao.CourseDao;
import com.ssm.entity.Choose;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service("ChooseServiceImpl")
public class ChooseServiceImpl implements ChooseService {
    @Resource(name="ChooseDaoImpl")
    private ChooseDao chooseDao;
    @Override
    public void chooseAdd(Choose choose) {
        chooseDao.chooseAdd(choose);
    }

    @Override
    public void chooseDelete(String sid, String cid, String tid) {
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("sid",sid);
        map.put("cid",cid);
        map.put("tid",tid);
        chooseDao.chooseDelete(map);
    }

    @Override
    public List<Choose> FindAllChoose(int pageIndex, int pageSize, String tname, String cname) {
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("zongshu",pageIndex*pageSize);
        map.put("pageSize",pageSize);
        map.put("cname",cname);
        map.put("tname",tname);
        if(cname!=null && tname!=null) {
            return chooseDao.FindAllChoose1(map);
        }
        else if (cname==null && tname!=null )
        {
            return chooseDao.FindAllChoose2(map);
        }
        else if (cname!=null && tname==null)
        {
            return chooseDao.FindAllChoose3(map);
        }
        else {
            return chooseDao.FindAllChoose4(map);
        }
    }

    @Override
    public List<Choose> FindAllChoose(int pageIndex, int pageSize, String tname, String cname, String sid) {
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("zongshu",pageIndex*pageSize);
        map.put("pageSize",pageSize);
        map.put("cname",cname);
        map.put("tname",tname);
        map.put("sid",sid);

        if(cname!=null && tname!=null) {
            return chooseDao.FindAllChoose5(map);
        }
        else if (cname==null && tname!=null )
        {
            return chooseDao.FindAllChoose6(map);
        }
        else if (cname!=null && tname==null)
        {
            return chooseDao.FindAllChoose7(map);
        }
        else {
            return chooseDao.FindAllChoose8(map);
        }
    }

    @Override
    public int FindAllChooseNum(int pageIndex, int pageSize, String tname, String cname) {
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("zongshu",pageIndex*pageSize);
        map.put("pageSize",pageSize);
        map.put("cname",cname);
        map.put("tname",tname);
        if(cname!=null && tname!=null) {
            return chooseDao.FindAllChooseNum1(map);
        }
        else if (cname==null && tname!=null )
        {
            return chooseDao.FindAllChooseNum2(map);
        }
        else if (cname!=null && tname==null)
        {
            return chooseDao.FindAllChooseNum3(map);
        }
        else {
            return chooseDao.FindAllChooseNum4(map);
        }
    }

    @Override
    public int FindAllChooseNum(int pageIndex, int pageSize, String tname, String cname, String sid) {
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("zongshu",pageIndex*pageSize);
        map.put("pageSize",pageSize);
        map.put("cname",cname);
        map.put("tname",tname);
        map.put("sid",sid);

        if(cname!=null && tname!=null) {
            return chooseDao.FindAllChooseNum5(map);
        }
        else if (cname==null && tname!=null )
        {
            return chooseDao.FindAllChooseNum6(map);
        }
        else if (cname!=null && tname==null)
        {
            return chooseDao.FindAllChooseNum7(map);
        }
        else {
            return chooseDao.FindAllChooseNum8(map);
        }
    }


    @Override
    public int FindAllNum() {
        return chooseDao.FindAllChooseNum();
    }

    @Override
    public Choose FindOneChoose(String sid, String cid, String tid) {
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("sid",sid);
        map.put("cid",cid);
        map.put("tid",tid);
        return chooseDao.FindOneChoose(map);
    }

    @Override
    public List<Choose> ExistChoose(String sid) {
        return chooseDao.ExistChoose(sid);
    }

    @Override
    public List<Choose> ExistCid(String cid) {
        return chooseDao.ExistCid(cid);
    }
}
