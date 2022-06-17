package com.gxuwz.leave.web.servlet;

import com.gxuwz.leave.entity.User;
import com.gxuwz.leave.service.UserService;
import com.gxuwz.leave.util.StringUtil;
import com.gxuwz.leave.web.dto.ApiResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author amu_1115@126.com
 * @version 1.0
 */
@WebServlet(urlPatterns = {"/api/login"})
public class LoginServlet extends BaseServlet {
    private final static Logger LOG = LoggerFactory.getLogger(LoginServlet.class);
    private UserService userService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userid = req.getParameter("userid");
        String password =req.getParameter("password");
        ApiResult result = new ApiResult();
        LOG.info("userid:"+userid+",password:"+password);
        try {
            boolean flag = userService.checkUser(StringUtil.trimToEmpty(userid), StringUtil.trimToEmpty(password));

            if (flag) {
                result.setCode("200.1");
                result.setMessage("验证通过");
                User user = userService.getUser(userid);
                user.setPassword(null);
                result.setData(user);
            } else {
                result.setCode("200.0");
                result.setMessage("[" + userid + "”]找不到对应记录");
            }
        }catch (Exception e){
            e.printStackTrace();
            result.setCode("500");
            result.setMessage("系统内部错误:"+e.getMessage()+"");
        }finally {
            createJSONContent(resp,result);
        }
    }

    @Override
    public void init() throws ServletException {
        this.userService =new UserService();
    }
}
