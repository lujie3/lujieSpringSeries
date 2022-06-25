package middlename.servlet.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/demo1","/demo2"})
public class ServletDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet() in the "+ServletDemo2.class.getName()+" is called");

        String nameParam = req.getParameter("name");

        resp.setHeader("content-type","text/html;charset=utf-8");
        resp.getWriter().write("<h1>"+nameParam+"欢迎你</h1>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost() in the "+ServletDemo2.class.getName()+" is called");
    }
}
