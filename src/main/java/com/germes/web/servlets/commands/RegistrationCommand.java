package com.germes.web.servlets.commands;

import com.germes.exceptions.ServiceException;
import com.germes.model.entities.User;
import com.germes.model.entities.enums.Role;
import com.germes.model.services.ServiceFactory;
import com.germes.model.services.UserService;
import com.germes.model.services.impl.UserServiceImpl;
import com.germes.web.util.Attribute;
import com.germes.web.util.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationCommand implements ICommand {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationPageCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("Executing registration command");
        String username = request.getParameter(Attribute.USERNAME_ATR.getAttribute());
        String password = request.getParameter(Attribute.PASSWORD_ATR.getAttribute());
        String passwordRepeat = request.getParameter(Attribute.PASSWORD_REPEAT_ATR.getAttribute());
        String email = request.getParameter(Attribute.EMAIL_ATR.getAttribute());
        String firstName = request.getParameter(Attribute.FIRST_NAME_ATR.getAttribute());
        String lastName = request.getParameter(Attribute.LAST_NAME_ATR.getAttribute());

        if (username.isEmpty() || password.isEmpty() || passwordRepeat.isEmpty() || email.isEmpty()
                || firstName.isEmpty() || lastName.isEmpty()) {
            LOGGER.info("Not all fields are filled");
            //TODO output message: wrong input
            request.getRequestDispatcher(Command.REG_PAGE_CMD.getCommand()).forward(request, response);
            return;
        }
        if (!password.equals(passwordRepeat)) {
            LOGGER.info("Passwords not equal");
            //TODO output message: wrong input
            request.getRequestDispatcher(Command.REG_PAGE_CMD.getCommand()).forward(request, response);
            return;
        }
        User user = new User(username, password, email, firstName, lastName,
                (((User) request.getSession().getAttribute(Attribute.CURRENT_USER_ATR.getAttribute())).getRole() ==
                        Role.GUEST) ? Role.CLIENT : Role.MANAGER);
        UserService userService = ((ServiceFactory) request.getServletContext()
                .getAttribute(Attribute.SERVICE_FACTORY_ATR.getAttribute())).getService(UserServiceImpl.class);
        try {
            userService.create(user);
        } catch (ServiceException e) {
            e.printStackTrace(); //TODO
        }
        //TODO output message: reg success
        request.getRequestDispatcher(((User) request.getSession().getAttribute(Attribute.CURRENT_USER_ATR.
                        getAttribute())).getRole() != Role.GUEST ? Command.HOME_PAGE_CMD.getCommand() :
                Command.LOGIN_CMD.getCommand()).forward(request, response);
    }

}
