package servlet.rabbitMQ;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by yuandengfeng on 2016/9/23.
 */
public class SendDownServlet extends HttpServlet {



    private static final String EXCHANGE_NAME ="connectionevent";

//    private static final String EXCHANGE_NAME ="mqtest";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取实际打卡时间date字段 2016 Sep 21 14:23:44
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy MMM d HH:mm:ss ", Locale.ENGLISH);
        Date date = new Date();
        String time=dateFormat.format(date);

        //用户mac
        String mac=req.getParameter("mac");

//        //打卡实际记录时间  Date或者String转化为时间戳
//        String timeToUnix=req.getParameter("unixTime");
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
////        String time="2016-09-21 11:45:55";
//        Date dates = null;
//        try {
//            dates = format.parse(timeToUnix);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        String unixTime=String.valueOf(date.getTime()/1000);

        String ip=req.getParameter("ip");

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.20.78");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "topic");
//        String message = "{\"date\":\""+time+"\",\"routerip\":\"192.168.96.201\",\"routermac\":\"D4EE074802A6\",\"channelpath\":\"1_POA_W4W\",\"program\":\"kt-macscan\",\"unixtime\":\""+unixTime+"\",\"msg_kunteng\":{\"evttype\":\"connection\",\"mac\":\""+mac+"\",\"evt\":\"up\",\"type\":\"wifi\",\"name\":\"iPhone\",\"rpt\":\"false\",\"type_wifi\":\"5G\",\"signal\":\"100\",\"ip\":\""+ip+"\",\"iptype\":\"dhcp\"},\"evttype\":\"connection\",\"mac\":\""+mac+"\",\"evt\":\"up\",\"type\":\"wifi\",\"name\":\"iPhone\",\"rpt\":\"false\",\"type_wifi\":\"5G\",\"signal\":\"100\",\"ip\":\""+ip+"\",\"iptype\":\"dhcp\"}";
        String message = "{\"date\":\""+time+"\",\"routerip\":\"192.168.96.201\",\"routermac\":\"D4EE074802A6\",\"channelpath\":\"1_POA_W4W\",\"program\":\"kt-macscan\",\"unixtime\":\""+unixTime+"\",\"msg_kunteng\":{\"evttype\":\"connection\",\"mac\":\""+mac+"\",\"evt\":\"down\",\"type\":\"wifi\",\"name\":\"iPhone\",\"rpt\":\"false\",\"type_wifi\":\"5G\",\"signal\":\"100\",\"ip\":\""+ip+"\",\"iptype\":\"dhcp\"},\"evttype\":\"connection\",\"mac\":\""+mac+"\",\"evt\":\"down\",\"type\":\"wifi\",\"name\":\"iPhone\",\"rpt\":\"false\",\"type_wifi\":\"5G\",\"signal\":\"100\",\"ip\":\""+ip+"\",\"iptype\":\"dhcp\"}";
        channel.basicPublish(EXCHANGE_NAME, "ktmsg.core.connection.enterprise.POA.W4W", null, message.getBytes());

        System.out.println(" [x] Sent message ==" + message );

        //数据提交后 在界面展示内容————>>
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>Send Message!</title></head>");
        out.println("<body>mac=="+mac+"<br>");
        out.println("unixTime=="+unixTime+"<br>");
        out.println("ip=="+ip+"</body></html>");
        out.flush();
        //<<-------数据提交后 在界面展示内容


        channel.close();
        connection.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
