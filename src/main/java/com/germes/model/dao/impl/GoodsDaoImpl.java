package com.germes.model.dao.impl;

import com.germes.exceptions.PersistentException;
import com.germes.model.dao.GoodsDao;
import com.germes.model.entities.Goods;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GoodsDaoImpl extends AbstractJDBCDao<Goods, UUID> implements GoodsDao<Connection> {

    {
        LOGGER = LoggerFactory.getLogger(GoodsDaoImpl.class);
        SQL_FIND_ALL = "SELECT " + Goods.ID_COLUMN + ", " + Goods.PARCEL_COLUMN + ", " + Goods.WEIGHT_COLUMN + ", " + Goods.LENGTH_COLUMN + ", " + Goods.WIDTH_COLUMN + ", " + Goods.HEIGHT_COLUMN + ", " + Goods.ASSESSED_VALUE_COLUMN + " FROM " + Goods.TABLE_NAME;
        SQL_FIND_BY_PK = SQL_FIND_ALL + " WHERE " + Goods.ID_COLUMN + "=?";
        SQL_INSERT = "INSERT INTO " + Goods.TABLE_NAME + " (" + Goods.ID_COLUMN + ", " + Goods.PARCEL_COLUMN + ", " + Goods.WEIGHT_COLUMN + ", " + Goods.LENGTH_COLUMN + ", " + Goods.WIDTH_COLUMN + ", " + Goods.HEIGHT_COLUMN + ", " + Goods.ASSESSED_VALUE_COLUMN + ") VALUES (?, ?, ?, ?, ?, ?, ?)";
        SQL_UPDATE = "UPDATE " + Goods.TABLE_NAME + " SET " + Goods.PARCEL_COLUMN + "=?, " + Goods.WEIGHT_COLUMN + "=?, " + Goods.LENGTH_COLUMN + "=?, " + Goods.WIDTH_COLUMN + "=?, " + Goods.HEIGHT_COLUMN + "=?, " + Goods.ASSESSED_VALUE_COLUMN + "=? WHERE " + Goods.ID_COLUMN + "=?";
        SQL_DELETE = "DELETE FROM " + Goods.TABLE_NAME + " WHERE " + Goods.ID_COLUMN + "=?";
    }

    GoodsDaoImpl() {
    }

    @Override
    protected List<Goods> parseResultSet(ResultSet resultSet) throws PersistentException {
        List<Goods> list = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Goods goods = new Goods();
                goods.setId(UUID.fromString(resultSet.getString(Goods.ID_COLUMN)));
                goods.setParcel(UUID.fromString(resultSet.getString(Goods.PARCEL_COLUMN)));
                goods.setWeight(resultSet.getFloat(Goods.WEIGHT_COLUMN));
                goods.setLength(resultSet.getInt(Goods.LENGTH_COLUMN));
                goods.setWidth(resultSet.getInt(Goods.WIDTH_COLUMN));
                goods.setHeight(resultSet.getInt(Goods.HEIGHT_COLUMN));
                goods.setAssessedValue(resultSet.getFloat(Goods.ASSESSED_VALUE_COLUMN));
                list.add(goods);
            }
        } catch (SQLException e) {
            LOGGER.error("parseResultSet ", e);
            throw new PersistentException(e);
        }
        return list;
    }

    @Override
    protected void parseResultSetGeneratedKeys(ResultSet generatedKeys, Goods object) throws PersistentException {
        // This is mock, there is no need for this method because key for this entity generated on client side
    }

    @Override
    protected void preparedStatementForInsert(PreparedStatement preparedStatement, Goods object) throws PersistentException {
        try {
            preparedStatement.setObject(1, object.getId());
            preparedStatement.setObject(2, object.getParcel());
            preparedStatement.setFloat(3, object.getWeight());
            preparedStatement.setInt(4, object.getLength());
            preparedStatement.setInt(5, object.getWidth());
            preparedStatement.setInt(6, object.getHeight());
            preparedStatement.setFloat(7, object.getAssessedValue());
        } catch (SQLException e) {
            LOGGER.error("preparedStatementForInsert ", e);
            throw new PersistentException(e);
        }
    }

    @Override
    protected void preparedStatementForUpdate(PreparedStatement preparedStatement, Goods object) throws PersistentException {
        try {
            preparedStatement.setObject(1, object.getParcel());
            preparedStatement.setFloat(2, object.getWeight());
            preparedStatement.setInt(3, object.getLength());
            preparedStatement.setInt(4, object.getWidth());
            preparedStatement.setInt(5, object.getHeight());
            preparedStatement.setFloat(6, object.getAssessedValue());
            preparedStatement.setObject(7, object.getId());
        } catch (SQLException e) {
            LOGGER.error("preparedStatementForUpdate ", e);
            throw new PersistentException(e);
        }
    }

}
