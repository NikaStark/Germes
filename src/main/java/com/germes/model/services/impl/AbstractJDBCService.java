package com.germes.model.services.impl;

import com.germes.exceptions.ServiceException;
import com.germes.model.dao.GenericDao;
import com.germes.model.entities.Identified;
import com.germes.model.services.GenericService;
import com.germes.model.services.util.ConnectionAccess;
import org.slf4j.Logger;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;

public abstract class AbstractJDBCService<T extends Identified<PK>, PK extends Serializable, DaoType extends GenericDao<T, PK, Connection>> implements GenericService<T, PK> {

    protected Logger LOGGER;
    protected DaoType dao;

    public AbstractJDBCService(DaoType dao) {
        this.dao = dao;
    }

    @Override
    public void create(T object) throws ServiceException {
        LOGGER.info("Create new " + object.getClass().getSimpleName());
        ConnectionAccess.connectionWrap(connection -> {
            dao.create(object, connection);
            return null;
        });
    }

    @Override
    public T getByPK(PK key) throws ServiceException {
        LOGGER.info("Get by primary key");
        return ConnectionAccess.connectionWrap(connection -> dao.getByPK(key, connection));
    }

    @Override
    public void update(T object) throws ServiceException {
        LOGGER.info("Update " + object.getClass().getSimpleName());
        ConnectionAccess.connectionWrap(connection -> {
            dao.update(object, connection);
            return null;
        });
    }

    @Override
    public void delete(T object) throws ServiceException {
        LOGGER.info("Delete " + object.getClass().getSimpleName());
        ConnectionAccess.connectionWrap(connection -> {
            dao.delete(object, connection);
            return null;
        });
    }

    @Override
    public List<T> getAll() throws ServiceException {
        LOGGER.info("Get all");
        return ConnectionAccess.connectionWrap(dao::getAll);
    }

}
