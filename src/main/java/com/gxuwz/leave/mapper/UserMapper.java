package com.gxuwz.leave.mapper;

import com.gxuwz.leave.entity.User;

import java.util.List;

/**
 * @author amu_1115@126.com
 * @version 1.0
 */
public interface UserMapper {

    public void insert(User entity);
    public void update(User entity);
    public void delete(String id);
    public List<User> query(User entity);

}
