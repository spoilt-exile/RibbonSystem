<%-- 
    Document   : listmesg
    Created on : 9 бер 2014, 23:02:18
    Author     : spoilt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ПОВІДОМЛЕННЯ</title>
    </head>
    <body>
        <table width="100%" border="1px">
            <tr>
                <td>Заголовок</td>
                <td>Дата випуску</td>
                <td>Дії</td>
            </tr>
            <c:forEach var="message" items="${mlist}">
                <tr>
                    <td>${message.header}</td>
                    <td>${message.postDate}</td>
                    <td>[ПЕРЕГЛЯНУТИ] [РЕДАГУВАТИ] [ВИДАЛИТИ]</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
