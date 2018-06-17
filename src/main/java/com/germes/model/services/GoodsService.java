package com.germes.model.services;

import com.germes.exceptions.ServiceException;
import com.germes.model.entities.Goods;

import java.util.List;
import java.util.UUID;

public interface GoodsService extends GenericService<Goods, UUID> {

    int getCountWherePK(UUID key) throws ServiceException;

    List<Goods> getAllLimitWherePK(UUID key, int limit, int offset) throws ServiceException;

}
