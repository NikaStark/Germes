package com.germes.model.services;

import com.germes.exceptions.ServiceException;
import com.germes.model.entities.Parcel;

import java.util.List;
import java.util.UUID;

public interface ParcelService extends GenericService<Parcel, UUID> {

    int getCountWherePK(UUID key) throws ServiceException;

    List<Parcel> getAllLimitWherePK(UUID key, int limit, int offset) throws ServiceException;

}
