<html>
    <head>
    </head>
    <body>

        <%--<form class="reg_ref" action="${Command.REG_PAGE_CMD.getCommand()}" method="post">--%>
        <%--<input type="submit" value=<fmt:message key="parcel.label.registrationButton"/>>--%>
        <%--</form>--%>

        <table class="table table-hover">
            <thead>
                <tr>
                    <th><fmt:message key="parcels.label.idColumn"/></th>
                    <th><fmt:message key="parcels.label.senderColumn"/></th>
                    <th><fmt:message key="parcels.label.receiverColumn"/></th>
                    <th><fmt:message key="parcels.label.branchSenderColumn"/></th>
                    <th><fmt:message key="parcels.label.branchReceiverColumn"/></th>
                    <th><fmt:message key="parcels.label.issueDateColumn"/></th>
                    <th><fmt:message key="parcels.label.statusColumn"/></th>
                    <th><fmt:message key="parcels.label.isPaidColumn"/></th>
                    <th><fmt:message key="parcels.label.priceTotalColumn"/></th>
                </tr>
            </thead>
            <c:forEach var="parcel" items="${requestScope.get(Attribute.PARCELS_ATR.getAttribute())}">
                <tbody>
                    <tr>
                        <th><c:out value="${parcel.getId()}"/></th>
                        <th><c:out value="${parcel.getSender()}"/></th>
                        <th><c:out value="${parcel.getReceiver()}"/></th>
                        <th><c:out value="${parcel.getBranchSender()}"/></th>
                        <th><c:out value="${parcel.getBranchReceiver()}"/></th>
                        <th><c:out value="${parcel.getIssueDate()}"/></th>
                        <th><c:out value="${parcel.getStatus()}"/></th>
                        <th><c:out value="${parcel.getIsPaid()}"/></th>
                        <th><c:out value="${parcel.getPriceTotal()}"/></th>
                    </tr>
                </tbody>
            </c:forEach>
        </table>

        <div class="btn-group btn-group-xs">
            <c:forEach var="page" items="${requestScope.get(Attribute.PAGES_ATR.getAttribute())}">
                <form class="btn btn-info" action="${Command.HOME_PAGE_CMD.getCommand()}" method="post">
                    <input type="hidden" name="${Attribute.NAVIGATION_FORM_ATR.getAttribute()}" value="parcelsForm"/>
                    <input type="hidden" name="${Attribute.PAGE_ATR.getAttribute()}" value="${page}"/>
                    <input type="submit" class="btn btn-link" value="${page}">
                </form>
            </c:forEach>
        </div>

    </body>
</html>
