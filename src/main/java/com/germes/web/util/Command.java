package com.germes.web.util;

public enum Command {

    DEFAULT_CMD(""),
    LOGIN_CMD("login");

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
