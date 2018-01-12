package com.germes.web.filters;

import com.germes.web.util.Attribute;
import com.germes.web.util.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class CommandFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommandFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.info("CommandFilter initialized.");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String uri = ((HttpServletRequest) request).getRequestURI();
        Command command = Command.valueOfByField(uri.substring(uri.lastIndexOf('/') + 1));
        request.setAttribute(Attribute.COMMAND_ATR.getAttribute(), command);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        LOGGER.info("CommandFilter destroyed.");
    }

}
