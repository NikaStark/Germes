package com.germes.web.servlets.commands;

import com.germes.exceptions.ServiceException;
import com.germes.model.entities.User;
import com.germes.model.entities.enums.Role;
import com.germes.model.services.*;
import com.germes.model.services.impl.*;
import com.germes.web.util.Attribute;
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
        String navigationForm = request.getParameter(Attribute.NAVIGATION_FORM_ATR.getAttribute()) != null ?
                request.getParameter(Attribute.NAVIGATION_FORM_ATR.getAttribute()) :
                ((User)request.getSession().getAttribute(Attribute.CURRENT_USER_ATR.getAttribute())).getRole() == Role.ADMIN ?
                "usersForm" :
                "parcelsForm";
        request.setAttribute(Attribute.NAVIGATION_FORM_ATR.getAttribute(), navigationForm);
        switch (navigationForm) {
            case "usersForm": {
                UserService userService = ((ServiceFactory) request.getServletContext()
                        .getAttribute(Attribute.SERVICE_FACTORY_ATR.getAttribute())).getService(UserServiceImpl.class);
                try {
                    request.setAttribute(Attribute.USERS_ATR.getAttribute(), userService.getAll());
                } catch (ServiceException e) {
                    e.printStackTrace(); //TODO
                }
                break;
            }
            case "branchesForm": {
                BranchService branchService = ((ServiceFactory) request.getServletContext()
                        .getAttribute(Attribute.SERVICE_FACTORY_ATR.getAttribute())).getService(BranchServiceImpl.class);
                try {
                    request.setAttribute(Attribute.BRANCHES_ATR.getAttribute(), branchService.getAll());
                } catch (ServiceException e) {
                    e.printStackTrace(); //TODO
                }
                break;
            }
            case "citiesForm": {
                CityService cityService = ((ServiceFactory) request.getServletContext()
                        .getAttribute(Attribute.SERVICE_FACTORY_ATR.getAttribute())).getService(CityServiceImpl.class);
                try {
                    request.setAttribute(Attribute.CITIES_ATR.getAttribute(), cityService.getAll());
                } catch (ServiceException e) {
                    e.printStackTrace(); //TODO
                }
                break;
            }
            case "countriesForm": {
                CountryService countryService = ((ServiceFactory) request.getServletContext()
                        .getAttribute(Attribute.SERVICE_FACTORY_ATR.getAttribute())).getService(CountryServiceImpl.class);
                try {
                    request.setAttribute(Attribute.COUNTRIES_ATR.getAttribute(), countryService.getAll());
                } catch (ServiceException e) {
                    e.printStackTrace(); //TODO
                }
                break;
            }
            case "parcelsForm": {
                ParcelService parcelService = ((ServiceFactory) request.getServletContext()
                        .getAttribute(Attribute.SERVICE_FACTORY_ATR.getAttribute())).getService(ParcelServiceImpl.class);
                try {
                    request.setAttribute(Attribute.PARCELS_ATR.getAttribute(), parcelService.getAll());
                } catch (ServiceException e) {
                    e.printStackTrace(); //TODO
                }
                break;
            }
            case "goodsForm": {
                GoodsService goodsService = ((ServiceFactory) request.getServletContext()
                        .getAttribute(Attribute.SERVICE_FACTORY_ATR.getAttribute())).getService(GoodsServiceImpl.class);
                try {
                    request.setAttribute(Attribute.GOODS_ATR.getAttribute(), goodsService.getAll());
                } catch (ServiceException e) {
                    e.printStackTrace(); //TODO
                }
                break;
            }
            case "deliveriesForm": {
                DeliveryService deliveryService = ((ServiceFactory) request.getServletContext()
                        .getAttribute(Attribute.SERVICE_FACTORY_ATR.getAttribute())).getService(DeliveryServiceImpl.class);
                try {
                    request.setAttribute(Attribute.DELIVERIES_ATR.getAttribute(), deliveryService.getAll());
                } catch (ServiceException e) {
                    e.printStackTrace(); //TODO
                }
                break;
            }
        }
        request.getRequestDispatcher(Page.HOME_PAGE.getPath()).forward(request, response);
    }

}
