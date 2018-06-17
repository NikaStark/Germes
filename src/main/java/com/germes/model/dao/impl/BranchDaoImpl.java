package com.germes.model.dao.impl;

import com.germes.exceptions.PersistentException;
import com.germes.model.dao.BranchDao;
import com.germes.model.entities.Branch;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BranchDaoImpl extends AbstractJDBCDao<Branch, Integer> implements BranchDao<Connection> {

    {
        LOGGER = LoggerFactory.getLogger(BranchDaoImpl.class);
        SQL_FIND_ALL = "SELECT " + Branch.ID_COLUMN + ", " + Branch.CITY_COLUMN + ", " + Branch.STREET_COLUMN + ", " + Branch.STREET_NUMBER_COLUMN + " FROM " + Branch.TABLE_NAME;
        SQL_FIND_ALL_LIMIT = SQL_FIND_ALL + " LIMIT ? OFFSET ?";
        SQL_FIND_BY_PK = SQL_FIND_ALL + " WHERE " + Branch.ID_COLUMN + "=?";
        SQL_GET_COUNT = "SELECT count(*) AS " + Branch.COUNT + " FROM " + Branch.TABLE_NAME;
        SQL_INSERT = "INSERT INTO " + Branch.TABLE_NAME + " (" + Branch.CITY_COLUMN + ", " + Branch.STREET_COLUMN + ", " + Branch.STREET_NUMBER_COLUMN + ") VALUES (?, ?, ?)";
        SQL_UPDATE = "UPDATE " + Branch.TABLE_NAME + " SET " + Branch.CITY_COLUMN + "=?, " + Branch.STREET_COLUMN + "=?, " + Branch.STREET_NUMBER_COLUMN + "=? WHERE " + Branch.ID_COLUMN + "=?";
        SQL_DELETE = "DELETE FROM " + Branch.TABLE_NAME + " WHERE " + Branch.ID_COLUMN + "=?";
    }

    BranchDaoImpl() {
    }

    @Override
    protected List<Branch> parseResultSet(ResultSet resultSet) throws PersistentException {
        List<Branch> list = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Branch branch = new Branch();
                branch.setId(resultSet.getInt(Branch.ID_COLUMN));
                branch.setCity(resultSet.getInt(Branch.CITY_COLUMN));
                branch.setStreet(resultSet.getString(Branch.STREET_COLUMN));
                branch.setStreetNumber(resultSet.getString(Branch.STREET_NUMBER_COLUMN));
                list.add(branch);
            }
        } catch (SQLException e) {
            LOGGER.error("parseResultSet ", e);
            throw new PersistentException(e);
        }
        return list;
    }

    @Override
    protected void parseResultSetGeneratedKeys(ResultSet generatedKeys, Branch object) throws PersistentException {
        try {
            if (generatedKeys.next()) {
                object.setId(generatedKeys.getInt(Branch.ID_COLUMN));
            }
        } catch (SQLException e) {
            try {
                object.setId(generatedKeys.getInt(1));
            } catch (SQLException e1) {
                LOGGER.error("parseResultSetGeneratedKeys ", e1);
                throw new PersistentException(e1);
            }
        }
    }

    @Override
    protected int parseResultSetCount(ResultSet resultSet) throws PersistentException {
        int count = 0;
        try {
            if (resultSet.next()) {
                count = resultSet.getInt(Branch.COUNT);
            }
        } catch (SQLException e) {
            LOGGER.error("parseResultSetCount ", e);
            throw new PersistentException(e);
        }
        return count;
    }

    @Override
    protected void preparedStatementForInsert(PreparedStatement preparedStatement, Branch object) throws PersistentException {
        try {
            preparedStatement.setInt(1, object.getCity());
            preparedStatement.setString(2, object.getStreet());
            preparedStatement.setString(3, object.getStreetNumber());
        } catch (SQLException e) {
            LOGGER.error("preparedStatementForInsert ", e);
            throw new PersistentException(e);
        }
    }

    @Override
    protected void preparedStatementForUpdate(PreparedStatement preparedStatement, Branch object) throws PersistentException {
        try {
            preparedStatement.setInt(1, object.getCity());
            preparedStatement.setString(2, object.getStreet());
            preparedStatement.setString(3, object.getStreetNumber());
            preparedStatement.setInt(4, object.getId());
        } catch (SQLException e) {
            LOGGER.error("preparedStatementForUpdate ", e);
            throw new PersistentException(e);
        }
    }

}
