<%-- 
    Document   : user_add
    Created on : 16 лют 2014, 2:18:15
    Author     : spoilt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            request.setCharacterEncoding("UTF-8");
            org.ribbon.enteties.User addUser = new org.ribbon.enteties.User(request.getParameter("login"),
                    request.getParameter("description"), 
                    request.getParameter("passw"),
                    (request.getParameter("isadmin").equals("on") ? Boolean.TRUE : Boolean.FALSE), 
                    (request.getParameter("isenabled").equals("on") ? Boolean.TRUE : Boolean.FALSE));
            Boolean saved = org.ribbon.dao.mysql.MySqlDAOFactory.getNewInstance().getNewIDaoUserInstance().save(addUser);
        %>
        <% if(saved) {%>
            <h1>USER <%= addUser.getLogin() %> ADDED, ID = <%= addUser.getId() %></h1>
        <% } else { %>
            <h1>SAVING FAILD, SEE LOG</h1>
        <% }; %>
    </body>
</html>
