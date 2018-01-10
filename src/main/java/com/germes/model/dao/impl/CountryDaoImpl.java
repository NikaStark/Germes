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

public class CountryDaoImpl extends AbstractJDBCDao<Country, Integer> implements CountryDao<Connection> {

    {
        LOGGER = LoggerFactory.getLogger(CountryDaoImpl.class);
        SQL_FIND_ALL = "SELECT " + Country.ID_COLUMN + ", " + Country.NAME_COLUMN + ", " + Country.TARIFF_COLUMN + " FROM " + Country.TABLE_NAME;
        SQL_FIND_BY_PK = SQL_FIND_ALL + " WHERE " + Country.ID_COLUMN + "=?";
        SQL_INSERT = "INSERT INTO " + Country.TABLE_NAME + " (" + Country.NAME_COLUMN + ", " + Country.TARIFF_COLUMN + ") VALUES (?, ?)";
        SQL_UPDATE = "UPDATE " + Country.TABLE_NAME + " SET " + Country.NAME_COLUMN + "=?, " + Country.TARIFF_COLUMN + "=? WHERE " + Country.ID_COLUMN + "=?";
        SQL_DELETE = "DELETE FROM " + Country.TABLE_NAME + " WHERE " + Country.ID_COLUMN + "=?";
    }

    CountryDaoImpl() {
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
