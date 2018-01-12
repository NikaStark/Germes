<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.germes.web.util.Command" %>
<html>
    <head>
        <title>Index</title>
    </head>
    <body>
        <
        <form name="login_form" action="${Command.LOGIN_CMD.getCommand()}" method="post">
            <input type="submit" value="Login">
        </form>
    </body>
</html>
