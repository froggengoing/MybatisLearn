package com.fly.mybatis.mapper;

import com.fly.mybatis.model.FyUser;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

/**
 * @author fly
 * @create 2024-04-29-12:02
 **/
public interface UserMapper extends BaseMapper {

    List<FyUser> getList(FyUser user);


    @Insert("Insert into  atp_test_user(id,email) values (#{id},#{email})")
    int insert(FyUser user);
}
