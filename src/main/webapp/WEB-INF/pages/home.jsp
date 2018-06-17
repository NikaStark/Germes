<html>
    <head>
        <title>Home</title>
    </head>
    <body>

        <%@include file="templates/header.jsp" %>

        <div class="container">
            <div class="row">
                <div class="col-md-2">
                    <%@include file="templates/navigation.jsp" %>
                </div>
                <div class="col-md-10">
                    <h3>Hi <c:out value="${sessionScope.get(Attribute.CURRENT_USER_ATR.getAttribute()).firstName}"/>!</h3>

                    <c:choose>
                        <c:when test="${requestScope.get(Attribute.NAVIGATION_FORM_ATR.getAttribute()) == 'usersForm'}">
                            <%@include file="templates/users.jsp" %>
                        </c:when>
                        <c:when test="${requestScope.get(Attribute.NAVIGATION_FORM_ATR.getAttribute()) == 'branchesForm'}">
                            <%@include file="templates/branches.jsp" %>
                        </c:when>
                        <c:when test="${requestScope.get(Attribute.NAVIGATION_FORM_ATR.getAttribute()) == 'citiesForm'}">
                            <%@include file="templates/cities.jsp" %>
                        </c:when>
                        <c:when test="${requestScope.get(Attribute.NAVIGATION_FORM_ATR.getAttribute()) == 'countriesForm'}">
                            <%@include file="templates/countries.jsp" %>
                        </c:when>
                        <c:when test="${requestScope.get(Attribute.NAVIGATION_FORM_ATR.getAttribute()) == 'parcelsForm'}">
                            <%@include file="templates/parcels.jsp" %>
                        </c:when>
                        <c:when test="${requestScope.get(Attribute.NAVIGATION_FORM_ATR.getAttribute()) == 'goodsForm'}">
                            <%@include file="templates/goods.jsp" %>
                        </c:when>
                        <c:when test="${requestScope.get(Attribute.NAVIGATION_FORM_ATR.getAttribute()) == 'deliveriesForm'}">
                            <%@include file="templates/deliveries.jsp" %>
                        </c:when>
                    </c:choose>
                </div>
            </div>
        </div>

    </body>
</html>
