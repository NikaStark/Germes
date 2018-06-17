package com.germes.model.dao.impl;

import com.germes.exceptions.PersistentException;
import com.germes.model.dao.GoodsDao;
import com.germes.model.entities.Goods;
import com.germes.model.entities.Parcel;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class GoodsDaoImpl extends AbstractJDBCDao<Goods, UUID> implements GoodsDao<Connection> {

    {
        LOGGER = LoggerFactory.getLogger(GoodsDaoImpl.class);
        SQL_FIND_ALL = "SELECT " + Goods.ID_COLUMN + ", " + Goods.PARCEL_COLUMN + ", " + Goods.WEIGHT_COLUMN + ", " + Goods.LENGTH_COLUMN + ", " + Goods.WIDTH_COLUMN + ", " + Goods.HEIGHT_COLUMN + ", " + Goods.ASSESSED_VALUE_COLUMN + " FROM " + Goods.TABLE_NAME;
        SQL_FIND_ALL_LIMIT = SQL_FIND_ALL + " LIMIT ? OFFSET ?";
        SQL_FIND_BY_PK = SQL_FIND_ALL + " WHERE " + Goods.ID_COLUMN + "=?";
        SQL_GET_COUNT = "SELECT count(*) AS " + Goods.COUNT + " FROM " + Goods.TABLE_NAME;
        SQL_INSERT = "INSERT INTO " + Goods.TABLE_NAME + " (" + Goods.ID_COLUMN + ", " + Goods.PARCEL_COLUMN + ", " + Goods.WEIGHT_COLUMN + ", " + Goods.LENGTH_COLUMN + ", " + Goods.WIDTH_COLUMN + ", " + Goods.HEIGHT_COLUMN + ", " + Goods.ASSESSED_VALUE_COLUMN + ") VALUES (?, ?, ?, ?, ?, ?, ?)";
        SQL_UPDATE = "UPDATE " + Goods.TABLE_NAME + " SET " + Goods.PARCEL_COLUMN + "=?, " + Goods.WEIGHT_COLUMN + "=?, " + Goods.LENGTH_COLUMN + "=?, " + Goods.WIDTH_COLUMN + "=?, " + Goods.HEIGHT_COLUMN + "=?, " + Goods.ASSESSED_VALUE_COLUMN + "=? WHERE " + Goods.ID_COLUMN + "=?";
        SQL_DELETE = "DELETE FROM " + Goods.TABLE_NAME + " WHERE " + Goods.ID_COLUMN + "=?";
    }

    private String SQL_QUERY_TO_PARCELS_TABLE = "SELECT " + Parcel.ID_COLUMN + " FROM " + Parcel.TABLE_NAME + " WHERE " + Parcel.RECEIVER_COLUMN + "=?";
    private String SQL_FIND_ALL_LIMIT_WHERE_PK = SQL_FIND_ALL + " WHERE " + Goods.PARCEL_COLUMN + " IN (" + SQL_QUERY_TO_PARCELS_TABLE + ") LIMIT ? OFFSET ?";
    private String SQL_GET_COUNT_WHERE_PK = SQL_GET_COUNT + " WHERE " + Goods.PARCEL_COLUMN + " IN (" + SQL_QUERY_TO_PARCELS_TABLE + ")";

    GoodsDaoImpl() {
    }

    @Override
    public int getCountWherePK(UUID key, Connection connection) throws PersistentException {
        int count;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_COUNT_WHERE_PK)) {
            preparedStatement.setObject(1, key);
            ResultSet resultSet = preparedStatement.executeQuery();
            count = parseResultSetCount(resultSet);
        } catch (SQLException e) {
            LOGGER.error("getCountWherePK", e);
            throw new PersistentException(e);
        }
        return count;
    }

    @Override
    public List<Goods> getAllLimitWherePK(UUID key, int limit, int offset, Connection connection) throws PersistentException {
        List<Goods> list;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_ALL_LIMIT_WHERE_PK)) {
            preparedStatement.setObject(1, key);
            preparedStatement.setInt(2, limit);
            preparedStatement.setInt(3, offset);
            ResultSet resultSet = preparedStatement.executeQuery();
            list = parseResultSet(resultSet);
        } catch (SQLException e) {
            LOGGER.error("getAllLimitWherePK", e);
            throw new PersistentException(e);
        }
        return Objects.nonNull(list) ? list : Collections.<Goods>emptyList();
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
    protected int parseResultSetCount(ResultSet resultSet) throws PersistentException {
        int count = 0;
        try {
            if (resultSet.next()) {
                count = resultSet.getInt(Goods.COUNT);
            }
        } catch (SQLException e) {
            LOGGER.error("parseResultSetCount ", e);
            throw new PersistentException(e);
        }
        return count;
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
