<html>
    <head>
    </head>
    <body>

        <%--<form class="reg_ref" action="${Command.REG_PAGE_CMD.getCommand()}" method="post">--%>
        <%--<input type="submit" value=<fmt:message key="branche.label.registrationButton"/>>--%>
        <%--</form>--%>

        <table>
            <tr>
                <th><fmt:message key="branches.label.idColumn"/></th>
                <th><fmt:message key="branches.label.cityColumn"/></th>
                <th><fmt:message key="branches.label.streetColumn"/></th>
                <th><fmt:message key="branches.label.streetNumberColumn"/></th>
            </tr>
            <c:forEach var="branch" items="${requestScope.get(Attribute.BRANCHES_ATR.getAttribute())}">
                <tr>
                    <th><c:out value="${branch.getId()}"/></th>
                    <th><c:out value="${branch.getCity()}"/></th>
                    <th><c:out value="${branch.getStreet()}"/></th>
                    <th><c:out value="${branch.getStreetNumber()}"/></th>
                </tr>
            </c:forEach>
        </table>
        
    </body>
</html>
