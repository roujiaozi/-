package com.ssm.dao;

import com.ssm.entity.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("StudentDaoImpl")
public class StudentDaoImpl implements StudentDao{
    @Resource(name="sqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;
    @Override
    public int findAllNum() {
        SqlSession session = this.sqlSessionFactory.openSession();
        int a=session.selectOne("findAllNum");
        session.close();
        return a;
    }

    @Override
    public List<Student> findAllStudent(Map<String,Object> map) {

        SqlSession session = this.sqlSessionFactory.openSession();
        List<Student> list=session.selectList("findAllStudent",map);
        session.close();
        return list;
    }

    @Override
    public void addStudent(Student student) {
        SqlSession session = this.sqlSessionFactory.openSession();
        int i = session.insert("addStudent", student);
        session.commit();
        session.close();

    }

    @Override
    public void updateStudent(Student student) {
        SqlSession session = this.sqlSessionFactory.openSession();
        int i = session.update("updateStudent", student);
        session.commit();
        session.close();
    }

    @Override
    public Student findOneStudent(String sid) {
        SqlSession session = this.sqlSessionFactory.openSession();
        Student stu = session.selectOne("findOneStudent", sid);
        session.close();
        return stu;
    }

    @Override
    public void deleteStudent(String id) {
        SqlSession session = this.sqlSessionFactory.openSession();
        session.delete("deleteStudent",id);
        session.commit();
        session.close();
    }

    @Override
    public List<Student> findAllFenYeStudent1(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        List<Student> list=session.selectList("findAllFenYeStudent1",map);
        session.close();
        return list;
    }
    @Override
    public List<Student> findAllFenYeStudent2(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        List<Student> list=session.selectList("findAllFenYeStudent2",map);
        session.close();
        return list;
    }
    @Override
    public List<Student> findAllFenYeStudent3(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        List<Student> list=session.selectList("findAllFenYeStudent3",map);
        session.close();
        return list;
    }
    @Override
    public List<Student> findAllFenYeStudent4(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        List<Student> list=session.selectList("findAllFenYeStudent4",map);
        session.close();
        return list;
    }

    @Override
    public int findAllFenYeStudentNum1(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        int aa=session.selectOne("findAllFenYeStudentNum1",map);
        session.close();
        return aa;
    }

    @Override
    public int findAllFenYeStudentNum2(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        int aa=session.selectOne("findAllFenYeStudentNum2",map);
        session.close();
        return aa;
    }

    @Override
    public int findAllFenYeStudentNum3(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        int aa=session.selectOne("findAllFenYeStudentNum3",map);
        session.close();
        return aa;
    }

    @Override
    public int findAllFenYeStudentNum4(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        int aa=session.selectOne("findAllFenYeStudentNum4",map);
        session.close();
        return aa;
    }

    @Override
    public String getSid() {
        SqlSession session = this.sqlSessionFactory.openSession();
        String sid=session.selectOne("getSid");
        session.close();
        return sid;
    }

    @Override
    public List<Student> findAllStudentList() {
        SqlSession session = this.sqlSessionFactory.openSession();
        List<Student> list=session.selectList("findAllStudentList");
        session.close();
        return list;
    }


}
