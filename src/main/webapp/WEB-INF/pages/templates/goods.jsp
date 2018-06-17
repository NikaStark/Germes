<html>
    <head>
    </head>
    <body>

        <table class="table table-hover">
            <thead>
                <tr>
                    <th><fmt:message key="goods.label.idColumn"/></th>
                    <th><fmt:message key="goods.label.parcelColumn"/></th>
                    <th><fmt:message key="goods.label.weightColumn"/></th>
                    <th><fmt:message key="goods.label.lengthColumn"/></th>
                    <th><fmt:message key="goods.label.widthColumn"/></th>
                    <th><fmt:message key="goods.label.heightColumn"/></th>
                    <th><fmt:message key="goods.label.assessedValueColumn"/></th>
                </tr>
            </thead>
            <c:forEach var="goods" items="${requestScope.get(Attribute.GOODS_ATR.getAttribute())}">
                <tbody>
                    <tr>
                        <th><c:out value="${goods.getId()}"/></th>
                        <th><c:out value="${goods.getParcel()}"/></th>
                        <th><c:out value="${goods.getWeight()}"/></th>
                        <th><c:out value="${goods.getLength()}"/></th>
                        <th><c:out value="${goods.getWidth()}"/></th>
                        <th><c:out value="${goods.getHeight()}"/></th>
                        <th><c:out value="${goods.getAssessedValue()}"/></th>
                    </tr>
                </tbody>
            </c:forEach>
        </table>

        <div class="btn-group btn-group-xs">
            <c:forEach var="page" items="${requestScope.get(Attribute.PAGES_ATR.getAttribute())}">
                <form class="btn btn-info" action="${Command.HOME_PAGE_CMD.getCommand()}" method="post">
                    <input type="hidden" name="${Attribute.NAVIGATION_FORM_ATR.getAttribute()}" value="goodsForm"/>
                    <input type="hidden" name="${Attribute.PAGE_ATR.getAttribute()}" value="${page}"/>
                    <input type="submit" class="btn btn-link" value="${page}">
                </form>
            </c:forEach>
        </div>

    </body>
</html>
