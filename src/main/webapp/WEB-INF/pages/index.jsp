<html>
    <head>
        <title>Index</title>
    </head>
    <body>

        <%@include file="templates/header.jsp" %>

        <form name="login_form" action="${Command.LOGIN_CMD.getCommand()}" method="post">
            <input type="submit" value="Login">
        </form>
    </body>
</html>
