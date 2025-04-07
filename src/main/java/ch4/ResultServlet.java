package ch4;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "ResultServlet", urlPatterns = "/result")
public class ResultServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        // 设置响应内容类型
        response.setContentType("text/html;charset=utf-8");
        // 从请求域中获取 username 属性
        String username = (String) request.getAttribute("username");
        // 检查 username 是否为 null
        if (username != null) {
            // 将 username 写入响应对象
            response.getWriter().println(username);
        } else {
            // 如果 username 为 null，返回默认提示
            response.getWriter().println("用户名未设置");
        }
    }
}