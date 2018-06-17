<html>
    <head>
        <title>Tariffs</title>
    </head>
    <body>

        <%@include file="templates/header.jsp" %>

        <div class="container">
            <div class="row">
                <div class="col-md-2 col-lg-offset-5">
                    <form id="country" method="post" action="${Command.TARIFFS_CMD.getCommand()}">
                        <select class="form-control" name="${Attribute.COUNTRY_ATR.getAttribute()}" onchange="submit()"
                                form="country">
                            <c:if test="${empty param.get(Attribute.COUNTRY_ATR.getAttribute())}">
                                <option><fmt:message key="tariffs.label.chooseCountry"/></option>
                            </c:if>
                            <c:forEach var="country"
                                       items="${requestScope.get(Attribute.COUNTRIES_ATR.getAttribute())}">
                                <option value="${country.getName()}"
                                    ${param.get(Attribute.COUNTRY_ATR.getAttribute()) == country.getName() ? 'selected' : ''}>
                                    <c:out value="${country.getName()}"/>
                                </option>
                            </c:forEach>
                        </select>
                    </form>
                </div>


                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th><fmt:message key="tariffs.label.cityColumn"/></th>
                            <th><fmt:message key="tariffs.label.priceColumn"/></th>
                        </tr>
                    </thead>
                    <c:if test="${not empty requestScope.get(Attribute.CITIES_ATR.getAttribute())}">
                        <tbody>
                            <c:forEach var="city" items="${requestScope.get(Attribute.CITIES_ATR.getAttribute())}">
                                <tr>
                                    <th><c:out value="${city.getName()}"/></th>
                                    <th><c:out value="${city.getTariff()}"/></th>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </c:if>
                </table>

            </div>
        </div>

    </body>
</html>
