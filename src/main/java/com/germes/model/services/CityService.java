package com.germes.model.services;

import com.germes.exceptions.ServiceException;
import com.germes.model.entities.City;

import java.util.List;

public interface CityService extends GenericService<City, Integer> {

    List<City> getAllByCountry(String name) throws ServiceException;

}
