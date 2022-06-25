package middlename.servlet.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RequestDemo5", value = "/req5")
public class RequestDemo5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 请求转发 request.getRequestDispatcher(path).forward(request,response)
        // 转发资源间共享数据
        /*
        * setAttribute(String key,Object object)    存储数据到request域中
        * getAttribute(String name)     根据key,获取值
        * removeAttribute(String name)  根据key删除该键值对
        * */
        System.out.println("===================="+RequestDemo5.class.getName()+"====================");
        request.setAttribute("check_flag",true);
        request.getRequestDispatcher("/req6").forward(request,response);
        System.out.println("================"+RequestDemo5.class.getName()+"-end====================");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
