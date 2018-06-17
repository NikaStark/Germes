package com.germes.web.servlets.commands;

import com.germes.model.entities.User;
import com.germes.model.entities.enums.Role;
import com.germes.web.util.Attribute;
import com.germes.web.util.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomePageCommand implements ICommand {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomePageCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("Executing home command");
        String navigationForm = request.getParameter(Attribute.NAVIGATION_FORM_ATR.getAttribute()) != null ?
                request.getParameter(Attribute.NAVIGATION_FORM_ATR.getAttribute()) :
                ((User) request.getSession().getAttribute(Attribute.CURRENT_USER_ATR.getAttribute())).getRole() == Role.ADMIN ?
                        "usersForm" :
                        "parcelsForm";
        request.setAttribute(Attribute.NAVIGATION_FORM_ATR.getAttribute(), navigationForm);
        switch (navigationForm) {
            case "usersForm": {
                request.getRequestDispatcher(Command.GET_LIST_USERS_CMD.getCommand()).forward(request, response);
                break;
            }
            case "branchesForm": {
                request.getRequestDispatcher(Command.GET_LIST_BRANCHES_CMD.getCommand()).forward(request, response);
                break;
            }
            case "citiesForm": {
                request.getRequestDispatcher(Command.GET_LIST_CITIES_CMD.getCommand()).forward(request, response);
                break;
            }
            case "countriesForm": {
                request.getRequestDispatcher(Command.GET_LIST_COUNTRIES_CMD.getCommand()).forward(request, response);
                break;
            }
            case "parcelsForm": {
                request.getRequestDispatcher(Command.GET_LIST_PARCELS_CMD.getCommand()).forward(request, response);
                break;
            }
            case "goodsForm": {
                request.getRequestDispatcher(Command.GET_LIST_GOODS_CMD.getCommand()).forward(request, response);
                break;
            }
            case "deliveriesForm": {
                request.getRequestDispatcher(Command.GET_LIST_DELIVERIES_CMD.getCommand()).forward(request, response);
                break;
            }
        }
    }

}
