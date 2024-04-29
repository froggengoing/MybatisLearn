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
import java.util.List;

/**
 * @author fly
 * @create 2024-04-29-11:26
 **/
public class M0001_SessionMain {


    public static void main(String[] args) throws IOException {
        String resource = "mapper/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        Configuration configuration = sqlSessionFactory.getConfiguration();
        System.out.println(sqlSessionFactory);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            List<FyUser> user = session.selectList("com.fly.mybatis.mapper.UserMapper.getList", new FyUser().setId(100002L));
            //在下方先debug，然后修改数据库
            UserMapper mapper = session.getMapper(UserMapper.class);
            System.out.println(mapper.getList(new FyUser().setId(100002L)));
            System.out.println(user);
        //    上面这两个打印时一致的说明，使用了缓存
        }
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            System.out.println(mapper.getList(new FyUser().setId(100002L)));
        }
    }
}
