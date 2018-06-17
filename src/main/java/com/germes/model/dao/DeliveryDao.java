package com.germes.model.dao;

import com.germes.exceptions.PersistentException;
import com.germes.model.entities.Delivery;

import java.util.List;
import java.util.UUID;

public interface DeliveryDao<Context> extends GenericDao<Delivery, UUID, Context> {

    int getCountWherePK(UUID key, Context context) throws PersistentException;

    List<Delivery> getAllLimitWherePK(UUID key, int limit, int offset, Context context) throws PersistentException;

}
