<html>
    <head>
    </head>
    <body>

        <form class="pull-right" action="${Command.REG_PAGE_CMD.getCommand()}" method="post">
            <input type="submit" class="btn btn-primary" value=<fmt:message key="users.label.registrationButton"/>>
        </form>

        <table class="table table-hover">
            <thead>
                <tr>
                    <th><fmt:message key="users.label.idColumn"/></th>
                    <th><fmt:message key="users.label.usernameColumn"/></th>
                    <th><fmt:message key="users.label.passwordColumn"/></th>
                    <th><fmt:message key="users.label.emailColumn"/></th>
                    <th><fmt:message key="users.label.firstNameColumn"/></th>
                    <th><fmt:message key="users.label.lastNameColumn"/></th>
                    <th><fmt:message key="users.label.roleColumn"/></th>
                </tr>
            </thead>
            <c:forEach var="user" items="${requestScope.get(Attribute.USERS_ATR.getAttribute())}">
                <tbody>
                    <tr>
                        <th><c:out value="${user.getId()}"/></th>
                        <th><c:out value="${user.getUsername()}"/></th>
                        <th><c:out value="${user.getPassword()}"/></th>
                        <th><c:out value="${user.getEmail()}"/></th>
                        <th><c:out value="${user.getFirstName()}"/></th>
                        <th><c:out value="${user.getLastName()}"/></th>
                        <th><c:out value="${user.getRole()}"/></th>
                    </tr>
                </tbody>
            </c:forEach>
        </table>

        <div class="btn-group btn-group-xs">
            <c:forEach var="page" items="${requestScope.get(Attribute.PAGES_ATR.getAttribute())}">
                    <form class="btn btn-info" action="${Command.HOME_PAGE_CMD.getCommand()}" method="post">
                        <input type="hidden" name="${Attribute.NAVIGATION_FORM_ATR.getAttribute()}" value="usersForm"/>
                        <input type="hidden" name="${Attribute.PAGE_ATR.getAttribute()}" value="${page}"/>
                        <input type="submit" class="btn btn-link" value="${page}"/>
                    </form>
            </c:forEach>
        </div>


    </body>
</html>
