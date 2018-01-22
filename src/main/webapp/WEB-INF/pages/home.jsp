<html>
    <head>
        <title>Home</title>
    </head>
    <body>

        <%@include file="templates/header.jsp" %>

        <%@include file="templates/navigation.jsp" %>

        <h1>Hi</h1>

        ${sessionScope.get(Attribute.CURRENT_USER_ATR.getAttribute()).id}<br/>

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

    </body>
</html>
