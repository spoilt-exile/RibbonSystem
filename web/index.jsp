<%-- 
    Document   : index
    Created on : 12 лют 2014, 12:16:50
    Author     : Stanislav Nepochatov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Система обробки повідомлень "СТРІЧКА"</title>
    </head>
    <body>
        <div align="center">
        <form action="/Ribbon" method="POST" name="user-add"> <br/>
            <input type="hidden" name="command" value="LOGIN">
            <b>ЛОГІН:</b> <input type="text" name="login" maxlength="125"> <br/>
            <b>ПАРОЛЬ:</b> <input type="password" name="passw"> <br/>
            <input type="submit" value="Увійти до системи">
        </form>
        </div>
    </body>
</html>
