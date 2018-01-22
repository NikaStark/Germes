<html>
    <head>
    </head>
    <body>

        <c:if test="${sessionScope.get(Attribute.CURRENT_USER_ATR.getAttribute()).getRole() == Role.ADMIN}">
            <form class="users_form" action="${Command.HOME_PAGE_CMD.getCommand()}" method="post">
                <input type="hidden" name="${Attribute.NAVIGATION_FORM_ATR.getAttribute()}" value="usersForm"/>
                <input type="submit" value=<fmt:message key="navigation.label.usersButton"/>>
            </form>

            <form class="branches_form" action="${Command.HOME_PAGE_CMD.getCommand()}" method="post">
                <input type="hidden" name="${Attribute.NAVIGATION_FORM_ATR.getAttribute()}" value="branchesForm"/>
                <input type="submit" value=<fmt:message key="navigation.label.branchesButton"/>>
            </form>

            <form class="cities_form" action="${Command.HOME_PAGE_CMD.getCommand()}" method="post">
                <input type="hidden" name="${Attribute.NAVIGATION_FORM_ATR.getAttribute()}" value="citiesForm"/>
                <input type="submit" value=<fmt:message key="navigation.label.citiesButton"/>>
            </form>

            <form class="countries_form" action="${Command.HOME_PAGE_CMD.getCommand()}" method="post">
                <input type="hidden" name="${Attribute.NAVIGATION_FORM_ATR.getAttribute()}" value="countriesForm"/>
                <input type="submit" value=<fmt:message key="navigation.label.countriesButton"/>>
            </form>
        </c:if>

        <form class="parcels_form" action="${Command.HOME_PAGE_CMD.getCommand()}" method="post">
            <input type="hidden" name="${Attribute.NAVIGATION_FORM_ATR.getAttribute()}" value="parcelsForm"/>
            <input type="submit" value=<fmt:message key="navigation.label.parcelsButton"/>>
        </form>

        <form class="cargo_form" action="${Command.HOME_PAGE_CMD.getCommand()}" method="post">
            <input type="hidden" name="${Attribute.NAVIGATION_FORM_ATR.getAttribute()}" value="goodsForm"/>
            <input type="submit" value=<fmt:message key="navigation.label.goodsButton"/>>
        </form>

        <form class="deliveries_form" action="${Command.HOME_PAGE_CMD.getCommand()}" method="post">
            <input type="hidden" name="${Attribute.NAVIGATION_FORM_ATR.getAttribute()}" value="deliveriesForm"/>
            <input type="submit" value=<fmt:message key="navigation.label.deliveriesButton"/>>
        </form>

    </body>
</html>
