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
public class UploadServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        doPost(request,response);

    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {

        System.out.println("调用post接口");


           BufferedInputStream in=new BufferedInputStream(request.getInputStream());
         FileOutputStream fos=new FileOutputStream(new File("G:\\坤腾\\超汇VIPLog接口\\ccc.java"));
//            FileOutputStream fos=new FileOutputStream(new File("/home/aaa.java"));
            byte[] inputByte = new byte[1024];
            int length=0;
            while((length=in.read(inputByte,0,inputByte.length))>0){
                fos.write(inputByte,0,length);
                fos.flush();
            }
            fos.close();




    }




}
