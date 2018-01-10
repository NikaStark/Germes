package com.germes.model.services.impl;

import com.germes.model.dao.ParcelDao;
import com.germes.model.entities.Parcel;
import com.germes.model.services.ParcelService;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.util.UUID;

public class ParcelServiceImpl extends AbstractJDBCService<Parcel, UUID, ParcelDao<Connection>> implements ParcelService {

    public ParcelServiceImpl(ParcelDao<Connection> dao) {
        super(dao);
        LOGGER = LoggerFactory.getLogger(ParcelServiceImpl.class);
    }

}
