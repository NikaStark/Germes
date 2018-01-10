package com.germes.model.services.impl;

import com.germes.model.dao.CountryDao;
import com.germes.model.entities.Country;
import com.germes.model.services.CountryService;
import org.slf4j.LoggerFactory;

import java.sql.Connection;

public class CountryServiceImpl extends AbstractJDBCService<Country, Integer, CountryDao<Connection>> implements CountryService {

    public CountryServiceImpl(CountryDao<Connection> dao) {
        super(dao);
        LOGGER = LoggerFactory.getLogger(CountryServiceImpl.class);
    }

}
