package com.germes.model.services;

import com.germes.exceptions.ServiceException;
import com.germes.model.entities.Delivery;

import java.util.List;
import java.util.UUID;

public interface DeliveryService extends GenericService<Delivery, UUID> {

    int getCountWherePK(UUID key) throws ServiceException;

    List<Delivery> getAllLimitWherePK(UUID key, int limit, int offset) throws ServiceException;

}
