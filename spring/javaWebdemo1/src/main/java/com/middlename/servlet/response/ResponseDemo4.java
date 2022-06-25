package middlename.servlet.response;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import org.apache.commons.io.IOUtils;


@WebServlet(name = "ResponseDemo4", value = "/resp4")
public class ResponseDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        * 字节数据
        * 读取文件 -- 获取response字节输出流 -- 完成流的copy
        * 两种流的copy 1自己用循环写  2 使用第三方工具类
        * */

        FileInputStream fileInputStream = new FileInputStream("d://1.jpg");
        FileInputStream fileInputStream2 = new FileInputStream("d://2.jpg");
        ServletOutputStream outputStream = response.getOutputStream();

//        write1(fileInputStream,outputStream);
        write2(fileInputStream2,outputStream);

    }

    public void write1(FileInputStream fileInputStream,ServletOutputStream outputStream) throws IOException {
        byte[] buff = new byte[1024];
        int len=0;
        while((len=fileInputStream.read(buff))!=-1){
            outputStream.write(buff,0,len);
        }
    }

    public void write2(FileInputStream fileInputStream,ServletOutputStream outputStream) throws IOException {
        IOUtils.copy(fileInputStream,outputStream);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
