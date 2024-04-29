package com.fly.mybatis;

import com.fly.mybatis.mapper.UserMapper;
import com.fly.mybatis.model.FyUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author fly
 * @create 2024-04-29-11:26
 **/
public class M0002_BaseMapperMain {


    public static void main(String[] args) throws IOException {
        String resource = "mapper/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        Configuration configuration = sqlSessionFactory.getConfiguration();
        System.out.println(sqlSessionFactory);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            FyUser res = mapper.selectUser(100002L);
            System.out.println(res);
            session.close();
        }
    }
}
