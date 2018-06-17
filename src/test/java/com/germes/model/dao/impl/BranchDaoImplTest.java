package com.germes.model.dao.impl;

import com.germes.model.entities.Branch;
import org.junit.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class BranchDaoImplTest extends AbstractJDBCDaoTest {

    BranchDaoImpl branchDao = JDBCDaoFactory.getInstance().getDao(BranchDaoImpl.class);

    @Test
    public void testCreate() throws Exception {
        final Branch branch = new Branch(2, "West 182nd Street", "27-49");
        branchDao.create(branch, connection);
        PreparedStatement preparedStatement = connection.prepareStatement(branchDao.SQL_FIND_BY_PK);
        preparedStatement.setObject(1, branch.getId());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            assertEquals(branch.getId(), (Integer) resultSet.getInt(Branch.ID_COLUMN));
            assertEquals(branch.getCity(), (Integer) resultSet.getInt(Branch.CITY_COLUMN));
            assertEquals(branch.getStreet(), resultSet.getString(Branch.STREET_COLUMN));
            assertEquals(branch.getStreetNumber(), resultSet.getString(Branch.STREET_NUMBER_COLUMN));
        } else {
            fail();
        }
    }

    @Test
    public void testGetByPK() throws Exception {
        final Branch branch = branchDao.getByPK(1, connection);
        assertNotNull(branch);
        assertEquals(new Integer(1), branch.getCity());
        assertEquals("Porter Street Northwest", branch.getStreet());
        assertEquals("3523", branch.getStreetNumber());

        final Branch branchEmpty = new Branch(0, null, null);
        assertNull(branchDao.getByPK(branchEmpty.getId(), connection));
    }

    @Test
    public void testGetCount() throws Exception {
        final int count = branchDao.getCount(connection);
        assertEquals(6, count);
    }

    @Test
    public void testUpdate() throws Exception {
        final Branch branch = new Branch(5, "IVD-8411", "21");
        branch.setId(6);
        branchDao.update(branch, connection);
        PreparedStatement preparedStatement = connection.prepareStatement(branchDao.SQL_FIND_BY_PK);
        preparedStatement.setObject(1, branch.getId());
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            assertEquals("IVD-8411", resultSet.getString(Branch.STREET_COLUMN));
            assertEquals("21", resultSet.getString(Branch.STREET_NUMBER_COLUMN));
        }
    }

    @Test
    public void testDelete() throws Exception {
        final Branch branch = new Branch(5, "Знаменка улица", "13");
        branch.setId(6);
        branchDao.delete(branch, connection);
        PreparedStatement preparedStatement = connection.prepareStatement(branchDao.SQL_FIND_BY_PK);
        preparedStatement.setObject(1, branch.getId());
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            assertNull(resultSet.getString(Branch.CITY_COLUMN));
            assertNull(resultSet.getString(Branch.STREET_NUMBER_COLUMN));
        }
    }

    @Test
    public void testGetAll() throws Exception {
        List<Branch> expectedList = Arrays.asList(
                new Branch(1, "Porter Street Northwest", "3523"),
                new Branch(2, "49th Street", "4109"),
                new Branch(2, "West 182nd Street", "27-49"),
                new Branch(3, "вулиця Велика Васильківська", "100a"),
                new Branch(4, "Головківська вулиця", "25"),
                new Branch(5, "Знаменка улица", "13"));
        expectedList.get(0).setId(1);
        expectedList.get(1).setId(2);
        expectedList.get(2).setId(3);
        expectedList.get(3).setId(4);
        expectedList.get(4).setId(5);
        expectedList.get(5).setId(6);
        List<Branch> actualList = branchDao.getAll(connection);
        assertEquals(expectedList.size(), actualList.size());
        for (int i = 0; i < expectedList.size(); i++) {
            assertEquals(expectedList.get(i).getId(), actualList.get(i).getId());
            assertEquals(expectedList.get(i).getCity(), actualList.get(i).getCity());
            assertEquals(expectedList.get(i).getStreet(), actualList.get(i).getStreet());
            assertEquals(expectedList.get(i).getStreetNumber(), actualList.get(i).getStreetNumber());
        }
    }

    @Test
    public void testGetAllLimit() throws Exception {
        List<Branch> expectedList = Arrays.asList(
                new Branch(3, "вулиця Велика Васильківська", "100a"),
                new Branch(4, "Головківська вулиця", "25"));
        expectedList.get(0).setId(4);
        expectedList.get(1).setId(5);
        List<Branch> actualList = branchDao.getAllLimit(2, 3, connection);
        assertEquals(expectedList.size(), actualList.size());
        for (int i = 0; i < expectedList.size(); i++) {
            assertEquals(expectedList.get(i).getId(), actualList.get(i).getId());
            assertEquals(expectedList.get(i).getCity(), actualList.get(i).getCity());
            assertEquals(expectedList.get(i).getStreet(), actualList.get(i).getStreet());
            assertEquals(expectedList.get(i).getStreetNumber(), actualList.get(i).getStreetNumber());
        }
    }

}