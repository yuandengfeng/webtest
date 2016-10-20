package servlet.FileUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by yuandengfeng on 2016/10/17.
 */
public class UploadServletAES extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        doPost(request,response);

    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {

        System.out.println("调用post接口");


        String srckey=request.getParameter("key"); //获取加密key
        System.out.println("srckey"+srckey);
        String fn=request.getParameter("fn").trim();    //获取文件名+日期:viplog-yyyy-MM-dd-HH.zip
        System.out.println("fn"+fn);
        String fdate=fn.split("\\.")[0].replace("viplog-","").trim(); //获取文件中日期:yyyy-MM-dd-HH
        System.out.println("fdate"+fdate);

        String cKey = "1234567890654321";  //加密的16位key
        String Desrckey=null;  //获取秘钥key
        try {
            Desrckey= AES.Decrypt(srckey, cKey);
            System.out.println("Desrckey"+Desrckey);
        } catch (Exception e) {
            e.printStackTrace();
        }


        String kfn=Desrckey.split(",")[0].split(":")[1].trim();  //获取key中的文件名+日期：viplog-yyyy-MM-dd-HH.zip
        String unixtime=Desrckey.split(",")[1].split(":")[1].trim(); //获取key中时间:1476166571
        String kdate =AES.unix2date(unixtime);//将key中时间戳转换成Date日期：yyyy-MM-dd-HH


        System.out.println("获取的加密key=="+srckey);
        System.out.println("获取文件名+日期=="+fn);
        System.out.println("获取文件中日期=="+fdate);
        System.out.println("获取key中的文件名+日期=="+kfn);
        System.out.println("将key中时间戳转换成Date日期=="+kdate);

        if(fn.equals(kfn) && fdate.equals(kdate))
        {

           BufferedInputStream in=new BufferedInputStream(request.getInputStream());
//         FileOutputStream fos=new FileOutputStream(new File("G:\\坤腾\\超汇VIPLog接口\\"+fn));
            FileOutputStream fos=new FileOutputStream(new File("/home/"+fn));
            byte[] inputByte = new byte[1024];
            int length=0;
            while((length=in.read(inputByte,0,inputByte.length))>0){
                fos.write(inputByte,0,length);
                fos.flush();
            }
            fos.close();


        }else {

            System.out.println("文件key校验没有通过！");

        }


    }




}
