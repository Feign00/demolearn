package ch4;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/visitCounter")
public class VisitCounterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取ServletContext对象
        ServletContext context = getServletContext();

        // 获取当前的访问计数112233
        Integer visitCount = (Integer) context.getAttribute("visitCount");

        // 如果计数为空，初始化为0
        if (visitCount == null) {
            visitCount = 0;
        }

        // 计数加1
        visitCount++;

        // 将新的计数设置回ServletContext
        context.setAttribute("visitCount", visitCount);

        // 设置响应内容类型
        resp.setContentType("text/html");

        // 获取PrintWriter对象
        PrintWriter out = resp.getWriter();

        // 将访问计数写入响应体
        out.println("<html><body>");
        out.println("<h1>网站访问计数器</h1>");
        out.println("<p>当前访问次数: " + visitCount + "</p>");
        out.println("</body></html>");
    }
}