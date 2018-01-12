package com.germes.web.listeners;

import com.germes.model.services.impl.JDBCServiceFactory;
import com.germes.web.util.Attribute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationContextListener implements ServletContextListener {

    private static Logger LOGGER = LoggerFactory.getLogger(ApplicationContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute(Attribute.SERVICE_FACTORY_ATR.getAttribute(), JDBCServiceFactory.getInstance());
        LOGGER.info("Context initialize successfully!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        sce.getServletContext().removeAttribute(Attribute.CURRENT_USER_ATR.getAttribute());
        LOGGER.info("Context destroyed successfully!");
    }

}
