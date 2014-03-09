<%-- 
    Document   : listdir
    Created on : 9 бер 2014, 16:49:22
    Author     : Stanislav Nepochatov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>НАПРЯМКИ СИСТЕМИ</title>
    </head>
    <body>
        <c:forEach var="directory" items="${dirs}">
            ${directory.path} <br/>
        </c:forEach>
    </body>
</html>
