package com.germes.model.services.impl;

import com.germes.model.dao.DaoFactory;
import com.germes.model.dao.impl.*;
import com.germes.model.services.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class JDBCServiceFactory implements ServiceFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(JDBCServiceFactory.class);
    private static final JDBCServiceFactory instance = new JDBCServiceFactory(JDBCDaoFactory.getInstance());
    private Map<Class, GenericService> servicesMap;

    private JDBCServiceFactory(DaoFactory daoFactory) {
        servicesMap = new HashMap<>();
        servicesMap.put(CountryService.class, new CountryServiceImpl(daoFactory.getDao(CountryDaoImpl.class)));
        LOGGER.info("Added implementation service for " + CountryService.class.getSimpleName());

        servicesMap.put(CityServiceImpl.class, new CityServiceImpl(daoFactory.getDao(CityDaoImpl.class)));
        LOGGER.info("Added implementation service for " + CityService.class.getSimpleName());

        servicesMap.put(BranchServiceImpl.class, new BranchServiceImpl(daoFactory.getDao(BranchDaoImpl.class)));
        LOGGER.info("Added implementation service for " + BranchService.class.getSimpleName());

        servicesMap.put(UserServiceImpl.class, new UserServiceImpl(daoFactory.getDao(UserDaoImpl.class)));
        LOGGER.info("Added implementation service for " + UserService.class.getSimpleName());

        servicesMap.put(ParcelServiceImpl.class, new ParcelServiceImpl(daoFactory.getDao(ParcelDaoImpl.class)));
        LOGGER.info("Added implementation service for " + ParcelService.class.getSimpleName());

        servicesMap.put(GoodsServiceImpl.class, new GoodsServiceImpl(daoFactory.getDao(GoodsDaoImpl.class)));
        LOGGER.info("Added implementation service for " + GoodsService.class.getSimpleName());

        servicesMap.put(DeliveryServiceImpl.class, new DeliveryServiceImpl(daoFactory.getDao(DeliveryDaoImpl.class)));
        LOGGER.info("Added implementation service for " + DeliveryService.class.getSimpleName());
    }

    public static JDBCServiceFactory getInstance() {
        return instance;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends GenericService> T getService(Class<T> serviceEntityInterfaceImpl) {
        LOGGER.info("Get service implementation " + serviceEntityInterfaceImpl.getSimpleName());
        if (!servicesMap.containsKey(serviceEntityInterfaceImpl)) {
            LOGGER.warn("Service instance of " + serviceEntityInterfaceImpl.getSimpleName() + " not found.");
            return null; //Maybe throwing exception be better
        }
        return (T) servicesMap.get(serviceEntityInterfaceImpl);
    }

}
