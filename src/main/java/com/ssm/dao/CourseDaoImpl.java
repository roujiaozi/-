package com.ssm.dao;

import com.ssm.entity.Course;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Repository("CourseDaoImpl")
public class CourseDaoImpl implements CourseDao {
    @Resource(name="sqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;
    @Override
    public void courseAdd(Course course) {
        SqlSession session = this.sqlSessionFactory.openSession();
        int a=session.insert("courseAdd",course);
        session.commit();
        session.close();
    }

    @Override
    public void courseDelete(String cid) {
        SqlSession session = this.sqlSessionFactory.openSession();
        int a=session.delete("courseDelete",cid);
        session.commit();
        session.close();
    }

    @Override
    public void courseUpdate(Course course) {
        SqlSession session = this.sqlSessionFactory.openSession();
        int a=session.update("courseUpdate",course);
        session.commit();
        session.close();
    }

    @Override
    public List<Course> FindAllCourse1(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        List<Course> list =session.selectList("FindAllCourse1",map);
        session.close();
        return list;
    }

    @Override
    public List<Course> FindAllCourse2(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        List<Course> list =session.selectList("FindAllCourse2",map);
        session.close();
        return list;
    }

    @Override
    public List<Course> FindAllCourse3(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        List<Course> list =session.selectList("FindAllCourse3",map);
        session.close();
        return list;
    }

    @Override
    public List<Course> FindAllCourse4(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        List<Course> list =session.selectList("FindAllCourse4",map);
        session.close();
        return list;
    }

    @Override
    public List<Course> FindAllCourse5(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        List<Course> list =session.selectList("FindAllCourse5",map);
        session.close();
        return list;
    }

    @Override
    public List<Course> FindAllCourse6(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        List<Course> list =session.selectList("FindAllCourse6",map);
        session.close();
        return list;
    }

    @Override
    public List<Course> FindAllCourse7(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        List<Course> list =session.selectList("FindAllCourse7",map);
        session.close();
        return list;
    }

    @Override
    public List<Course> FindAllCourse8(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        List<Course> list =session.selectList("FindAllCourse8",map);
        session.close();
        return list;
    }

    @Override
    public int FindAllCourseNum1(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        int aa =session.selectOne("FindAllCourseNum1",map);
        session.close();
        return aa;
    }

    @Override
    public int FindAllCourseNum2(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        int aa =session.selectOne("FindAllCourseNum2",map);
        session.close();
        return aa;
    }

    @Override
    public int FindAllCourseNum3(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        int aa =session.selectOne("FindAllCourseNum3",map);
        session.close();
        return aa;
    }

    @Override
    public int FindAllCourseNum4(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        int aa =session.selectOne("FindAllCourseNum4",map);
        session.close();
        return aa;
    }

    @Override
    public int FindAllCourseNum5(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        int aa =session.selectOne("FindAllCourseNum5",map);
        session.close();
        return aa;
    }

    @Override
    public int FindAllCourseNum6(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        int aa =session.selectOne("FindAllCourseNum6",map);
        session.close();
        return aa;
    }

    @Override
    public int FindAllCourseNum7(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        int aa =session.selectOne("FindAllCourseNum7",map);
        session.close();
        return aa;
    }

    @Override
    public int FindAllCourseNum8(Map<String, Object> map) {
        SqlSession session = this.sqlSessionFactory.openSession();
        int aa =session.selectOne("FindAllCourseNum8",map);
        session.close();
        return aa;
    }

    @Override
    public List<Course> FindAllCourse() {
        SqlSession session = this.sqlSessionFactory.openSession();
        List<Course> list =session.selectList("FindAllCourse");
        session.close();
        return list;
    }

    @Override
    public List<Course> FindAllTidCourse(String tid) {
        SqlSession session = this.sqlSessionFactory.openSession();
        List<Course> list =session.selectList("FindAllTidCourse",tid);
        session.close();
        return list;
    }

    @Override
    public int FindAllNum() {
        SqlSession session = this.sqlSessionFactory.openSession();
        int a=session.selectOne("FindAllNum");
        session.close();
        return a;
    }

    @Override
    public Course FindOneCourse(String cid) {
        SqlSession session = this.sqlSessionFactory.openSession();
        Course course=session.selectOne("FindOneCourse",cid);
        session.close();
        return course;
    }

    @Override
    public String getCourseId() {
        SqlSession session = this.sqlSessionFactory.openSession();
        String cid=session.selectOne("getCourseId");
        session.close();
        return cid;
    }

    @Override
    public List<Course> ExistCourse(String tid) {
        SqlSession session = this.sqlSessionFactory.openSession();
        List<Course> list =session.selectList("ExistCourse",tid);
        session.close();
        return list;
    }
}
