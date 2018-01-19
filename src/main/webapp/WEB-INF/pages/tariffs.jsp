<html>
    <head>
        <title>Tariffs</title>
    </head>
    <body>

        <%@include file="templates/header.jsp" %>

        <form id="country" class="navbar-search pull-right" method="post" action="${Command.TARIFFS_CMD.getCommand()}">
            <select class="form-control" name="${Attribute.COUNTRY_ATR.getAttribute()}" onchange="submit()"
                    form="country">
                <c:if test="${empty param.get(Attribute.COUNTRY_ATR.getAttribute())}">
                    <option><fmt:message key="tariffs.label.chooseCountry"/></option>
                </c:if>
                <c:forEach var="country" items="${requestScope.get(Attribute.COUNTRIES_ATR.getAttribute())}">
                    <option value="${country.getName()}"
                        ${param.get(Attribute.COUNTRY_ATR.getAttribute()) == country.getName() ? 'selected' : ''}>
                        <c:out value="${country.getName()}"/>
                    </option>
                </c:forEach>
            </select>
        </form>

        <c:if test="${not empty requestScope.get(Attribute.CITIES_ATR.getAttribute())}">
            <table>
                <tr>
                    <th><fmt:message key="tariffs.label.cityColumn"/></th>
                    <th><fmt:message key="tariffs.label.priceColumn"/></th>
                </tr>
                <c:forEach var="city" items="${requestScope.get(Attribute.CITIES_ATR.getAttribute())}">
                    <tr>
                        <th><c:out value="${city.getName()}"/></th>
                        <th><c:out value="${city.getTariff()}"/></th>
                    </tr>
                </c:forEach>
            </table>
        </c:if>

    </body>
</html>
