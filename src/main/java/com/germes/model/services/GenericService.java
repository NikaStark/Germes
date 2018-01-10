package com.germes.model.services;

import com.germes.exceptions.ServiceException;
import com.germes.model.entities.Identified;

import java.io.Serializable;
import java.util.List;

public interface GenericService<T extends Identified<PK>, PK extends Serializable> {

    void create(T object) throws ServiceException;

    T getByPK(PK key) throws ServiceException;

    void update(T object) throws ServiceException;

    void delete(T object) throws ServiceException;

    List<T> getAll() throws ServiceException;

}
