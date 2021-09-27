package com.ssm.dao;

import com.ssm.entity.Choose;
import com.ssm.entity.Course;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Repository("ChooseDaoImpl")
public class ChooseDaoImpl implements ChooseDao {
    @Resource(name="sqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;
    @Override
    public void chooseAdd(Choose choose) {
        SqlSession session = this.sqlSessionFactory.openSession();
        int a=session.insert("chooseAdd",choose);
        session.commit();
        session.close();
    }

    @Override
    public void chooseDelete(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        int a=session.delete("chooseDelete",map);
        session.commit();
        session.close();
    }



    @Override
    public List<Choose> FindAllChoose1(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        List<Choose> list =session.selectList("FindAllChoose1",map);
        session.close();
        return list;
    }

    @Override
    public List<Choose> FindAllChoose2(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        List<Choose> list =session.selectList("FindAllChoose2",map);
        session.close();
        return list;
    }

    @Override
    public List<Choose> FindAllChoose3(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        List<Choose> list =session.selectList("FindAllChoose3",map);
        session.close();
        return list;
    }

    @Override
    public List<Choose> FindAllChoose4(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        List<Choose> list =session.selectList("FindAllChoose4",map);
        session.close();
        return list;
    }

    @Override
    public List<Choose> FindAllChoose5(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        List<Choose> list =session.selectList("FindAllChoose5",map);
        session.close();
        return list;
    }

    @Override
    public List<Choose> FindAllChoose6(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        List<Choose> list =session.selectList("FindAllChoose6",map);
        session.close();
        return list;
    }

    @Override
    public List<Choose> FindAllChoose7(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        List<Choose> list =session.selectList("FindAllChoose7",map);
        session.close();
        return list;
    }

    @Override
    public List<Choose> FindAllChoose8(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        List<Choose> list =session.selectList("FindAllChoose8",map);
        session.close();
        return list;
    }

    @Override
    public int FindAllChooseNum1(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        int aa =session.selectOne("FindAllChooseNum1",map);
        session.close();
        return aa;
    }

    @Override
    public int FindAllChooseNum2(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        int aa =session.selectOne("FindAllChooseNum2",map);
        session.close();
        return aa;
    }

    @Override
    public int FindAllChooseNum3(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        int aa =session.selectOne("FindAllChooseNum3",map);
        session.close();
        return aa;
    }

    @Override
    public int FindAllChooseNum4(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        int aa =session.selectOne("FindAllChooseNum4",map);
        session.close();
        return aa;
    }

    @Override
    public int FindAllChooseNum5(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        int aa =session.selectOne("FindAllChooseNum5",map);
        session.close();
        return aa;
    }

    @Override
    public int FindAllChooseNum6(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        int aa =session.selectOne("FindAllChooseNum6",map);
        session.close();
        return aa;
    }

    @Override
    public int FindAllChooseNum7(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        int aa =session.selectOne("FindAllChooseNum7",map);
        session.close();
        return aa;
    }

    @Override
    public int FindAllChooseNum8(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        int aa =session.selectOne("FindAllChooseNum8",map);
        session.close();
        return aa;
    }

    @Override
    public int FindAllChooseNum() {
        SqlSession session = this.sqlSessionFactory.openSession();
        int a=session.selectOne("FindAllChooseNum");
        session.close();
        return a;
    }

    @Override
    public Choose FindOneChoose(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        Choose choose=session.selectOne("FindOneChoose",map);
        session.close();
        return choose;
    }

    @Override
    public List<Choose> ExistChoose(String sid) {
        SqlSession session = this.sqlSessionFactory.openSession();
        List<Choose> list =session.selectList("ExistChoose",sid);
        session.close();
        return list;
    }

    @Override
    public List<Choose> ExistCid(String cid) {
        SqlSession session = this.sqlSessionFactory.openSession();
        List<Choose> list =session.selectList("ExistCid",cid);
        session.close();
        return list;
    }
}
