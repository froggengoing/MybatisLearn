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
public class M0003_TxMain {


    public static void main(String[] args) throws IOException {
        String resource = "mapper/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        Configuration configuration = sqlSessionFactory.getConfiguration();
        System.out.println(sqlSessionFactory);
        try (SqlSession session = sqlSessionFactory.openSession();
             SqlSession session2 = sqlSessionFactory.openSession();
             SqlSession session3 = sqlSessionFactory.openSession()
        ) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            UserMapper mapper2 = session2.getMapper(UserMapper.class);
            UserMapper mapper3 = session3.getMapper(UserMapper.class);
            long id = 100000L;
            FyUser user = new FyUser().setId(id).setEmail("12345");
            int res = mapper.insert(user);
            FyUser fyUser = mapper.selectUser(id);
            FyUser fyUser2 = mapper2.selectUser(id);

            System.out.println("select user before commit same session:" + fyUser);
            System.out.println("select user before commit other session:" + fyUser2);
            //必须提交事务
            session.commit();
            FyUser fyUser21 = mapper2.selectUser(id);
            FyUser fyUser3 = mapper3.selectUser(id);
            System.out.println("select user after commit other session:" + fyUser21);
            System.out.println("select user after commit other session not cache:" + fyUser3);
            System.out.println(res);

        }
    }
}
