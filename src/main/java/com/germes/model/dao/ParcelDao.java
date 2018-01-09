package com.germes.model.dao;

import com.germes.model.entities.Parcel;

import java.util.UUID;

public interface ParcelDao<Context> extends GenericDao<Parcel, UUID, Context> {
}
