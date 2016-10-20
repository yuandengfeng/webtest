package servlet.ajax;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2016/9/4.
 */
public class AjaxServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String v1= req.getParameter("v1");
        String v2= req.getParameter("v2");

        String v3 = String.valueOf(Integer.valueOf(v1)+Integer.valueOf(v2));
        PrintWriter out = resp.getWriter();

        System.out.println("doGet invoked!");
        out.println(v3);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String v1= req.getParameter("v1");
        String v2= req.getParameter("v2");

        String v3 = String.valueOf(Integer.valueOf(v1)+Integer.valueOf(v2));
        PrintWriter out = resp.getWriter();

        System.out.println("doPost invoked!");
        out.println(v3);
        out.flush();


    }
}
