<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.germes.web.util.Command" %>
<%@ page import="com.germes.web.util.Attribute" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
        <c:set var="language" value="${empty param.language ? (empty sessionScope.language ? 'en' : sessionScope.language) : param.language }" scope="session"/>
        <fmt:setLocale value="${sessionScope.language}"/>
        <fmt:setBundle basename="bundles\bundle"/>
    </head>

    <body>

        <form id="locale" class="navbar-search pull-right" method="post" action="${requestScope.get(Attribute.COMMAND_ATR.getAttribute())}">
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
