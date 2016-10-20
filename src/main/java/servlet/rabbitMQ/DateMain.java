package servlet.rabbitMQ;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by yuandengfeng on 2016/9/21.
 */
public class DateMain {

    public static void main(String[] args) throws ParseException {

////        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm");
//        //2016 Sep 21 14:23:44
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy MMM dd HH:mm:ss ",Locale.ENGLISH);


        //Date或者String转化为时间戳
        String fileName="viplog-2016-10-11-14.zip"; //1476166571
        String fdate=fileName.split("\\.")[0].replace("viplog-","").trim();
        System.out.println("fdate="+fdate);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH");

        Date date = format.parse(fdate);
        String time= String.valueOf(date.getTime()/1000);
        System.out.println("Format To times:"+time);


//        SimpleDateFormat strformat = new SimpleDateFormat("yyyy-MM-dd-HH");
//        Long unixtime = Long.parseLong("1476166571")*1000;
//
//        String unixdate = strformat.format(new Date(unixtime));
//
//        System.out.println(unixdate);

    }

}
