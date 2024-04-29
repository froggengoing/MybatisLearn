package com.fly.mybatis.mapper;

import com.fly.mybatis.model.FyUser;
import org.apache.ibatis.annotations.Select;

/**
 * @author fly
 * @create 2024-04-29-15:35
 **/
public interface BaseMapper {

    @Select("SELECT * FROM atp_test_user WHERE id = #{id}")
    FyUser selectUser(Long id);
}
