package com.germes.model.services.impl;

import com.germes.model.dao.GoodsDao;
import com.germes.model.entities.Goods;
import com.germes.model.services.GoodsService;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.util.UUID;

public class GoodsServiceImpl extends AbstractJDBCService<Goods, UUID, GoodsDao<Connection>> implements GoodsService {

    public GoodsServiceImpl(GoodsDao<Connection> dao) {
        super(dao);
        LOGGER = LoggerFactory.getLogger(GoodsServiceImpl.class);
    }

}
