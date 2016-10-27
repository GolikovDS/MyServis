package ru.gds.dao.impl;

import ru.gds.Exception.NameExist;
import ru.gds.dao.config.JdbcConnect;
import ru.gds.dao.config.JdbcPoolConnectC3PO;
import ru.gds.dao.config.SqlQuery;
import ru.gds.dao.interfaces.ComponentsDao;
import ru.gds.entitys.ComponentsEntity;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ComponentDaoImpl extends AbstractDao<ComponentsEntity> implements ComponentsDao {


    @Override
    public void insert(String name, Date receiptData, int pieces) throws SQLException, IOException, PropertyVetoException {
        try (Connection connection = JdbcPoolConnectC3PO.getInstance().getConnection()) {
            connection.setTransactionIsolation(java.sql.Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            try (PreparedStatement statement = connection.prepareStatement(SqlQuery.ADD_COMPONENT)) {
                statement.setString(1, name);
                statement.setDate(2, new java.sql.Date(receiptData.getTime()));
                statement.setInt(3, pieces);
                statement.executeUpdate();
                connection.commit();
            }
        } finally {
            JdbcConnect.closeConnection();
        }
    }

    @Override
    public void update(int id, String name, Date receiptData, int pieces) throws SQLException, IOException, PropertyVetoException {
        try (Connection connection = JdbcPoolConnectC3PO.getInstance().getConnection()) {
            connection.setTransactionIsolation(java.sql.Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            try (PreparedStatement statement = connection.prepareStatement(SqlQuery.UPDATE_COMPONENT)) {
                statement.setString(1, name);
                statement.setDate(2, new java.sql.Date(receiptData.getTime()));
                statement.setInt(3, pieces);
                statement.setInt(4, id);
                statement.executeUpdate();
                connection.commit();
            }
        } finally {
            JdbcConnect.closeConnection();
        }
    }

    @Override
    public ArrayList<ComponentsEntity> searchByName(String name) throws SQLException, IOException, PropertyVetoException {
        ArrayList<ComponentsEntity> arrayListComponents = new ArrayList<>();
        try (Connection connection = JdbcPoolConnectC3PO.getInstance().getConnection()) {
            connection.setTransactionIsolation(java.sql.Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            try (PreparedStatement statement = connection.prepareStatement(SqlQuery.SELECT_BY_NAME_COMPONENT)) {
                statement.setString(1, "%" + name + "%");
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        arrayListComponents.add(new ComponentsEntity(resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getDate(3), resultSet.getInt(4), resultSet.getInt(5)));
                    }
                    connection.commit();
                }
            }
        } finally {
            JdbcConnect.closeConnection();
        }
        return arrayListComponents;
    }

    @Override
    public void remove(int id) throws SQLException, IOException, PropertyVetoException {
        updateById(id, SqlQuery.REMOVE_COMPONENT);
    }

    @Override
    public void add(ComponentsEntity componentsEntity) throws SQLException, PropertyVetoException, IOException, NameExist {
        add(new Insertion<ComponentsEntity>(componentsEntity) {
            @Override
            public void insertionOne(PreparedStatement statement) throws SQLException {
                statement.setString(1, t.getName());
                statement.setDate(2, new java.sql.Date(t.getReceiptData().getTime()));
                statement.setInt(3, t.getPieces());
            }

            @Override
            protected boolean isExist(Connection connection) {
                return false;
            }
        }, SqlQuery.ADD_COMPONENT);
    }

    @Override
    public List<ComponentsEntity> selectAll() throws SQLException, IOException, PropertyVetoException {
        return selectAll(SqlQuery.COMPONENT_GET_ALL, new Extractor<ComponentsEntity>() {
            @Override
            public ComponentsEntity extractOne(ResultSet resultSet) throws SQLException {
                return new ComponentsEntity(resultSet.getInt(1), resultSet.getString(2), resultSet.getDate(3),
                        resultSet.getInt(4), resultSet.getInt(5));
            }
        });
    }
}
