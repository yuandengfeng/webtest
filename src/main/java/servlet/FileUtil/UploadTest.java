package servlet.FileUtil;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by yuandengfeng on 2016/10/17.
 */
public class UploadTest {


    public UploadTest(){
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

        String str="http://localhost:8080//UploadServlet";
        String filePath="G:\\坤腾\\超汇VIPLog接口\\cc\\viplog-2016-10-11-14.zip";
        String fileName="viplog-2016-10-11-14.zip";
        try {
            URL url=new URL(str);
            HttpURLConnection connection=(HttpURLConnection)url.openConnection();
            connection.setDoInput(true);    // 使用 URL 连接进行输入
            connection.setDoOutput(true);  // 使用 URL 连接进行输出
            connection.setRequestMethod("POST");
            connection.addRequestProperty("Fname", fileName);

            // connection.setRequestProperty("Content-Type","text/xml; charset=UTF-8");
            // connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
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
