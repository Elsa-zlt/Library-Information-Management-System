package com.zlt.dao;

import com.zlt.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User queryUser(@Param("name") String name, @Param("password") String password);
}
