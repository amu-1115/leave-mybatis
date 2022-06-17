package com.gxuwz.leave.web.servlet;

import com.gxuwz.leave.entity.User;
import com.gxuwz.leave.service.UserService;
import com.gxuwz.leave.web.dto.ApiResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author amu_1115@126.com
 * @version 1.0
 */
@WebServlet(urlPatterns = {"/api/user/*"})
public class UserServlet extends BaseServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        this.userService =new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=super.getAction(req);
        //创建响应报文对象
        ApiResult result=new ApiResult();
        try {
            User entity=null;
            switch (action) {
                case "list":
                    entity=(User)dataBindBean(req,new User());
                    List<User> list =userService.listUser(entity);
                    result.setData(list);
                    break;
                case "add":
                     entity=(User)dataBindBean(req,new User());
                    userService.addUser(entity);
                    break;
                case "edit":
                     entity=(User)dataBindBean(req,new User());
                     userService.editUser(entity);
                    break;
                case "get":
                    entity= userService.getUser(getSingleParam(req,"id"));
                    result.setData(entity);
                    break;
                default:
                    result.setMessage("请求url解析错误");
                    break;
            }
            result.setCode("200.1");
        }catch (Exception e){
            result.setCode("500");
            result.setMessage("系统内部错误:"+e.getMessage());
        }finally {
            //返回响应报文
            createJSONContent(resp,result);
        }
    }
}
