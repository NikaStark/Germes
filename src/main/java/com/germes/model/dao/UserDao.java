package com.germes.model.dao;

import com.germes.exceptions.PersistentException;
import com.germes.model.entities.User;

import java.util.UUID;

public interface UserDao<Context> extends GenericDao<User, UUID, Context> {

    User authentication(String username, String password, Context context) throws PersistentException;

}
