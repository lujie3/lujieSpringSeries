package middlename.servlet.response;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ResponseDemo1", value = "/resp1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 重定向的两种方式
        /*
        * [1] response.setStatus(302);  response.setHeader("Location","Servlet的路径要项目的虚拟路径");
        * [2] response.sendRedirect("Servlet的虚拟路径")
        * */
        System.out.println("================"+ResponseDemo1.class.getName()+"================");
        String contextPath = request.getContextPath();

        //response.setStatus(302);    response.setHeader("Location","/javaWebdemo1_war/resp2");
        response.sendRedirect(contextPath+"/resp2");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
