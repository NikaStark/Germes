package com.germes.web.filters;

import com.germes.model.entities.User;
import com.germes.web.util.Attribute;
import com.germes.web.util.Command;
import com.germes.web.util.SecurityConf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorizationFilter implements Filter {

    private static Logger LOGGER = LoggerFactory.getLogger(AuthorizationFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.info("AuthorizationFilter initialized.");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        User user = (User) httpRequest.getSession().getAttribute(Attribute.CURRENT_USER_ATR.getAttribute());
        String uri = httpRequest.getRequestURI();
        if (SecurityConf.valueOfByField(Command.valueOfByField(uri.substring(uri.lastIndexOf('/') + 1)))
                .isAvailable(user.getRole())) {
            chain.doFilter(httpRequest, httpResponse);
        } else {
            LOGGER.info("The user is not have enough level access.");
            httpResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }
    }

    @Override
    public void destroy() {
        LOGGER.info("AuthorizationFilter destroyed.");
    }

}