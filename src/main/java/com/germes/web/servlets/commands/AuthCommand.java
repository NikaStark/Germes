package com.germes.web.servlets.commands;

import com.germes.exceptions.ServiceException;
import com.germes.model.entities.User;
import com.germes.model.services.ServiceFactory;
import com.germes.model.services.UserService;
import com.germes.model.services.impl.UserServiceImpl;
import com.germes.web.util.Attribute;
import com.germes.web.util.Command;
import com.germes.web.util.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class AuthCommand implements ICommand {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("Executing auth command");
        String username = request.getParameter(Attribute.USERNAME_ATR.getAttribute());
        String password = request.getParameter(Attribute.PASSWORD_ATR.getAttribute());

        if (username.isEmpty() || password.isEmpty()) {
            LOGGER.info("Not all fields are filled");
            //TODO output message: wrong input
            request.getRequestDispatcher(Command.LOGIN_CMD.getCommand()).forward(request, response);
            return;
        }
        UserService userService = ((ServiceFactory) request.getServletContext()
                .getAttribute(Attribute.SERVICE_FACTORY_ATR.getAttribute())).getService(UserServiceImpl.class);
        User currentUser = (User) request.getSession().getAttribute(Attribute.CURRENT_USER_ATR.getAttribute());
        try {
            currentUser = userService.authentication(username, password);
        } catch (ServiceException e) {
            e.printStackTrace(); //TODO
        }
        if (Objects.nonNull(currentUser)) {
            LOGGER.info("Successfully authentication, username: " + username);
            request.getSession().setAttribute(Attribute.CURRENT_USER_ATR.getAttribute(), currentUser);
            request.getRequestDispatcher(Page.HOME_PAGE.getPath()).forward(request, response);
        } else {
            LOGGER.info("Wrong username or password");
            //TODO output message: wrong input
            request.getRequestDispatcher(Command.LOGIN_CMD.getCommand()).forward(request, response);
        }
    }

}
