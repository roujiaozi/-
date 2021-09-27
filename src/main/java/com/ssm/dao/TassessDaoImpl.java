package com.ssm.dao;

import com.ssm.entity.Sassess;
import com.ssm.entity.Tassess;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Repository("TassessDaoImpl")
public class TassessDaoImpl implements TassessDao {
    @Resource(name="sqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;
    @Override
    public void TassessAdd(Tassess tassess) {
        SqlSession session = this.sqlSessionFactory.openSession();
        int a=session.insert("TassessAdd",tassess);
        session.commit();
        session.close();
    }

    @Override
    public void TassessDelete(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        int a=session.delete("TassessDelete",map);
        session.commit();
        session.close();
    }

    @Override
    public List<Tassess> FindAllTassess1(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        List<Tassess> list =session.selectList("FindAllTassess1",map);
        session.close();
        return list;
    }

    @Override
    public List<Tassess> FindAllTassess2(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        List<Tassess> list =session.selectList("FindAllTassess2",map);
        session.close();
        return list;
    }

    @Override
    public List<Tassess> FindAllTassess3(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        List<Tassess> list =session.selectList("FindAllTassess3",map);
        session.close();
        return list;
    }

    @Override
    public List<Tassess> FindAllTassess4(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        List<Tassess> list =session.selectList("FindAllTassess4",map);
        session.close();
        return list;
    }
    @Override
    public List<Tassess> FindAllTassess5(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        List<Tassess> list =session.selectList("FindAllTassess5",map);
        session.close();
        return list;
    }

    @Override
    public List<Tassess> FindAllTassess6(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        List<Tassess> list =session.selectList("FindAllTassess6",map);
        session.close();
        return list;
    }

    @Override
    public List<Tassess> FindAllTassess7(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        List<Tassess> list =session.selectList("FindAllTassess7",map);
        session.close();
        return list;
    }

    @Override
    public List<Tassess> FindAllTassess8(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        List<Tassess> list =session.selectList("FindAllTassess8",map);
        session.close();
        return list;
    }

    @Override
    public List<Tassess> FindAllTassess(Map<String,Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        List<Tassess> list =session.selectList("FindAllTassess",map);
        session.close();
        return list;
    }

    @Override
    public int FindAllTassessNum1(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        int aa =session.selectOne("FindAllTassessNum1",map);
        session.close();
        return aa;
    }

    @Override
    public int FindAllTassessNum2(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        int aa =session.selectOne("FindAllTassessNum2",map);
        session.close();
        return aa;
    }

    @Override
    public int FindAllTassessNum3(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        int aa =session.selectOne("FindAllTassessNum3",map);
        session.close();
        return aa;
    }

    @Override
    public int FindAllTassessNum4(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        int aa =session.selectOne("FindAllTassessNum4",map);
        session.close();
        return aa;
    }

    @Override
    public int FindAllTassessNum5(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        int aa =session.selectOne("FindAllTassessNum5",map);
        session.close();
        return aa;
    }

    @Override
    public int FindAllTassessNum6(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        int aa =session.selectOne("FindAllTassessNum6",map);
        session.close();
        return aa;
    }

    @Override
    public int FindAllTassessNum7(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        int aa =session.selectOne("FindAllTassessNum7",map);
        session.close();
        return aa;
    }

    @Override
    public int FindAllTassessNum8(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        int aa =session.selectOne("FindAllTassessNum8",map);
        session.close();
        return aa;
    }

    @Override
    public int FindAllTassessNum() {
        SqlSession session = this.sqlSessionFactory.openSession();
        int a=session.selectOne("FindAllTassessNum");
        session.close();
        return a;
    }

    @Override
    public Tassess FindOneTassess(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        Tassess tassess=session.selectOne("FindOneTassess",map);
        session.close();
        return tassess;
    }
}
