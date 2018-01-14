package com.germes.web.servlets.commands;

import com.germes.web.util.Page;
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
        request.getRequestDispatcher(Page.HOME_PAGE.getPath()).forward(request, response);
    }

}
