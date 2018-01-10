package com.germes.model.services.impl;

import com.germes.model.dao.DeliveryDao;
import com.germes.model.entities.Delivery;
import com.germes.model.services.DeliveryService;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.util.UUID;

public class DeliveryServiceImpl extends AbstractJDBCService<Delivery, UUID, DeliveryDao<Connection>> implements DeliveryService {

    public DeliveryServiceImpl(DeliveryDao<Connection> dao) {
        super(dao);
        LOGGER = LoggerFactory.getLogger(DeliveryServiceImpl.class);
    }

}
