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
public class HelloWorldServlet extends HttpServlet {


    @SuppressWarnings("deprecation")
   public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException {


       resp.setContentType("text/html");
       PrintWriter out = resp.getWriter();
       out.println("<html><head><title>hello world eample!</title></head>");
       out.println("<body><h1>hello world:"+new Date().toLocaleString()+"</h1></body></html>");
       out.flush();

   }

    public void doPost(HttpServletRequest request,HttpServletResponse response){


    }


}
