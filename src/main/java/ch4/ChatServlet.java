package ch4;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/chat")
public class ChatServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String message = request.getParameter("message");

        ServletContext context = getServletContext();
        List<String> messages = (List<String>) context.getAttribute("messages");
        if (messages == null) {
            messages = new ArrayList<>();
        }
        messages.add(username + ": " + message);
        context.setAttribute("messages", messages);

        response.sendRedirect("chat.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("chat.jsp");
    }
}