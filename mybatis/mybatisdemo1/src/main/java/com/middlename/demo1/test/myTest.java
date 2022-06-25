package com.middlename.demo1.test;

import com.middlename.demo1.mapper.UserMapper;
import com.middlename.demo1.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class myTest {

    public static void main(String[] args) throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User userbyID = mapper.getUserbyID();
        System.out.println(userbyID);

        List<User> allUser = mapper.getAllUser();
        allUser.forEach(ite -> System.out.println(ite));

    }

    public void passedTest() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

//  ===================增删改========================================
        int i = mapper.insertUser();System.out.println(i);

        int i1 = mapper.modifyUser();
        System.out.println(i1);

        int i2 = mapper.deleteUser();
        System.out.println(i2);

//  ======================搜索======================================
        User userbyID = mapper.getUserbyID();
        System.out.println(userbyID);

        List<User> allUser = mapper.getAllUser();
        allUser.forEach(ite -> System.out.println(ite));

//
    }
}
