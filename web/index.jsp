<%-- 
    Document   : index
    Created on : 12 лют 2014, 12:16:50
    Author     : spoilt
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
        <form action="user_add.jsp" method="POST" name="user-add"> <br/>
            <b>ЛОГІН:</b> <input type="text" name="login" maxlength="125"> <br/>
            <b>ОПИС:</b> <input type="text" name="description" maxlength="150"> <br/>
            <b>ПАРОЛЬ:</b> <input type="password" name="passw"> <br/>
            <b>АДМІН:</b> <input type="checkbox" name="isadmin"> <br/>
            <b>УВІМКНЕНИЙ:</b> <input type="checkbox" name="isenabled" checked="checked"> <br/>
            <input type="submit" value="Додати користувача">
        </form>
        </div>
    </body>
</html>
