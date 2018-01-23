package com.germes.model.dao.impl;

import com.germes.exceptions.PersistentException;
import com.germes.model.dao.CityDao;
import com.germes.model.entities.City;
import com.germes.model.entities.Country;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CityDaoImpl extends AbstractJDBCDao<City, Integer> implements CityDao<Connection> {

    {
        LOGGER = LoggerFactory.getLogger(CityDaoImpl.class);
        SQL_FIND_ALL = "SELECT " + City.ID_COLUMN + ", " + City.COUNTRY_COLUMN + ", " + City.NAME_COLUMN + ", " + City.LATITUDE_COLUMN + ", " + City.LONGITUDE_COLUMN + ", " + City.TARIFF_COLUMN + " FROM " + City.TABLE_NAME;
        SQL_FIND_BY_PK = SQL_FIND_ALL + " WHERE " + City.ID_COLUMN + "=?";
        SQL_GET_COUNT = "SELECT count(*) AS " + City.COUNT + " FROM " + City.TABLE_NAME;
        SQL_INSERT = "INSERT INTO " + City.TABLE_NAME + " (" + City.COUNTRY_COLUMN + ", " + City.NAME_COLUMN + ", " + City.LATITUDE_COLUMN + ", " + City.LONGITUDE_COLUMN + ", " + City.TARIFF_COLUMN + ") VALUES (?, ?, ?, ?, ?)";
        SQL_UPDATE = "UPDATE " + City.TABLE_NAME + " SET " + City.COUNTRY_COLUMN + "=?, " + City.NAME_COLUMN + "=?, " + City.LATITUDE_COLUMN + "=?, " + City.LONGITUDE_COLUMN + "=?, " + City.TARIFF_COLUMN + "=? WHERE " + City.ID_COLUMN + "=?";
        SQL_DELETE = "DELETE FROM " + City.TABLE_NAME + " WHERE " + City.ID_COLUMN + "=?";
    }

    private String SQL_FIND_BY_COUNTRY = SQL_FIND_ALL + " WHERE " + City.COUNTRY_COLUMN + "=?";

    CityDaoImpl() {
    }

    @Override
    public List<City> getAllByCountry(Country country, Connection connection) throws PersistentException {
        List<City> list;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_BY_COUNTRY)) {
            preparedStatement.setObject(1, country.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            list = parseResultSet(resultSet);
        } catch (SQLException e) {
            LOGGER.error("getAllByCountry with country=" + country, e);
            throw new PersistentException(e);
        }
        if (Objects.isNull(list) || list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override
    protected List<City> parseResultSet(ResultSet resultSet) throws PersistentException {
        List<City> list = new ArrayList<>();
        try {
            while (resultSet.next()) {
                City city = new City();
                city.setId(resultSet.getInt(City.ID_COLUMN));
                city.setCountry(resultSet.getInt(City.COUNTRY_COLUMN));
                city.setName(resultSet.getString(City.NAME_COLUMN));
                city.setLatitude(resultSet.getFloat(City.LATITUDE_COLUMN));
                city.setLongitude(resultSet.getFloat(City.LONGITUDE_COLUMN));
                city.setTariff(resultSet.getFloat(City.TARIFF_COLUMN));
                list.add(city);
            }
        } catch (SQLException e) {
            LOGGER.error("parseResultSet ", e);
            throw new PersistentException(e);
        }
        return list;
    }

    @Override
    protected void parseResultSetGeneratedKeys(ResultSet generatedKeys, City object) throws PersistentException {
        try {
            if (generatedKeys.next()) {
                object.setId(generatedKeys.getInt(City.ID_COLUMN));
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
                count = resultSet.getInt(City.COUNT);
            }
        } catch (SQLException e) {
            LOGGER.error("parseResultSetCount ", e);
            throw new PersistentException(e);
        }
        return count;
    }

    @Override
    protected void preparedStatementForInsert(PreparedStatement preparedStatement, City object) throws PersistentException {
        try {
            preparedStatement.setInt(1, object.getCountry());
            preparedStatement.setString(2, object.getName());
            preparedStatement.setFloat(3, object.getLatitude());
            preparedStatement.setFloat(4, object.getLongitude());
            preparedStatement.setFloat(5, object.getTariff());
        } catch (SQLException e) {
            LOGGER.error("preparedStatementForInsert ", e);
            throw new PersistentException(e);
        }
    }

    @Override
    protected void preparedStatementForUpdate(PreparedStatement preparedStatement, City object) throws PersistentException {
        try {
            preparedStatement.setInt(1, object.getCountry());
            preparedStatement.setString(2, object.getName());
            preparedStatement.setFloat(3, object.getLatitude());
            preparedStatement.setFloat(4, object.getLongitude());
            preparedStatement.setFloat(5, object.getTariff());
            preparedStatement.setInt(6, object.getId());
        } catch (SQLException e) {
            LOGGER.error("preparedStatementForUpdate ", e);
            throw new PersistentException(e);
        }
    }

}
