package com.germes.web.util;

public enum Attribute {

    SERVICE_FACTORY_ATR("serviceFactory"),
    CURRENT_USER_ATR("currentUser"),
    USERNAME_ATR("username"),
    PASSWORD_ATR("password"),
    PASSWORD_REPEAT_ATR("passwordRepeat"),
    EMAIL_ATR("email"),
    FIRST_NAME_ATR("firstName"),
    LAST_NAME_ATR("lastName"),
    COMMAND_ATR("cmd");

    private String attribute;

    Attribute(String attribute) {
        this.attribute = attribute;
    }

    public String getAttribute() {
        return attribute;
    }

}
