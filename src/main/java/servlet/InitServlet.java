package servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Administrator on 2016/8/30.
 */
public class InitServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        Properties ps = new Properties();

        try {

            ServletContext context = config.getServletContext();
            InputStream is = context.getResourceAsStream("/conf/message.properties");
            ps.load(is);
            is.close();

            System.out.println(ps.get("name"));
            System.out.println(ps.get("age"));

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }



}
