package com.gxuwz.leave.service;

import com.gxuwz.leave.dao.UserDao;
import com.gxuwz.leave.entity.User;

public class UserService {

    private UserDao userDao;

    public UserService(){
        this.userDao = new UserDao();
    }
    public void addUser(User entity){
        userDao.insert(entity);
    }
}
