<%-- 
    Document   : postform
    Created on : 11 бер 2014, 19:50:31
    Author     : Stanislav Nepochatov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>НОВЕ ПОВІДОМЛЕННЯ</title>
    </head>
    <body>
        <form action="/Ribbon?command=POST_MESG" method="POST">
            <input type="hidden" name="directory" value="Система.Тест">
            ЗАГОЛОВОК: <input type="text" name="header" size="75"><br/>
            ТЕРМІНОВО: <input type="checkbox" name="urgent"><br/>
            ТЕКСТ ПОВІДОМЛЕННЯ:<br/>
            <textarea name="body" cols="100" rows="15" maxlength="1000000"></textarea>
            <br/>
            <input type="submit" value="ДОДАТИ ПОВІДОМЛЕННЯ">
        </form>
    </body>
</html>
