package com.germes.web.util;

import com.germes.model.entities.enums.Role;

public enum SecurityConf {

    DEFAULT_ACCESS(Command.DEFAULT_CMD, new Role[]{Role.GUEST}),
    LOGIN_ACCESS(Command.LOGIN_CMD, new Role[]{Role.GUEST}),
    AUTH_ACCESS(Command.AUTH_CMD, new Role[]{Role.GUEST}),
    REG_ACCESS(Command.REG_CMD, new Role[]{Role.GUEST}),
    REG_PAGE_ACCESS(Command.REG_PAGE_CMD, new Role[]{Role.GUEST}),
    HOME_PAGE_ACCESS(Command.HOME_PAGE_CMD, new Role[]{Role.CLIENT, Role.MANAGER, Role.ADMIN}),
    LOGOUT_ACCESS(Command.LOGOUT_CMD, new Role[]{Role.CLIENT, Role.MANAGER, Role.ADMIN});

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
