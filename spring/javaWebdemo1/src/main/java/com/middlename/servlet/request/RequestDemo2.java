package middlename.servlet.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/req2")
public class RequestDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 测试三个同一取参数的方法
        // getParameterMap()    getParameterValues()       getParameter()

        System.out.println("============getParameterMap()============");
        // [1] 在所有参数集合Map中取参
        Map<String, String[]> parameterMap = req.getParameterMap();
        for(String key :parameterMap.keySet() ){
            System.out.print(key+":");

            for(String value:parameterMap.get(key)){
                System.out.print(value);
            }
            System.out.println();
        }

        System.out.println("============getParameterValues()============");
        // [2] 根据key取出参数 -- 数组
        String[] hobbies = req.getParameterValues("hobby");
        for(String hobby:hobbies){
            System.out.println(hobby);
        }

        System.out.println("============getParameter()============");
        // [3] 根据key取出参数 -- 单个值
        String username = req.getParameter("username");
        System.out.println(username);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
