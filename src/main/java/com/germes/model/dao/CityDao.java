package com.germes.model.dao;

import com.germes.exceptions.PersistentException;
import com.germes.model.entities.City;
import com.germes.model.entities.Country;

import java.util.List;

public interface CityDao<Context> extends GenericDao<City, Integer, Context> {

    List<City> getAllByCountry(Country country, Context context) throws PersistentException;

}
