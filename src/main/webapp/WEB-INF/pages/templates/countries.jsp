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
                    <th><fmt:message key="countries.label.idColumn"/></th>
                    <th><fmt:message key="countries.label.nameColumn"/></th>
                    <th><fmt:message key="countries.label.tariffColumn"/></th>
                </tr>
            </thead>
            <c:forEach var="country" items="${requestScope.get(Attribute.COUNTRIES_ATR.getAttribute())}">
                <tbody>
                    <tr>
                        <th><c:out value="${country.getId()}"/></th>
                        <th><c:out value="${country.getName()}"/></th>
                        <th><c:out value="${country.getTariff()}"/></th>
                    </tr>
                </tbody>
            </c:forEach>
        </table>

        <div class="btn-group btn-group-xs">
            <c:forEach var="page" items="${requestScope.get(Attribute.PAGES_ATR.getAttribute())}">
                <form class="btn btn-info" action="${Command.HOME_PAGE_CMD.getCommand()}" method="post">
                    <input type="hidden" name="${Attribute.NAVIGATION_FORM_ATR.getAttribute()}" value="countriesForm"/>
                    <input type="hidden" name="${Attribute.PAGE_ATR.getAttribute()}" value="${page}"/>
                    <input type="submit" class="btn btn-link" value="${page}">
                </form>
            </c:forEach>
        </div>

    </body>
</html>
