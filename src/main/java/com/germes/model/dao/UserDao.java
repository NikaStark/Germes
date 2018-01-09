package com.germes.model.dao;

import com.germes.model.entities.User;

import java.util.UUID;

public interface UserDao<Context> extends GenericDao<User, UUID, Context> {
}
