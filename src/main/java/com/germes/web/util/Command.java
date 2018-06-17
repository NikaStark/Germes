package com.germes.web.util;

public enum Command {

    DEFAULT_CMD(""),
    LOGIN_CMD("login"),
    AUTH_CMD("auth"),
    REG_CMD("registration"),
    REG_PAGE_CMD("registrationPage"),
    HOME_PAGE_CMD("home"),
    PROFILE_PAGE_CMD("profile"),
    CHANGE_PROFILE_CMD("change_profile"),
    LOGOUT_CMD("logout"),
    TARIFFS_CMD("tariffs"),
    GET_LIST_USERS_CMD("get_users"),
    GET_LIST_BRANCHES_CMD("get_branches"),
    GET_LIST_CITIES_CMD("get_cities"),
    GET_LIST_COUNTRIES_CMD("get_countries"),
    GET_LIST_PARCELS_CMD("get_parcels"),
    GET_LIST_GOODS_CMD("get_goods"),
    GET_LIST_DELIVERIES_CMD("get_deliveries");

    private String command;

    Command(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public static Command valueOfByField(String commandField) {
        for (Command command : values()) {
            if (command.command.equals(commandField)) {
                return command;
            }
        }
        throw new IllegalArgumentException("Try found command: \"" + commandField + "\"");
    }

}
