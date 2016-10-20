package servlet;

import javabean.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Administrator on 2016/8/25.
 */
public class LoginSession extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String authority=req.getParameter("authority");

        System.out.println("========================================");
        if("1".equals(authority))
        {
            System.out.println("**qwewew*****");
            //登录是普通用户
            if("zhangsan".equals(username) && "123".equals(password))
            {
                //将用户的信息放置到session当中
                User user = new User();
                user.setUsername(username);
                user.setPassword(password);
                user.setAuthority(authority);

                HttpSession session =req.getSession();
                session.setAttribute("user",user);

                System.out.println("*********");
            }else { //登录失败

                req.setAttribute("username",username);
                req.setAttribute("password",password);
                req.setAttribute("authority",authority);
                RequestDispatcher rd=req.getRequestDispatcher("/loginSession/login.jsp");
                rd.forward(req,resp);
            }

        } else if("2".equals(authority))
        {
            //登录是系统管理员
            if("lisi".equals(username) && "456".equals(password))
            {
                //将用户的信息放置到session当中
                User user = new User();
                user.setUsername(username);
                user.setPassword(password);
                user.setAuthority(authority);

                HttpSession session =req.getSession();
                session.setAttribute("user",user);
            }else { //登录失败

                req.setAttribute("username",username);
                req.setAttribute("password",password);
                req.setAttribute("authority",authority);
                RequestDispatcher rd=req.getRequestDispatcher("/loginSession/login.jsp");
                rd.forward(req,resp);
            }

        }else { //登录失败

            req.setAttribute("username",username);
            req.setAttribute("password",password);
            req.setAttribute("authority",authority);
            RequestDispatcher rd=req.getRequestDispatcher("/loginSession/login.jsp");
            rd.forward(req,resp);
        }

    }
}
