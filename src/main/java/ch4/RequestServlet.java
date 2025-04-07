package ch4;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "RequestServlet", urlPatterns = "/forward")
public class RequestServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        // 设置请求域中的属性
        request.setAttribute("username", "离着");
        // 将请求转发到 ResultServlet
        request.getRequestDispatcher("/result").forward(request, response);
    }
}