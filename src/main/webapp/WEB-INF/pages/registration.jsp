<html>
    <head>
        <title>Registration</title>
    </head>
    <body>

        <%@include file="templates/header.jsp" %>

        <form class="form-signin-reg" action="${Command.REG_CMD.getCommand()}" method="post">

            <fmt:message key="registration.label.username"/> <br/>
            <input type="text" class="form-control input-lg" name="${Attribute.USERNAME_ATR.getAttribute()}" required/> <br/>

            <fmt:message key="registration.label.password"/> <br/>
            <input type="password" class="form-control input-lg" name="${Attribute.PASSWORD_ATR.getAttribute()}" required/> <br/>

            <fmt:message key="registration.label.passwordRepeat"/> <br/>
            <input type="password" class="form-control input-lg" name="${Attribute.PASSWORD_REPEAT_ATR.getAttribute()}" required/> <br/>

            <fmt:message key="registration.label.email"/> <br/>
            <input type="text" class="form-control input-lg" name="${Attribute.EMAIL_ATR.getAttribute()}" required/> <br/>

            <fmt:message key="registration.label.firstName"/> <br/>
            <input type="text" class="form-control input-lg" name="${Attribute.FIRST_NAME_ATR.getAttribute()}" required/> <br/>

            <fmt:message key="registration.label.lastName"/> <br/>
            <input type="text" class="form-control input-lg" name="${Attribute.LAST_NAME_ATR.getAttribute()}" required/> <br/>

            <input type="submit" value=<fmt:message key="registration.label.submitButton"/>>
        </form>

    </body>
</html>
