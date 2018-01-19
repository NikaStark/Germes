package com.germes.web.util;

public enum Attribute {

    SERVICE_FACTORY_ATR("serviceFactory"),
    CURRENT_USER_ATR("currentUser"),
    ID_ATR("id"),
    USERNAME_ATR("username"),
    PASSWORD_ATR("password"),
    PASSWORD_REPEAT_ATR("passwordRepeat"),
    EMAIL_ATR("email"),
    FIRST_NAME_ATR("firstName"),
    LAST_NAME_ATR("lastName"),
    USER_PROFILE_ATR("userProfile"),
    PROFILE_FORM_ATR("profileForm"),
    COUNTRY_ATR("country"),
    COUNTRIES_ATR("countries"),
    CITIES_ATR("cities"),
    COMMAND_ATR("cmd");

    private String attribute;

    Attribute(String attribute) {
        this.attribute = attribute;
    }

    public String getAttribute() {
        return attribute;
    }

}
