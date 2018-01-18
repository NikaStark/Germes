<html>
    <head>
        <title>Profile</title>
    </head>
    <body>

        <%@include file="templates/header.jsp" %>

        <h1><fmt:message key="profile.label.title"/></h1>

        <h3><fmt:message key="profile.label.changeInformation"/></h3>
        <form class="form-info" action="${Command.CHANGE_PROFILE_CMD.getCommand()}" method="post">
            <fmt:message key="profile.label.username"/> <br/>
            <input type="text" class="form-control input-lg" name="${Attribute.USERNAME_ATR.getAttribute()}"
                   value="${requestScope.get(Attribute.USERNAME_ATR.getAttribute())}" required/><br/>

            <fmt:message key="profile.label.email"/> <br/>
            <input type="text" class="form-control input-lg" name="${Attribute.EMAIL_ATR.getAttribute()}"
                   value="${requestScope.get(Attribute.EMAIL_ATR.getAttribute())}" required/><br/>

            <fmt:message key="profile.label.firstName"/> <br/>
            <input type="text" class="form-control input-lg" name="${Attribute.FIRST_NAME_ATR.getAttribute()}"
                   value="${requestScope.get(Attribute.FIRST_NAME_ATR.getAttribute())}" required/> <br/>

            <fmt:message key="profile.label.lastName"/> <br/>
            <input type="text" class="form-control input-lg" name="${Attribute.LAST_NAME_ATR.getAttribute()}"
                   value="${requestScope.get(Attribute.LAST_NAME_ATR.getAttribute())}" required/><br/>

            <input type="hidden" name="${Attribute.ID_ATR.getAttribute()}" value="${requestScope.get(Attribute.ID_ATR.getAttribute())}"/>
            <input type="hidden" name="${Attribute.PROFILE_FORM_ATR.getAttribute()}" value="formInfo"/>
            <input type="submit" value=<fmt:message key="profile.label.submitButton"/>>
        </form>

        <h3><fmt:message key="profile.label.changePassword"/></h3>
        <form class="form-pass" action="${Command.CHANGE_PROFILE_CMD.getCommand()}" method="post">

            <fmt:message key="profile.label.password"/> <br/>
            <input type="password" class="form-control input-lg" name="${Attribute.PASSWORD_ATR.getAttribute()}"
                   required/> <br/>

            <fmt:message key="profile.label.passwordRepeat"/> <br/>
            <input type="password" class="form-control input-lg" name="${Attribute.PASSWORD_REPEAT_ATR.getAttribute()}"
                   required/> <br/>

            <input type="hidden" name="${Attribute.ID_ATR.getAttribute()}" value="${requestScope.get(Attribute.ID_ATR.getAttribute())}"/>
            <input type="hidden" name="${Attribute.PROFILE_FORM_ATR.getAttribute()}" value="formPass"/>
            <input type="submit" value=<fmt:message key="profile.label.submitButton"/>>
        </form>


    </body>
</html>
