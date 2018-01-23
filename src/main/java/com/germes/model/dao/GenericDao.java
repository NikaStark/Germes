package com.germes.model.dao;

import com.germes.exceptions.PersistentException;
import com.germes.model.entities.Identified;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T extends Identified<PK>, PK extends Serializable, Context> {

    void create(T object, Context context) throws PersistentException;

    T getByPK(PK key, Context context) throws PersistentException;

    int getCount(Context context) throws PersistentException;

    void update(T object, Context context) throws PersistentException;

    void delete(T object, Context context) throws PersistentException;

    List<T> getAll(Context context) throws PersistentException;

    List<T> getAllLimit(int skip, int limit, Context context) throws PersistentException;

}
