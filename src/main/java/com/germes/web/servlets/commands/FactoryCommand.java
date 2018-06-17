package com.germes.web.servlets.commands;

import com.germes.web.servlets.commands.homeCmds.*;
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
    TARIFFS_CMD(Command.TARIFFS_CMD, new TariffsCommand()),
    LOGOUT_CMD(Command.LOGOUT_CMD, new LogoutCommand()),
    GET_LIST_USERS_CMD(Command.GET_LIST_USERS_CMD, new GetListUsersCommand()),
    GET_LIST_BRANCHES_CMD(Command.GET_LIST_BRANCHES_CMD, new GetListBranchesCommand()),
    GET_LIST_CITIES_CMD(Command.GET_LIST_CITIES_CMD, new GetListCitiesCommands()),
    GET_LIST_COUNTRIES_CMD(Command.GET_LIST_COUNTRIES_CMD, new GetListCountriesCommand()),
    GET_LIST_PARCELS_CMD(Command.GET_LIST_PARCELS_CMD, new GetListParcelsCommand()),
    GET_LIST_GOODS_CMD(Command.GET_LIST_GOODS_CMD, new GetListGoodsCommand()),
    GET_LIST_DELIVERIES_CMD(Command.GET_LIST_DELIVERIES_CMD, new GetListDeliveriesCommand());

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
