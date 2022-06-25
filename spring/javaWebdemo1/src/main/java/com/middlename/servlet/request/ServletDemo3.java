package middlename.servlet.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/req1")
public class ServletDemo3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // testcase
        String method;
        String contextPath;
        StringBuffer url;
        String uri;
        String queryString;
        String agent;

        method = req.getMethod();               // 请求方法
        contextPath = req.getContextPath();     // 获取虚拟目录
        url = req.getRequestURL();              // 获取URL
        uri = req.getRequestURI();              // 获取URI
        queryString = req.getQueryString();     // 获取请求参数(GET方式)
        agent = req.getHeader("user-agent"); // 获取请求头中 user-agent 浏览器的版本信息

        System.out.println(method);
        System.out.println(contextPath);
        System.out.println(url);
        System.out.println(uri);
        System.out.println(queryString);
        System.out.println(agent);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 功能: 获取post 请求体: 请求参数
        // 获取字符输入流 -- 读取数据
        //[1]
        BufferedReader br = req.getReader();
        //[2]
        String line = br.readLine();
        System.out.println(line);

    }
}
