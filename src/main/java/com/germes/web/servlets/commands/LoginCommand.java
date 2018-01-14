package com.germes.web.servlets.commands;

import com.germes.web.util.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginCommand implements ICommand {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("Executing login command");
        request.getRequestDispatcher(Page.LOGIN_PAGE.getPath()).forward(request, response);
    }

}
