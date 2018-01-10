package com.germes.model.services.impl;

import com.germes.model.dao.BranchDao;
import com.germes.model.entities.Branch;
import com.germes.model.services.BranchService;
import org.slf4j.LoggerFactory;

import java.sql.Connection;

public class BranchServiceImpl extends AbstractJDBCService<Branch, Integer, BranchDao<Connection>> implements BranchService {

    public BranchServiceImpl(BranchDao<Connection> dao) {
        super(dao);
        LOGGER = LoggerFactory.getLogger(BranchServiceImpl.class);
    }

}
