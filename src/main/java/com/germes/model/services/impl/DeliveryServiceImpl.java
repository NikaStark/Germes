package com.germes.model.services.impl;

import com.germes.exceptions.ServiceException;
import com.germes.model.dao.DeliveryDao;
import com.germes.model.entities.Delivery;
import com.germes.model.services.DeliveryService;
import com.germes.model.services.util.ConnectionAccess;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public class DeliveryServiceImpl extends AbstractJDBCService<Delivery, UUID, DeliveryDao<Connection>> implements DeliveryService {

    public DeliveryServiceImpl(DeliveryDao<Connection> dao) {
        super(dao);
        LOGGER = LoggerFactory.getLogger(DeliveryServiceImpl.class);
    }

    @Override
    public int getCountWherePK(UUID key) throws ServiceException {
        LOGGER.info("Get count rows where key");
        return ConnectionAccess.connectionWrap(connection -> dao.getCountWherePK(key, connection));
    }

    @Override
    public List<Delivery> getAllLimitWherePK(UUID key, int limit, int offset) throws ServiceException {
        LOGGER.info("Get all limit where key");
        return ConnectionAccess.connectionWrap(connection -> dao.getAllLimitWherePK(key, limit, offset, connection));
    }

}
