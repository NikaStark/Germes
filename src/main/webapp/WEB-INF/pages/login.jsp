<html>
    <head>
        <title>Login</title>
    </head>

    <body>

        <%@include file="templates/header.jsp" %>

        <form class="login_form" action="${Command.AUTH_CMD.getCommand()}" method="post">

            <fmt:message key="login.label.username"/>: <br/>
            <input type="text" name="${Attribute.USERNAME_ATR.getAttribute()}" value="" required/><br/>

            <fmt:message key="login.label.password"/>: <br/>
            <input type="password" name="${Attribute.PASSWORD_ATR.getAttribute()}" value="" required/><br/>

            <input type="submit" value=<fmt:message key="login.label.submitButton"/>>
        </form>

        <form class="reg_ref" action="${Command.REG_PAGE_CMD.getCommand()}" method="post">
            <input type="submit" value=<fmt:message key="login.label.registrationButton"/>>
        </form>

    </body>
</html>
