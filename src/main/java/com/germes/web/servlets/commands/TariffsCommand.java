package com.germes.web.servlets.commands;

import com.germes.exceptions.ServiceException;
import com.germes.model.entities.City;
import com.germes.model.entities.Country;
import com.germes.model.services.CityService;
import com.germes.model.services.CountryService;
import com.germes.model.services.ServiceFactory;
import com.germes.model.services.impl.CityServiceImpl;
import com.germes.model.services.impl.CountryServiceImpl;
import com.germes.web.util.Attribute;
import com.germes.web.util.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class TariffsCommand implements ICommand {

    private static final Logger LOGGER = LoggerFactory.getLogger(TariffsCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("Executing tariffs command");
        ServiceFactory serviceFactory = (ServiceFactory) request.getServletContext()
                .getAttribute(Attribute.SERVICE_FACTORY_ATR.getAttribute());
        CountryService countryService = serviceFactory.getService(CountryServiceImpl.class);
        List<Country> countryList;
        try {
            countryList = countryService.getAll();
            request.setAttribute(Attribute.COUNTRIES_ATR.getAttribute(), countryList);
        } catch (ServiceException e) {
            e.printStackTrace(); //TODO
        }
        String country = request.getParameter(Attribute.COUNTRY_ATR.getAttribute());
        //TODO check to null
        if (Objects.nonNull(country) && !country.isEmpty()) {
            CityService cityService = serviceFactory.getService(CityServiceImpl.class);
            List<City> cityList;
            try {
                cityList = cityService.getAllByCountry(country);
                request.setAttribute(Attribute.CITIES_ATR.getAttribute(), cityList);
            } catch (ServiceException e) {
                e.printStackTrace(); //TODO
            }
        }
        request.getRequestDispatcher(Page.TARIFFS_PAGE.getPath()).forward(request, response);
    }

}
