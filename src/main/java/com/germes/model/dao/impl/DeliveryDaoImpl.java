package com.germes.model.dao.impl;

import com.germes.exceptions.PersistentException;
import com.germes.model.dao.DeliveryDao;
import com.germes.model.entities.Delivery;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DeliveryDaoImpl extends AbstractJDBCDao<Delivery, UUID> implements DeliveryDao<Connection> {

    {
        LOGGER = LoggerFactory.getLogger(DeliveryDaoImpl.class);
        SQL_FIND_ALL = "SELECT " + Delivery.ID_COLUMN + ", " + Delivery.PARCEL_COLUMN + ", " + Delivery.IS_DELIVERED_COLUMN + ", " + Delivery.CITY_COLUMN + ", " + Delivery.STREET_COLUMN + ", " + Delivery.STREET_NUMBER_COLUMN + " FROM " + Delivery.TABLE_NAME;
        SQL_FIND_BY_PK = SQL_FIND_ALL + " WHERE " + Delivery.ID_COLUMN + "=?";
        SQL_INSERT = "INSERT INTO " + Delivery.TABLE_NAME + " (" + Delivery.ID_COLUMN + ", " + Delivery.PARCEL_COLUMN + ", " + Delivery.IS_DELIVERED_COLUMN + ", " + Delivery.CITY_COLUMN + ", " + Delivery.STREET_COLUMN + ", " + Delivery.STREET_NUMBER_COLUMN + ") VALUES (?, ?, ?, ?, ?, ?)";
        SQL_UPDATE = "UPDATE " + Delivery.TABLE_NAME + " SET " + Delivery.PARCEL_COLUMN + "=?, " + Delivery.IS_DELIVERED_COLUMN + "=?, " + Delivery.CITY_COLUMN + "=?, " + Delivery.STREET_COLUMN + "=?, " + Delivery.STREET_NUMBER_COLUMN + "=? WHERE " + Delivery.ID_COLUMN + "=?";
        SQL_DELETE = "DELETE FROM " + Delivery.TABLE_NAME + " WHERE " + Delivery.ID_COLUMN + "=?";
    }

    DeliveryDaoImpl() {
    }

    @Override
    protected List<Delivery> parseResultSet(ResultSet resultSet) throws PersistentException {
        List<Delivery> list = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Delivery delivery = new Delivery();
                delivery.setId(UUID.fromString(resultSet.getString(Delivery.ID_COLUMN)));
                delivery.setParcel(UUID.fromString(resultSet.getString(Delivery.PARCEL_COLUMN)));
                delivery.setIsDelivered(resultSet.getBoolean(Delivery.IS_DELIVERED_COLUMN));
                delivery.setCity(resultSet.getInt(Delivery.CITY_COLUMN));
                delivery.setStreet(resultSet.getString(Delivery.STREET_COLUMN));
                delivery.setStreetNumber(resultSet.getString(Delivery.STREET_NUMBER_COLUMN));
                list.add(delivery);
            }
        } catch (SQLException e) {
            LOGGER.error("parseResultSet ", e);
            throw new PersistentException(e);
        }
        return list;
    }

    @Override
    protected void parseResultSetGeneratedKeys(ResultSet generatedKeys, Delivery object) throws PersistentException {
        // This is mock, there is no need for this method because key for this entity generated on client side
    }

    @Override
    protected void preparedStatementForInsert(PreparedStatement preparedStatement, Delivery object) throws PersistentException {
        try {
            preparedStatement.setObject(1, object.getId());
            preparedStatement.setObject(2, object.getParcel());
            preparedStatement.setBoolean(3, object.getIsDelivered());
            preparedStatement.setInt(4, object.getCity());
            preparedStatement.setString(5, object.getStreet());
            preparedStatement.setString(6, object.getStreetNumber());
        } catch (SQLException e) {
            LOGGER.error("preparedStatementForInsert ", e);
            throw new PersistentException(e);
        }
    }

    @Override
    protected void preparedStatementForUpdate(PreparedStatement preparedStatement, Delivery object) throws PersistentException {
        try {
            preparedStatement.setObject(1, object.getParcel());
            preparedStatement.setBoolean(2, object.getIsDelivered());
            preparedStatement.setInt(3, object.getCity());
            preparedStatement.setString(4, object.getStreet());
            preparedStatement.setString(5, object.getStreetNumber());
            preparedStatement.setObject(6, object.getId());
        } catch (SQLException e) {
            LOGGER.error("preparedStatementForUpdate ", e);
            throw new PersistentException(e);
        }
    }

}
