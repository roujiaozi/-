package com.ssm.service;
import com.ssm.dao.UserDao;
import com.ssm.entity.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
    @Resource(name="userDaoImpl")
    private UserDao userDao;
    @Override
    public User checkLogin(User user) {
        return userDao.getUserByInfo(user);
    }

    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        ChooseService  CourseService=(ChooseService)context.getBean("ChooseServiceImpl");
        System.out.println(CourseService.FindAllNum());



    }
}
