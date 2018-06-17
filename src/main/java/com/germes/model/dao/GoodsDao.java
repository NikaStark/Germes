package com.germes.model.dao;

import com.germes.exceptions.PersistentException;
import com.germes.model.entities.Goods;

import java.util.List;
import java.util.UUID;

public interface GoodsDao<Context> extends GenericDao<Goods, UUID, Context> {

    int getCountWherePK(UUID key, Context context) throws PersistentException;

    List<Goods> getAllLimitWherePK(UUID key, int limit, int offset, Context context) throws PersistentException;

}
