<html>
    <head>
    </head>
    <body>

        <%--<form class="reg_ref" action="${Command.REG_PAGE_CMD.getCommand()}" method="post">--%>
        <%--<input type="submit" value=<fmt:message key="citye.label.registrationButton"/>>--%>
        <%--</form>--%>

        <table class="table table-hover">
            <thead>
                <tr>
                    <th><fmt:message key="cities.label.idColumn"/></th>
                    <th><fmt:message key="cities.label.countryColumn"/></th>
                    <th><fmt:message key="cities.label.nameColumn"/></th>
                    <th><fmt:message key="cities.label.latitudeColumn"/></th>
                    <th><fmt:message key="cities.label.longitudeColumn"/></th>
                    <th><fmt:message key="cities.label.tariffColumn"/></th>
                </tr>
            </thead>
            <c:forEach var="city" items="${requestScope.get(Attribute.CITIES_ATR.getAttribute())}">
                <tbody>
                    <tr>
                        <th><c:out value="${city.getId()}"/></th>
                        <th><c:out value="${city.getCountry()}"/></th>
                        <th><c:out value="${city.getName()}"/></th>
                        <th><c:out value="${city.getLatitude()}"/></th>
                        <th><c:out value="${city.getLongitude()}"/></th>
                        <th><c:out value="${city.getTariff()}"/></th>
                    </tr>
                </tbody>
            </c:forEach>
        </table>

        <div class="btn-group btn-group-xs">
            <c:forEach var="page" items="${requestScope.get(Attribute.PAGES_ATR.getAttribute())}">
                <form class="btn btn-info" action="${Command.HOME_PAGE_CMD.getCommand()}" method="post">
                    <input type="hidden" name="${Attribute.NAVIGATION_FORM_ATR.getAttribute()}" value="citiesForm"/>
                    <input type="hidden" name="${Attribute.PAGE_ATR.getAttribute()}" value="${page}"/>
                    <input type="submit" class="btn btn-link" value="${page}">
                </form>
            </c:forEach>
        </div>

    </body>
</html>
