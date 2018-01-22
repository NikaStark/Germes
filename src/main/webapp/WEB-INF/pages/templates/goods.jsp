<html>
    <head>
    </head>
    <body>

        <table>
            <tr>
                <th><fmt:message key="goods.label.idColumn"/></th>
                <th><fmt:message key="goods.label.parcelColumn"/></th>
                <th><fmt:message key="goods.label.weightColumn"/></th>
                <th><fmt:message key="goods.label.lengthColumn"/></th>
                <th><fmt:message key="goods.label.widthColumn"/></th>
                <th><fmt:message key="goods.label.heightColumn"/></th>
                <th><fmt:message key="goods.label.assessedValueColumn"/></th>
            </tr>
            <c:forEach var="goods" items="${requestScope.get(Attribute.GOODS_ATR.getAttribute())}">
                <tr>
                    <th><c:out value="${goods.getId()}"/></th>
                    <th><c:out value="${goods.getParcel()}"/></th>
                    <th><c:out value="${goods.getWeight()}"/></th>
                    <th><c:out value="${goods.getLength()}"/></th>
                    <th><c:out value="${goods.getWidth()}"/></th>
                    <th><c:out value="${goods.getHeight()}"/></th>
                    <th><c:out value="${goods.getAssessedValue()}"/></th>
                </tr>
            </c:forEach>
        </table>

    </body>
</html>
