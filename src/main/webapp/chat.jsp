<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Chat Room</title>
</head>
<body>
    <h1>Welcome to the Chat Room</h1>
    <p>Online Users: ${applicationScope.onlineUsers}</p>
    <div>
        <h2>Chat History</h2>
        <ul>
            <%
                List<String> messages = (List<String>) application.getAttribute("messages");
                if (messages != null) {
                    for (String message : messages) {
                        out.println("<li>" + message + "</li>");
                    }
                }
            %>
        </ul>
    </div>
    <form action="chat" method="post">
        <input type="text" name="message" required>
        <input type="submit" value="Send">
    </form>
</body>
</html>
<%--231321--%>