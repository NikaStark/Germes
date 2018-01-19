package com.germes.model.dao;

import com.germes.exceptions.PersistentException;
import com.germes.model.entities.Country;

public interface CountryDao<Context> extends GenericDao<Country, Integer, Context> {

    Country getByName(String name, Context context) throws PersistentException;

}
