package com.gxuwz.leave.service;

import com.gxuwz.leave.dao.UserDao;
import com.gxuwz.leave.entity.User;

import java.util.List;

public class UserService {

    private UserDao userDao;

    public UserService(){
        this.userDao = new UserDao();
    }
    public void addUser(User entity){
        userDao.insert(entity);
    }
    public void editUser(User entity){
        userDao.update(entity);
    }
    public List<User> listUser(User entity){
        return userDao.query(entity);
    }

    /**
     *
     * @param userid
     * @param password
     * @return
     */
    public boolean checkUser(String userid,String password){
        List<User> list =userDao.query(new User(userid,password));
        return !list.isEmpty();
    }
    public User getUser(String userid){
       List<User>  list =userDao.query(new User(userid));
       if(!list.isEmpty()){
           return list.get(0);
       }else{
           return null;
       }
    }
}
