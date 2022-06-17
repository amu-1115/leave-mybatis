package com.gxuwz.leave.web.servlet;

import com.alibaba.fastjson2.JSON;
import com.gxuwz.leave.util.PathMatcherUtil;
import com.gxuwz.leave.web.dto.ApiResult;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author amu_1115@126.com
 * @version 1.0
 */
public abstract class BaseServlet extends HttpServlet {
    private final static String ROOT_URL_PATTERN="^/[a-z]*/[a-z]*/[a-z]*$";
    private final static String WEBAPP_URL_PATTERN="^/[a-z]*/[a-z]*/[a-z]*/[a-z]*$";

    public String getAction(HttpServletRequest req)throws ServletException,IOException{
          String uri =req.getRequestURI();//如/leave/api/user/* 或者/api/user/*
          String contextPath=req.getContextPath();
          boolean isRoot=contextPath.equals("/");
          return  PathMatcherUtil.doMatcher(uri,isRoot);
    }

    /**
     * 请求参数转换为bean对象
     * @param req
     * @param bean
     * @throws ServletException
     * @throws IOException
     */
    public Object dataBindBean(HttpServletRequest req,Object bean)throws ServletException,IOException{
        try {
            HashMap map = new HashMap();
            Enumeration names = req.getParameterNames();
            while (names.hasMoreElements()) {
                String name = (String) names.nextElement();
                map.put(name, req.getParameterValues(name));
            }
            BeanUtils.populate(bean, map);
        }catch (Exception e){
            e.printStackTrace();
        }
        return bean;
    }
    public String getSingleParam(HttpServletRequest req,String param)throws ServletException,IOException{
           return req.getParameter(param);
    }
    /**
     *
     * @param resp
     * @param result
     * @throws IOException
     */
    protected  void createJSONContent(HttpServletResponse resp, ApiResult result)throws  IOException{
        resp.setContentType("application/json;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.getWriter().print(JSON.toJSONString(result));
        resp.getWriter().flush();
        resp.getWriter().close();
    }
}
