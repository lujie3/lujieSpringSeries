package middlename.servlet.request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RequestDemo6", value = "/req6")
public class RequestDemo6 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("===================="+RequestDemo6.class.getName()+"====================");
        Object check_flag = request.getAttribute("check_flag");
        System.out.println(check_flag);
        System.out.println("================="+RequestDemo6.class.getName()+"-end===================");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
