<html>
    <head>
        <title>Home</title>
    </head>
    <body>

        <%@include file="templates/header.jsp" %>

        <h1>Hi</h1>

        ${sessionScope.get(Attribute.CURRENT_USER_ATR.getAttribute()).id}<br/>

        <form class="profile_form" action="${Command.PROFILE_PAGE_CMD.getCommand()}" method="post">
            <input type="submit" value=<fmt:message key="home.label.profileButton"/>>
        </form>

    </body>
</html>
