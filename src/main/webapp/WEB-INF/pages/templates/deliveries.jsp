<html>
    <head>
    </head>
    <body>

        <table>
            <tr>
                <th><fmt:message key="deliveries.label.idColumn"/></th>
                <th><fmt:message key="deliveries.label.parcelColumn"/></th>
                <th><fmt:message key="deliveries.label.isDeliveredColumn"/></th>
                <th><fmt:message key="deliveries.label.cityColumn"/></th>
                <th><fmt:message key="deliveries.label.streetColumn"/></th>
                <th><fmt:message key="deliveries.label.StreetNumberColumn"/></th>
            </tr>
            <c:forEach var="delivery" items="${requestScope.get(Attribute.DELIVERIES_ATR.getAttribute())}">
                <tr>
                    <th><c:out value="${delivery.getId()}"/></th>
                    <th><c:out value="${delivery.getParcel()}"/></th>
                    <th><c:out value="${delivery.getIsDelivered()}"/></th>
                    <th><c:out value="${delivery.getCity()}"/></th>
                    <th><c:out value="${delivery.getStreet()}"/></th>
                    <th><c:out value="${delivery.getStreetNumber()}"/></th>
                </tr>
            </c:forEach>
        </table>

    </body>
</html>
