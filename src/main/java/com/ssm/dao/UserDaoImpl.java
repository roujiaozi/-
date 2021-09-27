package com.ssm.dao;

import com.ssm.entity.Choose;
import com.ssm.entity.Student;
import com.ssm.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("userDaoImpl")
public class UserDaoImpl implements UserDao {
    @Resource(name="sqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;
    @Override
    public User getUserByInfo(User user) {
        SqlSession session = this.sqlSessionFactory.openSession();
        User u = session.selectOne("user.getUserByInfo", user);
        session.close();
        return u;
    }


    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        ChooseDao userDao=(ChooseDao)context.getBean("ChooseDaoImpl");


    }


}
