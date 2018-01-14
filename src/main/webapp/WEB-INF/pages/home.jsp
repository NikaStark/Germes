<html>
    <head>
        <title>Home</title>
    </head>
    <body>

        <%@include file="templates/header.jsp" %>

        <h1>Hi</h1>

        ${sessionScope.get(Attribute.CURRENT_USER_ATR.getAttribute()).id}<br/>
        <%--${sessionScope.get(Attribute.CURRENT_USER_ATR.getAttribute()).(Attribute.USERNAME_ATR.getAttribute())}<br/>--%>
        ${sessionScope.Attribute.CURRENT_USER_ATR.getAttribute().Attribute.PASSWORD_ATR.getAttribute()}
        ${sessionScope.Attribute.CURRENT_USER_ATR.getAttribute().Attribute.EMAIL_ATR.getAttribute()}
        ${sessionScope.Attribute.CURRENT_USER_ATR.getAttribute().Attribute.FIRST_NAME_ATR.getAttribute()}<br/>
        ${sessionScope.Attribute.CURRENT_USER_ATR.getAttribute().Attribute.LAST_NAME_ATR.getAttribute()}<br/>
        ${sessionScope.Attribute.CURRENT_USER_ATR.getAttribute().role}<br/>

        <form class="logout_form" action="${Command.LOGOUT_CMD.getCommand()}" method="post">
            <input type="submit" value=<fmt:message key="home.label.logoutButton"/>>
        </form>

    </body>
</html>
