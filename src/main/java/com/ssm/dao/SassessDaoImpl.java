package com.ssm.dao;

import com.ssm.entity.Choose;
import com.ssm.entity.Sassess;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Repository("SassessDaoImpl")
public class SassessDaoImpl implements SassessDao{
    @Resource(name="sqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;
    @Override
    public void SassessAdd(Sassess sassess) {
        SqlSession session = this.sqlSessionFactory.openSession();
        int a=session.insert("SassessAdd",sassess);
        session.commit();
        session.close();
    }

    @Override
    public void SassessDelete(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        int a=session.delete("SassessDelete",map);
        session.commit();
        session.close();
    }

    @Override
    public List<Sassess> FindAllSassess1(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        List<Sassess> list =session.selectList("FindAllSassess1",map);
        session.close();
        return list;
    }

    @Override
    public List<Sassess> FindAllSassess2(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        List<Sassess> list =session.selectList("FindAllSassess2",map);
        session.close();
        return list;
    }

    @Override
    public List<Sassess> FindAllSassess3(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        List<Sassess> list =session.selectList("FindAllSassess3",map);
        session.close();
        return list;
    }

    @Override
    public List<Sassess> FindAllSassess4(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        List<Sassess> list =session.selectList("FindAllSassess4",map);
        session.close();
        return list;
    }

    @Override
    public List<Sassess> FindAllSassess5(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        List<Sassess> list =session.selectList("FindAllSassess5",map);
        session.close();
        return list;
    }

    @Override
    public List<Sassess> FindAllSassess6(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        List<Sassess> list =session.selectList("FindAllSassess6",map);
        session.close();
        return list;
    }

    @Override
    public List<Sassess> FindAllSassess7(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        List<Sassess> list =session.selectList("FindAllSassess7",map);
        session.close();
        return list;
    }

    @Override
    public List<Sassess> FindAllSassess8(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        List<Sassess> list =session.selectList("FindAllSassess8",map);
        session.close();
        return list;
    }

    @Override
    public List<Sassess> FindAllSassess(Map<String,Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        List<Sassess> list =session.selectList("FindAllSassess",map);
        session.close();
        return list;
    }

    @Override
    public int FindAllSassessNum1(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        int aa=session.selectOne("FindAllSassessNum1",map);
        session.close();
        return aa;
    }

    @Override
    public int FindAllSassessNum2(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        int aa=session.selectOne("FindAllSassessNum2",map);
        session.close();
        return aa;
    }

    @Override
    public int FindAllSassessNum3(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        int aa=session.selectOne("FindAllSassessNum3",map);
        session.close();
        return aa;
    }

    @Override
    public int FindAllSassessNum4(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        int aa=session.selectOne("FindAllSassessNum4",map);
        session.close();
        return aa;
    }

    @Override
    public int FindAllSassessNum5(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        int aa=session.selectOne("FindAllSassessNum5",map);
        session.close();
        return aa;
    }

    @Override
    public int FindAllSassessNum6(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        int aa=session.selectOne("FindAllSassessNum6",map);
        session.close();
        return aa;
    }

    @Override
    public int FindAllSassessNum7(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        int aa=session.selectOne("FindAllSassessNum7",map);
        session.close();
        return aa;
    }

    @Override
    public int FindAllSassessNum8(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        int aa=session.selectOne("FindAllSassessNum8",map);
        session.close();
        return aa;
    }

    @Override
    public int FindAllSassessNum() {
        SqlSession session = this.sqlSessionFactory.openSession();
        int a=session.selectOne("FindAllChooseNum");
        session.close();
        return a;
    }

    @Override
    public Sassess FindOneSassess(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        Sassess sassess=session.selectOne("FindOneSassess",map);
        session.close();
        return sassess;
    }
}
