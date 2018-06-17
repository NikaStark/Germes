<html>
    <head>
    </head>
    <body>

        <table class="table table-hover">
            <thead>
                <tr>
                    <th><fmt:message key="deliveries.label.idColumn"/></th>
                    <th><fmt:message key="deliveries.label.parcelColumn"/></th>
                    <th><fmt:message key="deliveries.label.isDeliveredColumn"/></th>
                    <th><fmt:message key="deliveries.label.cityColumn"/></th>
                    <th><fmt:message key="deliveries.label.streetColumn"/></th>
                    <th><fmt:message key="deliveries.label.StreetNumberColumn"/></th>
                </tr>
            </thead>
            <c:forEach var="delivery" items="${requestScope.get(Attribute.DELIVERIES_ATR.getAttribute())}">
                <tbody>
                    <tr>
                        <th><c:out value="${delivery.getId()}"/></th>
                        <th><c:out value="${delivery.getParcel()}"/></th>
                        <th><c:out value="${delivery.getIsDelivered()}"/></th>
                        <th><c:out value="${delivery.getCity()}"/></th>
                        <th><c:out value="${delivery.getStreet()}"/></th>
                        <th><c:out value="${delivery.getStreetNumber()}"/></th>
                    </tr>
                </tbody>
            </c:forEach>
        </table>

        <div class="btn-group btn-group-xs">
            <c:forEach var="page" items="${requestScope.get(Attribute.PAGES_ATR.getAttribute())}">
                <form class="btn btn-info" action="${Command.HOME_PAGE_CMD.getCommand()}" method="post">
                    <input type="hidden" name="${Attribute.NAVIGATION_FORM_ATR.getAttribute()}" value="deliveriesForm"/>
                    <input type="hidden" name="${Attribute.PAGE_ATR.getAttribute()}" value="${page}"/>
                    <input type="submit" class="btn btn-link" value="${page}">
                </form>
            </c:forEach>
        </div>

    </body>
</html>
