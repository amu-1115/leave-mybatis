package com.gxuwz.leave.dao;

import com.gxuwz.leave.config.MybatisUtil;
import com.gxuwz.leave.entity.User;
import com.gxuwz.leave.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author amu_1115@126.com
 * @version 1.0
 */
public class UserDao {
    public void insert(User entity){
        SqlSession session = MybatisUtil.getSession();
        try{
            session.insert("com.gxuwz.leave.mapper.UserMapper.insert",entity);
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
        }finally {
            MybatisUtil.close(session);
        }
    }
    public void update(User entity){
        SqlSession session = MybatisUtil.getSession();
        try{
            UserMapper mapper =session.getMapper(UserMapper.class);
            mapper.update(entity);
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
        }finally {
            MybatisUtil.close(session);
        }
    }
    public void delete(String id){

        SqlSession session = MybatisUtil.getSession();
        try{
            UserMapper mapper =session.getMapper(UserMapper.class);
            mapper.delete(id);
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
        }finally {
            MybatisUtil.close(session);
        }
    }
    public List<User> query(User entity){
        SqlSession session = MybatisUtil.getSession();
        try{
            UserMapper mapper =session.getMapper(UserMapper.class);
             return mapper.query(entity);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            MybatisUtil.close(session);
        }
    }
}
