package com.germes.model.services.util;

import com.germes.exceptions.PersistentException;
import com.germes.exceptions.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionAccess {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConnectionAccess.class);
    private static final ConnectionAccess instance = new ConnectionAccess();
    private static DataSource dataSource;

    private ConnectionAccess() {
        try {
            InitialContext initialContext = new InitialContext();
            dataSource = (DataSource) initialContext.lookup("java:comp/env/jdbc/germes");
            LOGGER.info("Connection pool created successfully!");
        } catch (NamingException e) {
            LOGGER.error("Connection pool is not created!");
            LOGGER.error(e.getMessage());
        }
    }

    public static ConnectionAccess getInstance() {
        return instance;
    }

    public static <T> T connectionWrap(Instructions<T> command) throws ServiceException {
        try (Connection connection = dataSource.getConnection()) {
            return command.execute(connection);
        } catch (SQLException e) {
            LOGGER.error("Not get connection", e);
            throw new ServiceException(e);
        } catch (PersistentException e) {
            LOGGER.error("Something wrong at dao layer ", e);
            throw new ServiceException(e);
        }
    }

    // First try - return variable auto-commit to origin state
    // Second try - rollback if commit doesn't go through
    public static <T> T transactionWrap(Instructions<T> command) throws ServiceException {
        return connectionWrap(connection -> {
            try (AutoSetAutoCommit setAutoCommit = new AutoSetAutoCommit(connection, false)) {
                try (AutoRollback ar = new AutoRollback(connection)) {
                    T execute = command.execute(connection);
                    ar.commit();
                    return execute;
                }
            } catch (SQLException e) {
                LOGGER.error("", e); //TODO Add normal log message
                throw new ServiceException(e);
            }
        });
    }

}