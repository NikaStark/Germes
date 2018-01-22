<html>
    <head>
    </head>
    <body>

        <form class="reg_ref" action="${Command.REG_PAGE_CMD.getCommand()}" method="post">
            <input type="submit" value=<fmt:message key="users.label.registrationButton"/>>
        </form>

        <table>
            <tr>
                <th><fmt:message key="users.label.idColumn"/></th>
                <th><fmt:message key="users.label.usernameColumn"/></th>
                <th><fmt:message key="users.label.passwordColumn"/></th>
                <th><fmt:message key="users.label.emailColumn"/></th>
                <th><fmt:message key="users.label.firstNameColumn"/></th>
                <th><fmt:message key="users.label.lastNameColumn"/></th>
                <th><fmt:message key="users.label.roleColumn"/></th>
            </tr>
            <c:forEach var="user" items="${requestScope.get(Attribute.USERS_ATR.getAttribute())}">
                <tr>
                    <th><c:out value="${user.getId()}"/></th>
                    <th><c:out value="${user.getUsername()}"/></th>
                    <th><c:out value="${user.getPassword()}"/></th>
                    <th><c:out value="${user.getEmail()}"/></th>
                    <th><c:out value="${user.getFirstName()}"/></th>
                    <th><c:out value="${user.getLastName()}"/></th>
                    <th><c:out value="${user.getRole()}"/></th>
                </tr>
            </c:forEach>
        </table>
        
    </body>
</html>
