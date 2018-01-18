package com.germes.web.servlets.commands;

import com.germes.exceptions.ServiceException;
import com.germes.model.entities.User;
import com.germes.model.services.ServiceFactory;
import com.germes.model.services.UserService;
import com.germes.model.services.impl.UserServiceImpl;
import com.germes.web.util.Attribute;
import com.germes.web.util.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

public class ProfilePageCommand implements ICommand {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProfilePageCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("Executing profile page command");
        String uuid = request.getParameter(Attribute.ID_ATR.getAttribute());
        User userProfile = new User();
        if (Objects.isNull(uuid)) {
            userProfile = (User) request.getSession().getAttribute(Attribute.CURRENT_USER_ATR.getAttribute());
        } else {
            UUID userId = UUID.fromString(uuid);
            UserService userService = ((ServiceFactory) request.getServletContext()
                    .getAttribute(Attribute.SERVICE_FACTORY_ATR.getAttribute())).getService(UserServiceImpl.class);
            try {
                userProfile = userService.getByPK(userId);
            } catch (ServiceException e) {
                e.printStackTrace(); //TODO
            }
        }
        request.setAttribute(Attribute.ID_ATR.getAttribute(), userProfile.getId());
        request.setAttribute(Attribute.USERNAME_ATR.getAttribute(), userProfile.getUsername());
        request.setAttribute(Attribute.EMAIL_ATR.getAttribute(), userProfile.getEmail());
        request.setAttribute(Attribute.FIRST_NAME_ATR.getAttribute(), userProfile.getFirstName());
        request.setAttribute(Attribute.LAST_NAME_ATR.getAttribute(), userProfile.getLastName());

//        for (Map.Entry entry : request.getParameterMap().entrySet()) {
//            String key = (String) entry.getKey();
//            String[] value = (String[]) entry.getValue();
//            System.out.print(key + " - ");
//            System.out.println(Arrays.toString(value));
//            System.out.println(entry.getValue());
//            System.out.println(value[0]);
//        }
//        Enumeration<String> attributeNames = request.getSession().getAttributeNames();
//        while (attributeNames.hasMoreElements()) {
//            String attributeName = attributeNames.nextElement();
//            System.out.print(attributeName + " - ");
//            System.out.println(request.getSession().getAttribute(attributeName).toString());
//        }

        request.getRequestDispatcher(Page.PROFILE_PAGE.getPath()).forward(request, response);
    }


}
