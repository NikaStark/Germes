package com.germes.model.services.impl;

import com.germes.model.dao.UserDao;
import com.germes.model.entities.User;
import com.germes.model.services.UserService;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.util.UUID;

public class UserServiceImpl extends AbstractJDBCService<User, UUID, UserDao<Connection>> implements UserService {

    public UserServiceImpl(UserDao<Connection> dao) {
        super(dao);
        LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    }

}
