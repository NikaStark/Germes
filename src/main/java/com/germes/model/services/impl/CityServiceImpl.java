package com.germes.model.services.impl;

import com.germes.exceptions.ServiceException;
import com.germes.model.dao.CityDao;
import com.germes.model.dao.CountryDao;
import com.germes.model.entities.City;
import com.germes.model.services.CityService;
import com.germes.model.services.util.ConnectionAccess;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.util.List;

public class CityServiceImpl extends AbstractJDBCService<City, Integer, CityDao<Connection>> implements CityService {

    private CountryDao<Connection> countryDao;

    public CityServiceImpl(CityDao<Connection> dao, CountryDao<Connection> countryDao) {
        super(dao);
        this.countryDao = countryDao;
        LOGGER = LoggerFactory.getLogger(CityServiceImpl.class);
    }

    @Override
    public List<City> getAllByCountry(String name) throws ServiceException {
        return ConnectionAccess.transactionWrap(connection ->
                dao.getAllByCountry(countryDao.getByName(name, connection), connection));
    }

}
