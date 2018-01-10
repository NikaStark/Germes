package com.germes.model.dao;

public interface DaoFactory {

    <T extends GenericDao> T getDao(Class<T> daoEntityInterfaceImpl);

}
