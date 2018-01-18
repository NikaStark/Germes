package com.germes.web.servlets.commands;

import com.germes.web.util.Command;

public enum FactoryCommand {

    DEFAULT_CMD(Command.DEFAULT_CMD, new DefaultCommand()),
    LOGIN_CMD(Command.LOGIN_CMD, new LoginCommand()),
    AUTH_CMD(Command.AUTH_CMD, new AuthCommand()),
    REG_CMD(Command.REG_CMD, new RegistrationCommand()),
    REG_PAGE_CMD(Command.REG_PAGE_CMD, new RegistrationPageCommand()),
    HOME_PAGE_CMD(Command.HOME_PAGE_CMD, new HomePageCommand()),
    PROFILE_PAGE_CMD(Command.PROFILE_PAGE_CMD, new ProfilePageCommand()),
    CHANGE_PROFILE_CMD(Command.CHANGE_PROFILE_CMD, new ChangeProfileCommand()),
    LOGOUT_CMD(Command.LOGOUT_CMD, new LogoutCommand());

    private Command commandName;
    private ICommand commandImpl;

    FactoryCommand(Command commandName, ICommand commandImpl) {
        this.commandName = commandName;
        this.commandImpl = commandImpl;
    }

    public static ICommand getCommand(Command command) {
        for (FactoryCommand fCommand : values()) {
            if (fCommand.commandName == command) {
                return fCommand.commandImpl;
            }
        }
        throw new IllegalArgumentException();
    }

}
