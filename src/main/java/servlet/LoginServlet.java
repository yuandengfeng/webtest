package servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by Administrator on 2016/8/17.
 */
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException {


        System.out.println(req);
        System.out.println(resp);
       String username=req.getParameter("username");
       String password=req.getParameter("password");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>Login Result!</title></head>");
        out.println("<body>username"+username+"<br>");
        out.println("password"+password+"</body></html>");
        out.flush();

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {


        System.out.println("doPost invoked!");
        System.out.println(req);
        System.out.println(resp);
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>Login Result!</title></head>");
        out.println("<body>username"+username+"<br>");
        out.println("password"+password+"</body></html>");
        out.flush();


    }



}
