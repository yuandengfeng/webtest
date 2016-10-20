package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/23.
 * 用户登录验证
 */
public class UserLogin extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    this.process(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.process(req,resp);

    }

    protected void process(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password =req.getParameter("password");
        String gender=req.getParameter("gender");
        String[] interest=req.getParameterValues("interest");
        String address=req.getParameter("address");
        String comment=req.getParameter("comment");
        List<String> list = new ArrayList<String>();
        if(null==username ||"".equals(username))
        {
            list.add("用户名不能为空！");
        }
        if(null==password || "".equals(password))
        {
            list.add("密码不能为空！");
        }

        if(null==gender){
            list.add("性别没有选择！");
        }

        if(null==interest){

            list.add("兴趣至少选择一个！");
        }else if (interest.length>3){
            list.add("兴趣最多选择3个！");
        }

        if (null==comment ||"".equals(comment))
        {
            list.add("说明没有填写！");
        }
       if(list.isEmpty())
       {
           req.setAttribute("username",username);
           req.setAttribute("password",password);
           req.setAttribute("gender",gender);
           req.setAttribute("interest",interest);
           req.setAttribute("address",address);
           req.setAttribute("comment",comment);
           req.getRequestDispatcher("/loginvalidate/loginSucess.jsp").forward(req,resp);
       }else{

           req.setAttribute("error",list);
           req.getRequestDispatcher("/loginvalidate/loginFailure.jsp").forward(req,resp);
       }

    }

}
