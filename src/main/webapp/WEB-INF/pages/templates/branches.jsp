<html>
    <head>
    </head>
    <body>

        <%--<form class="reg_ref" action="${Command.REG_PAGE_CMD.getCommand()}" method="post">--%>
        <%--<input type="submit" value=<fmt:message key="branche.label.registrationButton"/>>--%>
        <%--</form>--%>

        <table class="table table-hover">
            <thead>
                <tr>
                    <th><fmt:message key="branches.label.idColumn"/></th>
                    <th><fmt:message key="branches.label.cityColumn"/></th>
                    <th><fmt:message key="branches.label.streetColumn"/></th>
                    <th><fmt:message key="branches.label.streetNumberColumn"/></th>
                </tr>
            </thead>
            <c:forEach var="branch" items="${requestScope.get(Attribute.BRANCHES_ATR.getAttribute())}">
                <tbody>
                    <tr>
                        <th><c:out value="${branch.getId()}"/></th>
                        <th><c:out value="${branch.getCity()}"/></th>
                        <th><c:out value="${branch.getStreet()}"/></th>
                        <th><c:out value="${branch.getStreetNumber()}"/></th>
                    </tr>
                </tbody>
            </c:forEach>
        </table>

        <div class="btn-group btn-group-xs">
            <c:forEach var="page" items="${requestScope.get(Attribute.PAGES_ATR.getAttribute())}">
                <form class="btn btn-info" action="${Command.HOME_PAGE_CMD.getCommand()}" method="post">
                    <input type="hidden" name="${Attribute.NAVIGATION_FORM_ATR.getAttribute()}" value="branchesForm"/>
                    <input type="hidden" name="${Attribute.PAGE_ATR.getAttribute()}" value="${page}"/>
                    <input type="submit" class="btn btn-link" value="${page}">
                </form>
            </c:forEach>
        </div>

    </body>
</html>
