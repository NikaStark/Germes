<html>
    <head>
    </head>
    <body>

        <%--<form class="reg_ref" action="${Command.REG_PAGE_CMD.getCommand()}" method="post">--%>
        <%--<input type="submit" value=<fmt:message key="branche.label.registrationButton"/>>--%>
        <%--</form>--%>

        <table>
            <tr>
                <th><fmt:message key="countries.label.idColumn"/></th>
                <th><fmt:message key="countries.label.nameColumn"/></th>
                <th><fmt:message key="countries.label.tariffColumn"/></th>
            </tr>
            <c:forEach var="country" items="${requestScope.get(Attribute.COUNTRIES_ATR.getAttribute())}">
                <tr>
                    <th><c:out value="${country.getId()}"/></th>
                    <th><c:out value="${country.getName()}"/></th>
                    <th><c:out value="${country.getTariff()}"/></th>
                </tr>
            </c:forEach>
        </table>

    </body>
</html>
