<html>
    <head>
    </head>
    <body>

        <%--<form class="reg_ref" action="${Command.REG_PAGE_CMD.getCommand()}" method="post">--%>
        <%--<input type="submit" value=<fmt:message key="citye.label.registrationButton"/>>--%>
        <%--</form>--%>

        <table>
            <tr>
                <th><fmt:message key="cities.label.idColumn"/></th>
                <th><fmt:message key="cities.label.countryColumn"/></th>
                <th><fmt:message key="cities.label.nameColumn"/></th>
                <th><fmt:message key="cities.label.latitudeColumn"/></th>
                <th><fmt:message key="cities.label.longitudeColumn"/></th>
                <th><fmt:message key="cities.label.tariffColumn"/></th>
            </tr>
            <c:forEach var="city" items="${requestScope.get(Attribute.CITIES_ATR.getAttribute())}">
                <tr>
                    <th><c:out value="${city.getId()}"/></th>
                    <th><c:out value="${city.getCountry()}"/></th>
                    <th><c:out value="${city.getName()}"/></th>
                    <th><c:out value="${city.getLatitude()}"/></th>
                    <th><c:out value="${city.getLongitude()}"/></th>
                    <th><c:out value="${city.getTariff()}"/></th>
                </tr>
            </c:forEach>
        </table>

    </body>
</html>
