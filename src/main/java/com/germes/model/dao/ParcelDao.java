package com.germes.model.dao;

import com.germes.exceptions.PersistentException;
import com.germes.model.entities.Parcel;

import java.util.List;
import java.util.UUID;

public interface ParcelDao<Context> extends GenericDao<Parcel, UUID, Context> {

    int getCountWherePK(UUID key, Context context) throws PersistentException;

    List<Parcel> getAllLimitWherePK(UUID key, int limit, int offset, Context context) throws PersistentException;

}
