package com.germes.web.util;

import com.germes.model.entities.enums.Role;

public enum SecurityConf {

    DEFAULT_ACCESS(Command.DEFAULT_CMD, new Role[]{Role.GUEST, Role.CLIENT, Role.MANAGER, Role.ADMIN}),
    LOGIN_ACCESS(Command.LOGIN_CMD, new Role[]{Role.GUEST}),
    AUTH_ACCESS(Command.AUTH_CMD, new Role[]{Role.GUEST}),
    REG_ACCESS(Command.REG_CMD, new Role[]{Role.GUEST, Role.ADMIN}),
    REG_PAGE_ACCESS(Command.REG_PAGE_CMD, new Role[]{Role.GUEST, Role.ADMIN}),
    HOME_PAGE_ACCESS(Command.HOME_PAGE_CMD, new Role[]{Role.CLIENT, Role.MANAGER, Role.ADMIN}),
    PROFILE_PAGE_ACCESS(Command.PROFILE_PAGE_CMD, new Role[]{Role.CLIENT, Role.MANAGER, Role.ADMIN}),
    CHANGE_PROFILE_ACCESS(Command.CHANGE_PROFILE_CMD, new Role[]{Role.CLIENT, Role.MANAGER, Role.ADMIN}),
    LOGOUT_ACCESS(Command.LOGOUT_CMD, new Role[]{Role.CLIENT, Role.MANAGER, Role.ADMIN}),
    TARIFF_ACCESS(Command.TARIFFS_CMD, new Role[]{Role.GUEST, Role.CLIENT, Role.MANAGER, Role.ADMIN}),
    GET_LIST_USERS_ACCESS(Command.GET_LIST_USERS_CMD, new Role[]{Role.ADMIN}),
    GET_LIST_BRANCHES_ACCESS(Command.GET_LIST_BRANCHES_CMD, new Role[]{Role.ADMIN}),
    GET_LIST_CITIES_ACCESS(Command.GET_LIST_CITIES_CMD, new Role[]{Role.ADMIN}),
    GET_LIST_COUNTRIES_ACCESS(Command.GET_LIST_COUNTRIES_CMD, new Role[]{Role.ADMIN}),
    GET_LIST_PARCELS_ACCESS(Command.GET_LIST_PARCELS_CMD, new Role[]{Role.CLIENT, Role.MANAGER, Role.ADMIN}),
    GET_LIST_GOODS_ACCESS(Command.GET_LIST_GOODS_CMD, new Role[]{Role.CLIENT, Role.MANAGER, Role.ADMIN}),
    GET_LIST_DELIVERIES_ACCESS(Command.GET_LIST_DELIVERIES_CMD, new Role[]{Role.CLIENT, Role.MANAGER, Role.ADMIN});

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
