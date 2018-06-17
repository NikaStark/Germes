package com.germes.model.services.impl;

import com.germes.exceptions.ServiceException;
import com.germes.model.dao.GoodsDao;
import com.germes.model.entities.Goods;
import com.germes.model.services.GoodsService;
import com.germes.model.services.util.ConnectionAccess;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public class GoodsServiceImpl extends AbstractJDBCService<Goods, UUID, GoodsDao<Connection>> implements GoodsService {

    public GoodsServiceImpl(GoodsDao<Connection> dao) {
        super(dao);
        LOGGER = LoggerFactory.getLogger(GoodsServiceImpl.class);
    }

    @Override
    public int getCountWherePK(UUID key) throws ServiceException {
        LOGGER.info("Get count rows where key");
        return ConnectionAccess.connectionWrap(connection -> dao.getCountWherePK(key, connection));
    }

    @Override
    public List<Goods> getAllLimitWherePK(UUID key, int limit, int offset) throws ServiceException {
        LOGGER.info("Get all limit where key");
        return ConnectionAccess.connectionWrap(connection -> dao.getAllLimitWherePK(key, limit, offset, connection));
    }

}
