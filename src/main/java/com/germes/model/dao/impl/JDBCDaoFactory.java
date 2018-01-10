package com.germes.model.dao.impl;

import com.germes.model.dao.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class JDBCDaoFactory implements DaoFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(JDBCDaoFactory.class);
    private static final JDBCDaoFactory instance = new JDBCDaoFactory();
    private Map<Class, GenericDao> daoMap;

    private JDBCDaoFactory() {
        daoMap = new HashMap<>();
        daoMap.put(CountryDao.class, new CountryDaoImpl());
        LOGGER.info("Added implementation dao for " + CountryDao.class.getSimpleName());

        daoMap.put(CityDao.class, new CityDaoImpl());
        LOGGER.info("Added implementation dao for " + CityDao.class.getSimpleName());

        daoMap.put(BranchDao.class, new BranchDaoImpl());
        LOGGER.info("Added implementation dao for " + BranchDao.class.getSimpleName());

        daoMap.put(UserDao.class, new UserDaoImpl());
        LOGGER.info("Added implementation dao for " + UserDao.class.getSimpleName());

        daoMap.put(ParcelDao.class, new ParcelDaoImpl());
        LOGGER.info("Added implementation dao for " + ParcelDao.class.getSimpleName());

        daoMap.put(GoodsDao.class, new GoodsDaoImpl());
        LOGGER.info("Added implementation dao for " + GoodsDao.class.getSimpleName());

        daoMap.put(DeliveryDao.class, new DeliveryDaoImpl());
        LOGGER.info("Added implementation dao for " + DeliveryDao.class.getSimpleName());
    }

    public static JDBCDaoFactory getInstance() {
        return instance;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends GenericDao> T getDao(Class<T> daoEntityInterface) {
        LOGGER.info("Get dao of interface " + daoEntityInterface.getSimpleName());
        if (!daoMap.containsKey(daoEntityInterface)) {
            LOGGER.warn("Dao object for " + daoEntityInterface + " not found.");
            return null; //Maybe throwing exception be better
        }
        return (T) daoMap.get(daoEntityInterface);
    }

}
