package com.gxuwz.leave.config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @author amu_1115@126.com
 * @version 1.0
 */
public class MybatisUtil {
    public static  SqlSessionFactory sqlSessionFactory ;
    public static final String RESOURCE="mybtais-config.xml";
    static{
        try{
             InputStream inputStream = Resources.getResourceAsStream(RESOURCE);
             if(sqlSessionFactory==null){
                 sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
             }
        }catch (Throwable e){
            e.printStackTrace();
            throw new ExceptionInInitializerError(e);
        }
    }
    public static SqlSession getSession(){
        return sqlSessionFactory.openSession();
    }
    public static void close(SqlSession session){
        if(session!=null){
            session.close();
        }
    }
}
