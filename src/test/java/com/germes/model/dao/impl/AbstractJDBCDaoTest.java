package com.germes.model.dao.impl;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class AbstractJDBCDaoTest {

    protected static Logger logger = LoggerFactory.getLogger(AbstractJDBCDaoTest.class);
    protected static Connection connection;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(new File("src/test/resources/db.properties")));
            connection = DriverManager.getConnection(properties.getProperty("url"), properties);
            logger.info("Connection established successfully!");
        } catch (IOException e) {
            logger.warn("Not found file - db.properties!");
        } catch (SQLException e) {
            logger.warn("Connection established failed!");
        }
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        try {
            connection.close();
            logger.info("Connection closed successfully!");
        } catch (SQLException e) {
            logger.warn("Connection closed failed!");
        }
    }

    @Before
    public void setUp() throws Exception {
        executeSqlScript(connection, new File("src/test/resources/scripts/fill-database.sql"));
        logger.info("Database prepared successfully!");
    }

    @After
    public void tearDown() throws Exception {
        executeSqlScript(connection, new File("src/test/resources/scripts/delete-records.sql"));
        logger.info("Tables cleared successfully!");
    }

    private void executeSqlScript(Connection connection, File inputFile) {
        String delimiter = ";";
        try (Scanner scanner = new Scanner(inputFile).useDelimiter(delimiter);
             Statement statement = connection.createStatement()) {
            while (scanner.hasNext()) {
                statement.execute(scanner.next() + delimiter);
            }
        } catch (FileNotFoundException e) {
            logger.warn("Not found file [" + inputFile.getName() + "]");
        } catch (SQLException e) {
            logger.warn("SQLException at run script [" + inputFile.getName() + "]");
        }
    }

}