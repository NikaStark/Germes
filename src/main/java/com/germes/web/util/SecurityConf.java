package com.germes.web.util;

import com.germes.model.entities.enums.Role;

public enum SecurityConf {

    DEFAULT_ACCESS(Command.DEFAULT_CMD, new Role[]{Role.GUEST}),
    LOGIN_ACCESS(Command.LOGIN_CMD, new Role[]{Role.GUEST});

    private Command command;
    private Role[] roles;

    SecurityConf(Command command, Role[] roles) {
        this.command = command;
        this.roles = roles;
    }

    public static SecurityConf valueOfByField(Command command) {
        for (SecurityConf securityConf : values()) {
            if (securityConf.command == command) {
                return securityConf;
            }
        }
        throw new IllegalArgumentException();
    }

    public boolean isAvailable(Role role) {
        for (Role availableRole : roles) {
            if (availableRole == role) {
                return true;
            }
        }
        return false;
    }

}
