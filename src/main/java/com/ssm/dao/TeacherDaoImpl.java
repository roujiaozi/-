package com.ssm.dao;

import com.ssm.entity.Teacher;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("TeacherDaoImpl")
public class TeacherDaoImpl implements TeacherDao {
    @Resource(name="sqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;
    @Override
    public void addTeacher(Teacher teacher) {
        SqlSession session = this.sqlSessionFactory.openSession();
        session.insert("addTeacher",teacher);
        session.commit();
        session.close();
    }

    @Override
    public void deleteTeacher(String tid) {
        SqlSession session = this.sqlSessionFactory.openSession();
        session.delete("deleteTeacher",tid);
        session.commit();
        session.close();
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        SqlSession session = this.sqlSessionFactory.openSession();
        session.update("updateTeacher",teacher);
        session.commit();
        session.close();
    }

    @Override
    public boolean loginTeacher(String tid, String password) {
        boolean result=false;
        SqlSession session = this.sqlSessionFactory.openSession();
        Map<String,Object> map=new HashMap<>();
        map.put("tid",tid);
        map.put("password",password);
        Teacher teacher=session.selectOne("loginTeacher",map);
        if (teacher!=null){
            result=true;
        }
        session.commit();
        session.close();
        return result;
    }

    @Override
    public List<Teacher> findAllFenYeTeacher1(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        List<Teacher> list=session.selectList("findAllFenYeTeacher1",map);
        session.close();
        return list;
    }

    @Override
    public List<Teacher> findAllFenYeTeacher2(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        List<Teacher> list=session.selectList("findAllFenYeTeacher2",map);
        session.close();
        return list;
    }

    @Override
    public int findAllFenYeTeacherNum1(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        int aa=session.selectOne("findAllFenYeTeacherNum1",map);
        session.close();
        return aa;
    }

    @Override
    public int findAllFenYeTeacherNum2(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        int aa=session.selectOne("findAllFenYeTeacherNum2",map);
        session.close();
        return aa;
    }

    @Override
    public String getTid() {
        SqlSession session = this.sqlSessionFactory.openSession();
        String sid=session.selectOne("getTid");
        session.close();
        return sid;
    }

    @Override
    public Teacher findOneTeacher(String tid) {
        SqlSession session = this.sqlSessionFactory.openSession();
        Teacher teacher=session.selectOne("findOneTeacher",tid);
        session.close();
        return teacher;
    }

    @Override
    public int findTeacherAllNum() {
        SqlSession session = this.sqlSessionFactory.openSession();
        int num=session.selectOne("findTeacherAllNum");
        session.close();
        return num;
    }

    @Override
    public List<Teacher> findAllTeacher() {
        SqlSession session = this.sqlSessionFactory.openSession();
        List<Teacher> list=session.selectList("findAllTeacher");
        session.close();
        return list;
    }
}
