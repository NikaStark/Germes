package com.germes.web.util;

public enum Command {

    DEFAULT_CMD(""),
    LOGIN_CMD("login"),
    AUTH_CMD("auth"),
    REG_CMD("registration"),
    REG_PAGE_CMD("registration"),
    HOME_PAGE_CMD("home"),
    PROFILE_PAGE_CMD("profile"),
    CHANGE_PROFILE_CMD("change_profile"),
    LOGOUT_CMD("logout");

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
