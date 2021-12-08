package com.zlt.service;

import com.zlt.dao.UserMapper;
import com.zlt.pojo.User;

public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    @Override
    public User queryUser( String name, String password) {

        User user = userMapper.queryUser(name,password);
        return user;

    }
    public void setUserMapper(UserMapper userMapper) {

        this.userMapper = userMapper;

    }
}
