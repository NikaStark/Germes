package com.germes.model.services.impl;

import com.germes.exceptions.ServiceException;
import com.germes.model.dao.ParcelDao;
import com.germes.model.entities.Parcel;
import com.germes.model.services.ParcelService;
import com.germes.model.services.util.ConnectionAccess;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public class ParcelServiceImpl extends AbstractJDBCService<Parcel, UUID, ParcelDao<Connection>> implements ParcelService {

    public ParcelServiceImpl(ParcelDao<Connection> dao) {
        super(dao);
        LOGGER = LoggerFactory.getLogger(ParcelServiceImpl.class);
    }

    @Override
    public int getCountWherePK(UUID key) throws ServiceException {
        LOGGER.info("Get count rows where key");
        return ConnectionAccess.connectionWrap(connection -> dao.getCountWherePK(key, connection));
    }

    @Override
    public List<Parcel> getAllLimitWherePK(UUID key, int limit, int offset) throws ServiceException {
        LOGGER.info("Get all limit where key");
        return ConnectionAccess.connectionWrap(connection -> dao.getAllLimitWherePK(key, limit, offset, connection));
    }

}
