package servlet.FileUtil;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by yuandengfeng on 2016/10/17.
 */
public class UploadTestAES {


    public UploadTestAES(){
        String filePath="G:\\坤腾\\超汇VIPLog接口\\cc\\SftpUtil.java";
        String fileName="SftpUtil.java";
        try{
            URL url=new URL("http://localhost:8080//UploadServlet");
            HttpURLConnection connection=(HttpURLConnection)url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            BufferedOutputStream out=new BufferedOutputStream(connection.getOutputStream());
            File file=new File(filePath);
            FileInputStream fis=new FileInputStream(file);
            byte[] bytes=new byte[1024];
            int numReadByte=0;
            while((numReadByte=fis.read(bytes,0,1024))>0){
                out.write(bytes,0,numReadByte);
            }
            out.flush();
            fis.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
//        new UploadTest();


//        String str="http://localhost:8080//UploadServlet";
//        ?mac=68FB7EEE43DC&unixTime=2016-09-21+16%3A22%3A22&ip=192.111.11.11

//        String fileName="viplog-2016-10-11-15.zip"; //要上传的文件名:文件名+日期
        String fileName=args[0];
//        String filePath="G:\\坤腾\\超汇VIPLog接口\\cc\\"+fileName;
        String filePath="/opt/"+fileName;

        String cKey = "1234567890654321"; //长度为16位的加密key

        String fdate=fileName.split("\\.")[0].replace("viplog-","").trim(); //获取文件中日期:yyyy-MM-dd-HH
        String timestamp = AES.date2unix(fdate);
        String cSrc="filename:"+fileName+",timestamp :"+timestamp;
//        String cSrc = "filename : viplog-2016-10-11-14.zip , timestamp : 1476166571";

        String enString=null;
        try {
           enString= AES.Encrypt(cSrc, cKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(enString);
        String encodekey = URLEncoder.encode(enString, "UTF-8"); //对key进行AES加密,做base64处理后避免空格等特许字符进行URLEncoder.encode处理
        System.out.println(encodekey);

        String str="http://192.168.0.81:8080//webtest//UploadServletAES?fn="+fileName+"&key="+encodekey;


        try {

            URL url=new URL(str);
            HttpURLConnection connection=(HttpURLConnection)url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.addRequestProperty("FileName", fileName);

            connection.setRequestProperty("content-type", "text/html");
            BufferedOutputStream  out=new BufferedOutputStream(connection.getOutputStream());

            //读取文件上传到服务器
            File file=new File(filePath);
            FileInputStream fileInputStream=new FileInputStream(file);
            byte[]bytes=new byte[1024];
            int numReadByte=0;
            while((numReadByte=fileInputStream.read(bytes,0,1024))>0)
            {
                out.write(bytes, 0, numReadByte);
            }

            out.flush();
            fileInputStream.close();
            //读取URLConnection的响应
            DataInputStream in=new DataInputStream(connection.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
