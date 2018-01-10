package com.germes.model.services;

public interface ServiceFactory {

    <T extends GenericService> T getService(Class<T> serviceEntityInterfaceImpl);

}