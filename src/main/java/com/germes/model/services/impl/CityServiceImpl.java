package com.germes.model.services.impl;

import com.germes.model.dao.CityDao;
import com.germes.model.entities.City;
import com.germes.model.services.CityService;
import org.slf4j.LoggerFactory;

import java.sql.Connection;

public class CityServiceImpl extends AbstractJDBCService<City, Integer, CityDao<Connection>> implements CityService {

    public CityServiceImpl(CityDao<Connection> dao) {
        super(dao);
        LOGGER = LoggerFactory.getLogger(CityServiceImpl.class);
    }

}
