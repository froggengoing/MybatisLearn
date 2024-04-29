package com.fly.mybatis.mapper;

import com.fly.mybatis.model.FyUser;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author fly
 * @create 2024-04-29-12:02
 **/
public interface UserMapper {

    List<FyUser>  getList(FyUser user);

    @Select("SELECT * FROM atp_user WHERE id = #{id}")
    FyUser selectUser(int id);
}
