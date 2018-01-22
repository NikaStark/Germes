<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.germes.web.util.Command" %>
<%@ page import="com.germes.web.util.Attribute" %>
<%@ page import="com.germes.model.entities.enums.Role" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
        <c:set var="language"
               value="${empty param.language ? (empty sessionScope.language ? 'en' : sessionScope.language) : param.language }"
               scope="session"/>
        <fmt:setLocale value="${sessionScope.language}"/>
        <fmt:setBundle basename="bundles\bundle"/>
    </head>

    <body>

        <form class="tariffs_form" action="${Command.TARIFFS_CMD.getCommand()}" method="post">
            <input type="submit" value=<fmt:message key="header.label.tariffsButton"/>>
        </form>

        <c:if test="${sessionScope.get(Attribute.CURRENT_USER_ATR.getAttribute()).role != Role.GUEST}">
            <form class="profile_form" action="${Command.PROFILE_PAGE_CMD.getCommand()}" method="post">
                <input type="submit" value=<fmt:message key="home.label.profileButton"/>>
            </form>

            <form class="logout_form" action="${Command.LOGOUT_CMD.getCommand()}" method="post">
                <input type="submit" value=<fmt:message key="header.label.logoutButton"/>>
            </form>
        </c:if>

        <form id="locale" class="navbar-search pull-right" method="post"
              action="${requestScope.get(Attribute.COMMAND_ATR.getAttribute())}">
            <c:forEach var="attribute" items="${requestScope.entrySet().toArray()}">
                <c:if test="${attribute.getKey() != Attribute.COMMAND_ATR.getAttribute() &&
                attribute.getKey() != 'javax.servlet.forward.context_path' &&
                attribute.getKey() != 'javax.servlet.forward.servlet_path' &&
                attribute.getKey() != 'javax.servlet.forward.mapping' &&
                attribute.getKey() != 'javax.servlet.forward.request_uri'}">
                    <input type="hidden" name="${attribute.getKey()}" value="${attribute.getValue()}" form="locale"/>
                </c:if>
            </c:forEach>
            <select class="form-control" id="language" name="language" onchange="submit()" form="locale">
                <option value="en" ${language == 'en' ? 'selected' : ''}>
                    <fmt:message key="header.label.language.en"/>
                </option>
                <option value="ru" ${language == 'ru' ? 'selected' : ''}>
                    <fmt:message key="header.label.language.ru"/>
                </option>
            </select>
        </form>

    </body>
</html>
