package com.germes.model.dao.impl;

import com.germes.exceptions.PersistentException;
import com.germes.model.dao.ParcelDao;
import com.germes.model.entities.Parcel;
import com.germes.model.entities.enums.Status;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ParcelDaoImpl extends AbstractJDBCDao<Parcel, UUID> implements ParcelDao<Connection> {

    {
        LOGGER = LoggerFactory.getLogger(ParcelDaoImpl.class);
        SQL_FIND_ALL = "SELECT " + Parcel.ID_COLUMN + ", " + Parcel.SENDER_COLUMN + ", " + Parcel.RECEIVER_COLUMN + ", " + Parcel.BRANCH_SENDER_COLUMN + ", " + Parcel.BRANCH_RECEIVER_COLUMN + ", " + Parcel.ISSUE_DATE_COLUMN + ", " + Parcel.STATUS_COLUMN + ", " + Parcel.IS_PAID_COLUMN + ", " + Parcel.PRICE_TOTAL_COLUMN + " FROM " + Parcel.TABLE_NAME;
        SQL_FIND_BY_PK = SQL_FIND_ALL + " WHERE " + Parcel.ID_COLUMN + "=?";
        SQL_GET_COUNT = "SELECT count(*) AS " + Parcel.COUNT + " FROM " + Parcel.TABLE_NAME;
        SQL_INSERT = "INSERT INTO " + Parcel.TABLE_NAME + " (" + Parcel.ID_COLUMN + ", " + Parcel.SENDER_COLUMN + ", " + Parcel.RECEIVER_COLUMN + ", " + Parcel.BRANCH_SENDER_COLUMN + ", " + Parcel.BRANCH_RECEIVER_COLUMN + ", " + Parcel.ISSUE_DATE_COLUMN + ", " + Parcel.STATUS_COLUMN + ", " + Parcel.IS_PAID_COLUMN + ", " + Parcel.PRICE_TOTAL_COLUMN + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        SQL_UPDATE = "UPDATE " + Parcel.TABLE_NAME + " SET " + Parcel.SENDER_COLUMN + "=?, " + Parcel.RECEIVER_COLUMN + "=?, " + Parcel.BRANCH_SENDER_COLUMN + "=?, " + Parcel.BRANCH_RECEIVER_COLUMN + "=?, " + Parcel.ISSUE_DATE_COLUMN + "=?, " + Parcel.STATUS_COLUMN + "=?, " + Parcel.IS_PAID_COLUMN + "=?, " + Parcel.PRICE_TOTAL_COLUMN + "=? WHERE " + Parcel.ID_COLUMN + "=?";
        SQL_DELETE = "DELETE FROM " + Parcel.TABLE_NAME + " WHERE " + Parcel.ID_COLUMN + "=?";
    }

    ParcelDaoImpl() {
    }

    @Override
    protected List<Parcel> parseResultSet(ResultSet resultSet) throws PersistentException {
        List<Parcel> list = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Parcel parcel = new Parcel();
                parcel.setId(UUID.fromString(resultSet.getString(Parcel.ID_COLUMN)));
                parcel.setSender(UUID.fromString(resultSet.getString(Parcel.SENDER_COLUMN)));
                parcel.setReceiver(UUID.fromString(resultSet.getString(Parcel.RECEIVER_COLUMN)));
                parcel.setBranchSender(resultSet.getInt(Parcel.BRANCH_SENDER_COLUMN));
                parcel.setBranchReceiver(resultSet.getInt(Parcel.BRANCH_RECEIVER_COLUMN));
                parcel.setIssueDate(resultSet.getTimestamp(Parcel.ISSUE_DATE_COLUMN)); //TODO Probably be mistake
                parcel.setStatus(Status.valueOf(resultSet.getString(Parcel.STATUS_COLUMN)));
                parcel.setIsPaid(resultSet.getBoolean(Parcel.IS_PAID_COLUMN));
                parcel.setPriceTotal(resultSet.getFloat(Parcel.PRICE_TOTAL_COLUMN));
                list.add(parcel);
            }
        } catch (SQLException e) {
            LOGGER.error("parseResultSet ", e);
            throw new PersistentException(e);
        }
        return list;
    }

    @Override
    protected void parseResultSetGeneratedKeys(ResultSet generatedKeys, Parcel object) throws PersistentException {
        // This is mock, there is no need for this method because key for this entity generated on client side
    }

    @Override
    protected int parseResultSetCount(ResultSet resultSet) throws PersistentException {
        int count = 0;
        try {
            if (resultSet.next()) {
                count = resultSet.getInt(Parcel.COUNT);
            }
        } catch (SQLException e) {
            LOGGER.error("parseResultSetCount ", e);
            throw new PersistentException(e);
        }
        return count;
    }

    @Override
    protected void preparedStatementForInsert(PreparedStatement preparedStatement, Parcel object) throws PersistentException {
        try {
            preparedStatement.setObject(1, object.getId());
            preparedStatement.setObject(2, object.getSender());
            preparedStatement.setObject(3, object.getReceiver());
            preparedStatement.setInt(4, object.getBranchSender());
            preparedStatement.setInt(5, object.getBranchReceiver());
            preparedStatement.setTimestamp(6, new Timestamp(object.getIssueDate().getTime())); //TODO Probably be mistake
            preparedStatement.setString(7, object.getStatus().toString());
            preparedStatement.setBoolean(8, object.getIsPaid());
            preparedStatement.setFloat(9, object.getPriceTotal());
        } catch (SQLException e) {
            LOGGER.error("preparedStatementForInsert ", e);
            throw new PersistentException(e);
        }
    }

    @Override
    protected void preparedStatementForUpdate(PreparedStatement preparedStatement, Parcel object) throws PersistentException {
        try {
            preparedStatement.setObject(1, object.getSender());
            preparedStatement.setObject(2, object.getReceiver());
            preparedStatement.setInt(3, object.getBranchSender());
            preparedStatement.setInt(4, object.getBranchReceiver());
            preparedStatement.setTimestamp(5, new Timestamp(object.getIssueDate().getTime())); //TODO Probably be mistake
            preparedStatement.setString(6, object.getStatus().toString());
            preparedStatement.setBoolean(7, object.getIsPaid());
            preparedStatement.setFloat(8, object.getPriceTotal());
            preparedStatement.setObject(9, object.getId());
        } catch (SQLException e) {
            LOGGER.error("preparedStatementForUpdate ", e);
            throw new PersistentException(e);
        }
    }

}
