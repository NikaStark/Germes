package com.germes.web.servlets.commands.homeCmds;

import com.germes.exceptions.ServiceException;
import com.germes.model.services.ServiceFactory;
import com.germes.model.services.UserService;
import com.germes.model.services.impl.UserServiceImpl;
import com.germes.web.servlets.commands.ICommand;
import com.germes.web.util.Attribute;
import com.germes.web.util.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetListUsersCommand implements ICommand {

    private static final Logger LOGGER = LoggerFactory.getLogger(GetListUsersCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("Executing get list users command");
        int countElementsOnPage = 2;
        int numberPage = request.getParameter(Attribute.PAGE_ATR.getAttribute()) == null ? 1 :
                Integer.parseInt(request.getParameter(Attribute.PAGE_ATR.getAttribute()));
        request.setAttribute(Attribute.PAGE_ATR.getAttribute(), numberPage);
        UserService userService = ((ServiceFactory) request.getServletContext()
                .getAttribute(Attribute.SERVICE_FACTORY_ATR.getAttribute())).getService(UserServiceImpl.class);
        try {
            request.setAttribute(Attribute.USERS_ATR.getAttribute(),
                    userService.getAllLimit(countElementsOnPage, countElementsOnPage * (numberPage - 1)));
            int[] pages = new int[(int) Math.ceil(userService.getCount() / (double)countElementsOnPage)];
            for (int i = 0; i < pages.length; i++) {
                pages[i] = i + 1;
            }
            request.setAttribute(Attribute.PAGES_ATR.getAttribute(), pages);
        } catch (ServiceException e) {
            e.printStackTrace(); //TODO
        }
        request.getRequestDispatcher(Page.HOME_PAGE.getPath()).forward(request, response);
    }

}
