package com.germes.model.dao.impl;

import com.germes.exceptions.PersistentException;
import com.germes.model.dao.UserDao;
import com.germes.model.entities.User;
import com.germes.model.entities.enums.Role;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserDaoImpl extends AbstractJDBCDao<User, UUID> implements UserDao<Connection> {

    {
        LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);
        SQL_FIND_ALL = "SELECT " + User.ID_COLUMN + ", " + User.USERNAME_COLUMN + ", " + User.PASSWORD_COLUMN + ", " + User.EMAIL_COLUMN + ", " + User.FIRST_NAME_COLUMN + ", " + User.LAST_NAME_COLUMN + ", " + User.ROLE_COLUMN + " FROM " + User.TABLE_NAME;
        SQL_FIND_BY_PK = SQL_FIND_ALL + " WHERE " + User.ID_COLUMN + "=?";
        SQL_INSERT = "INSERT INTO " + User.TABLE_NAME + " (" + User.ID_COLUMN + ", " + User.USERNAME_COLUMN + ", " + User.PASSWORD_COLUMN + ", " + User.EMAIL_COLUMN + ", " + User.FIRST_NAME_COLUMN + ", " + User.LAST_NAME_COLUMN + ", " + User.ROLE_COLUMN + ") VALUES (?, ?, ?, ?)";
        SQL_UPDATE = "UPDATE " + User.TABLE_NAME + " SET " + User.USERNAME_COLUMN + "=?, " + User.PASSWORD_COLUMN + "=?, " + User.EMAIL_COLUMN + "=?, " + User.FIRST_NAME_COLUMN + "=?, " + User.LAST_NAME_COLUMN + "=?, " + User.ROLE_COLUMN + "=? WHERE " + User.ID_COLUMN + "=?";
        SQL_DELETE = "DELETE FROM " + User.TABLE_NAME + " WHERE " + User.ID_COLUMN + "=?";
    }

    UserDaoImpl() {
    }

    @Override
    protected List<User> parseResultSet(ResultSet resultSet) throws PersistentException {
        List<User> list = new ArrayList<>();
        try {
            while (resultSet.next()) {
                User user = new User();
                user.setId(UUID.fromString(resultSet.getString(User.ID_COLUMN)));
                user.setUsername(resultSet.getString(User.USERNAME_COLUMN));
                user.setPassword(resultSet.getString(User.PASSWORD_COLUMN));
                user.setEmail(resultSet.getString(User.EMAIL_COLUMN));
                user.setFirstName(resultSet.getString(User.FIRST_NAME_COLUMN));
                user.setLastName(resultSet.getString(User.LAST_NAME_COLUMN));
                user.setRole(Role.valueOf(resultSet.getString(User.ROLE_COLUMN)));
                list.add(user);
            }
        } catch (SQLException e) {
            LOGGER.error("parseResultSet ", e);
            throw new PersistentException(e);
        }
        return list;
    }

    @Override
    protected void parseResultSetGeneratedKeys(ResultSet generatedKeys, User object) throws PersistentException {
        // This is mock, there is no need for this method because key for this entity generated on client side
    }

    @Override
    protected void preparedStatementForInsert(PreparedStatement preparedStatement, User object) throws PersistentException {
        try {
            preparedStatement.setObject(1, object.getId());
            preparedStatement.setString(2, object.getUsername());
            preparedStatement.setString(3, object.getPassword());
            preparedStatement.setString(4, object.getEmail());
            preparedStatement.setString(5, object.getFirstName());
            preparedStatement.setString(6, object.getLastName());
            preparedStatement.setString(7, object.getRole().toString());
        } catch (SQLException e) {
            LOGGER.error("preparedStatementForInsert ", e);
            throw new PersistentException(e);
        }
    }

    @Override
    protected void preparedStatementForUpdate(PreparedStatement preparedStatement, User object) throws PersistentException {
        try {
            preparedStatement.setString(1, object.getUsername());
            preparedStatement.setString(2, object.getPassword());
            preparedStatement.setString(3, object.getEmail());
            preparedStatement.setString(4, object.getFirstName());
            preparedStatement.setString(5, object.getLastName());
            preparedStatement.setString(6, object.getRole().toString());
            preparedStatement.setObject(7, object.getId());
        } catch (SQLException e) {
            LOGGER.error("preparedStatementForUpdate ", e);
            throw new PersistentException(e);
        }
    }

}
