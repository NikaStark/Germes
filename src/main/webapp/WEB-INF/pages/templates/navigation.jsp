<html>
    <head>
    </head>
    <body>

        <div class="btn-group-vertical ">

            <c:if test="${sessionScope.get(Attribute.CURRENT_USER_ATR.getAttribute()).getRole() == Role.ADMIN}">
                <form class="btn btn-default" action="${Command.HOME_PAGE_CMD.getCommand()}" method="post">
                    <input type="hidden" name="${Attribute.NAVIGATION_FORM_ATR.getAttribute()}" value="usersForm"/>
                    <input type="hidden" name="${Attribute.PAGE_ATR.getAttribute()}" value="1"/>
                    <input type="submit" class="btn btn-default" value=<fmt:message key="navigation.label.usersButton"/>>
                </form>

                <form class="btn btn-default" action="${Command.HOME_PAGE_CMD.getCommand()}" method="post">
                    <input type="hidden" name="${Attribute.NAVIGATION_FORM_ATR.getAttribute()}" value="branchesForm"/>
                    <input type="hidden" name="${Attribute.PAGE_ATR.getAttribute()}" value="1"/>
                    <input type="submit" class="btn btn-default" value=<fmt:message key="navigation.label.branchesButton"/>>
                </form>

                <form class="btn btn-default" action="${Command.HOME_PAGE_CMD.getCommand()}" method="post">
                    <input type="hidden" name="${Attribute.NAVIGATION_FORM_ATR.getAttribute()}" value="citiesForm"/>
                    <input type="hidden" name="${Attribute.PAGE_ATR.getAttribute()}" value="1"/>
                    <input type="submit" class="btn btn-default" value=<fmt:message key="navigation.label.citiesButton"/>>
                </form>

                <form class="btn btn-default" action="${Command.HOME_PAGE_CMD.getCommand()}" method="post">
                    <input type="hidden" name="${Attribute.NAVIGATION_FORM_ATR.getAttribute()}" value="countriesForm"/>
                    <input type="hidden" name="${Attribute.PAGE_ATR.getAttribute()}" value="1"/>
                    <input type="submit" class="btn btn-default" value=<fmt:message key="navigation.label.countriesButton"/>>
                </form>
            </c:if>

            <form class="btn btn-default" action="${Command.HOME_PAGE_CMD.getCommand()}" method="post">
                <input type="hidden" name="${Attribute.NAVIGATION_FORM_ATR.getAttribute()}" value="parcelsForm"/>
                <input type="hidden" name="${Attribute.PAGE_ATR.getAttribute()}" value="1"/>
                <input type="submit" class="btn btn-default" value=<fmt:message key="navigation.label.parcelsButton"/>>
            </form>

            <form class="btn btn-default" action="${Command.HOME_PAGE_CMD.getCommand()}" method="post">
                <input type="hidden" name="${Attribute.NAVIGATION_FORM_ATR.getAttribute()}" value="goodsForm"/>
                <input type="hidden" name="${Attribute.PAGE_ATR.getAttribute()}" value="1"/>
                <input type="submit" class="btn btn-default" value=<fmt:message key="navigation.label.goodsButton"/>>
            </form>

            <form class="btn btn-default" action="${Command.HOME_PAGE_CMD.getCommand()}" method="post">
                <input type="hidden" name="${Attribute.NAVIGATION_FORM_ATR.getAttribute()}" value="deliveriesForm"/>
                <input type="hidden" name="${Attribute.PAGE_ATR.getAttribute()}" value="1"/>
                <input type="submit" class="btn btn-default" value=<fmt:message key="navigation.label.deliveriesButton"/>>
            </form>

        </div>

    </body>
</html>
