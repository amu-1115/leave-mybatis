package com.gxuwz.leave.web.servlet;

import com.alibaba.fastjson2.JSON;
import com.gxuwz.leave.web.dto.ApiResult;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author amu_1115@126.com
 * @version 1.0
 */
public abstract class BaseServlet extends HttpServlet {
    /**
     *
     * @param resp
     * @param result
     * @throws IOException
     */
    protected  void createJSONContent(HttpServletResponse resp, ApiResult result)throws IOException{
        resp.setContentType("application/json;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.getWriter().print(JSON.toJSONString(result));
        resp.getWriter().flush();
        resp.getWriter().close();
    }
}
