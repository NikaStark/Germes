package com.germes.web.util;

public enum Attribute {

    SERVICE_FACTORY_ATR("serviceFactory"),
    CURRENT_USER_ATR("currentUser"),
    COMMAND_ATR("cmd");

    private String attribute;

    Attribute(String attribute) {
        this.attribute = attribute;
    }

    public String getAttribute() {
        return attribute;
    }

}
