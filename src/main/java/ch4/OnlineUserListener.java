package ch4;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashSet;
import java.util.Set;

@WebListener
public class OnlineUserListener implements HttpSessionListener, ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        context.setAttribute("onlineUsers", new HashSet<String>());
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        ServletContext context = session.getServletContext();
        Set<String> onlineUsers = (Set<String>) context.getAttribute("onlineUsers");
        onlineUsers.add(session.getId());
        context.setAttribute("onlineUsers", onlineUsers);
    }
//456
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        ServletContext context = session.getServletContext();
        Set<String> onlineUsers = (Set<String>) context.getAttribute("onlineUsers");
        onlineUsers.remove(session.getId());
        context.setAttribute("onlineUsers", onlineUsers);
    }
}