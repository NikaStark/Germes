package com.germes.model.dao.impl;

import com.germes.exceptions.PersistentException;
import com.germes.model.dao.CountryDao;
import com.germes.model.entities.Country;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CountryDaoImpl extends AbstractJDBCDao<Country, Integer> implements CountryDao<Connection> {

    {
        LOGGER = LoggerFactory.getLogger(CountryDaoImpl.class);
        SQL_FIND_ALL = "SELECT " + Country.ID_COLUMN + ", " + Country.NAME_COLUMN + ", " + Country.TARIFF_COLUMN + " FROM " + Country.TABLE_NAME;
        SQL_FIND_ALL_LIMIT = SQL_FIND_ALL + " LIMIT ? OFFSET ?";
        SQL_FIND_BY_PK = SQL_FIND_ALL + " WHERE " + Country.ID_COLUMN + "=?";
        SQL_GET_COUNT = "SELECT count(*) AS " + Country.COUNT + " FROM " + Country.TABLE_NAME;
        SQL_INSERT = "INSERT INTO " + Country.TABLE_NAME + " (" + Country.NAME_COLUMN + ", " + Country.TARIFF_COLUMN + ") VALUES (?, ?)";
        SQL_UPDATE = "UPDATE " + Country.TABLE_NAME + " SET " + Country.NAME_COLUMN + "=?, " + Country.TARIFF_COLUMN + "=? WHERE " + Country.ID_COLUMN + "=?";
        SQL_DELETE = "DELETE FROM " + Country.TABLE_NAME + " WHERE " + Country.ID_COLUMN + "=?";
    }

    private String SQL_FIND_BY_NAME = SQL_FIND_ALL + " WHERE " + Country.NAME_COLUMN + "=?";

    CountryDaoImpl() {
    }

    @Override
    public Country getByName(String name, Connection connection) throws PersistentException {
        List<Country> list;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_BY_NAME)) {
            preparedStatement.setObject(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            list = parseResultSet(resultSet);
        } catch (SQLException e) {
            LOGGER.error("getByName with name=" + name, e);
            throw new PersistentException(e);
        }
        if (Objects.isNull(list) || list.isEmpty()) {
            return null;
        }
        if (list.size() > 1) {
            LOGGER.warn("Received more than one record, with name=" + name);
        }
        return list.iterator().next();
    }

    @Override
    protected List<Country> parseResultSet(ResultSet resultSet) throws PersistentException {
        List<Country> list = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Country country = new Country();
                country.setId(resultSet.getInt(Country.ID_COLUMN));
                country.setName(resultSet.getString(Country.NAME_COLUMN));
                country.setTariff(resultSet.getFloat(Country.TARIFF_COLUMN));
                list.add(country);
            }
        } catch (SQLException e) {
            LOGGER.error("parseResultSet ", e);
            throw new PersistentException(e);
        }
        return list;
    }

    @Override
    protected void parseResultSetGeneratedKeys(ResultSet generatedKeys, Country object) throws PersistentException {
        try {
            if (generatedKeys.next()) {
                object.setId(generatedKeys.getInt(Country.ID_COLUMN));
            }
        } catch (SQLException e) {
            LOGGER.error("parseResultSetGeneratedKeys ", e);
            throw new PersistentException(e);
        }
    }

    @Override
    protected int parseResultSetCount(ResultSet resultSet) throws PersistentException {
        int count = 0;
        try {
            if (resultSet.next()) {
                count = resultSet.getInt(Country.COUNT);
            }
        } catch (SQLException e) {
            LOGGER.error("parseResultSetCount ", e);
            throw new PersistentException(e);
        }
        return count;
    }

    @Override
    protected void preparedStatementForInsert(PreparedStatement preparedStatement, Country object) throws PersistentException {
        try {
            preparedStatement.setString(1, object.getName());
            preparedStatement.setFloat(2, object.getTariff());
        } catch (SQLException e) {
            LOGGER.error("preparedStatementForInsert ", e);
            throw new PersistentException(e);
        }
    }

    @Override
    protected void preparedStatementForUpdate(PreparedStatement preparedStatement, Country object) throws PersistentException {
        try {
            preparedStatement.setString(1, object.getName());
            preparedStatement.setFloat(2, object.getTariff());
            preparedStatement.setInt(3, object.getId());
        } catch (SQLException e) {
            LOGGER.error("preparedStatementForUpdate ", e);
            throw new PersistentException(e);
        }
    }

}
