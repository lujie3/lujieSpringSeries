package middlename.servlet.request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Servletdemo1", value = "/req4")
public class Servletdemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("username");
        System.out.println(name);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("中文");
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("username");
        System.out.println(name);

    }

    public static void main(String[] args) {
        System.out.println("中翁");
    }
}
