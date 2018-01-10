package com.germes.model.services.util;

import com.germes.exceptions.PersistentException;
import com.germes.exceptions.ServiceException;

import java.sql.Connection;

@FunctionalInterface
public interface Instructions<T> {

    T execute(Connection connection) throws PersistentException, ServiceException;

}