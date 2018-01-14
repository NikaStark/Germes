package com.germes.model.services;

import com.germes.exceptions.ServiceException;
import com.germes.model.entities.User;

import java.util.UUID;

public interface UserService extends GenericService<User, UUID> {

    User authentication(String username, String password) throws ServiceException;

}
