package com.germes.web.servlets.commands;

import com.germes.exceptions.ServiceException;
import com.germes.model.entities.User;
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
import java.util.Objects;
import java.util.UUID;

public class ChangeProfileCommand implements ICommand {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChangeProfileCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("Executing change profile command");
        User userProfile = new User();
        String uuid = request.getParameter(Attribute.ID_ATR.getAttribute());
        if (Objects.isNull(uuid)) {
            //TODO forward to error page
        }
        userProfile.setId(UUID.fromString(uuid));
        switch (request.getParameter(Attribute.PROFILE_FORM_ATR.getAttribute())) {
            case "formInfo": {
                String username = request.getParameter(Attribute.USERNAME_ATR.getAttribute());
                String email = request.getParameter(Attribute.EMAIL_ATR.getAttribute());
                String firstName = request.getParameter(Attribute.FIRST_NAME_ATR.getAttribute());
                String lastName = request.getParameter(Attribute.LAST_NAME_ATR.getAttribute());

                //TODO check to null
                if (username.isEmpty() || email.isEmpty() || firstName.isEmpty() || lastName.isEmpty()) {
                    LOGGER.info("Not all fields of form change information are filled");
                    //TODO output message: wrong input
                    request.getRequestDispatcher(Command.PROFILE_PAGE_CMD.getCommand()).forward(request, response);
                    return;
                }
                //TODO Compare new values with old values
                userProfile.setUsername(username);
                userProfile.setEmail(email);
                userProfile.setFirstName(firstName);
                userProfile.setLastName(lastName);
                break;
            }
            case "formPass": {
                String password = request.getParameter(Attribute.PASSWORD_ATR.getAttribute());
                String passwordRepeat = request.getParameter(Attribute.PASSWORD_REPEAT_ATR.getAttribute());

                //TODO check to null
                if (password.isEmpty() || passwordRepeat.isEmpty()) {
                    LOGGER.info("Not all fields of form change password are filled");
                    //TODO output message: wrong input
                    request.getRequestDispatcher(Command.PROFILE_PAGE_CMD.getCommand()).forward(request, response);
                    return;
                }
                if (!password.equals(passwordRepeat)) {
                    LOGGER.info("Passwords not equal");
                    //TODO output message: wrong input
                    request.getRequestDispatcher(Command.PROFILE_PAGE_CMD.getCommand()).forward(request, response);
                    return;
                }
                //TODO Compare new password with old
                userProfile.setPassword(password);
                break;
            }
        }
        UserService userService = ((ServiceFactory) request.getServletContext()
                .getAttribute(Attribute.SERVICE_FACTORY_ATR.getAttribute())).getService(UserServiceImpl.class);
        try {
            userService.modify(userProfile);
        } catch (ServiceException e) {
            e.printStackTrace(); //TODO
        }
        //TODO output message: changes update success
        request.getRequestDispatcher(Command.PROFILE_PAGE_CMD.getCommand()).forward(request, response);
    }

}
