package com.zlt.service;

import com.zlt.pojo.User;
public interface UserService {

    User queryUser(String name,String password);

}