package ru.gds.dao.impl;

import ru.gds.Exception.NameExist;
import ru.gds.dao.config.JdbcPoolConnectC3PO;
import ru.gds.dao.config.SqlQuery;
import ru.gds.dao.interfaces.ComponentsGroupDao;
import ru.gds.entitys.ComponentsEntity;
import ru.gds.entitys.ComponentsGroupEntity;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ComponentGroupDaoImpl extends AbstractDao<ComponentsGroupEntity> implements ComponentsGroupDao {


    @Override
    public void insert(String name, int pieces) throws SQLException, IOException, PropertyVetoException, NameExist {
        add(new ComponentsGroupEntity(name));
    }

    @Override
    public void update(int id, String name, Date receiptData, int pieces) throws
            SQLException, IOException, PropertyVetoException {
        try (Connection connection = JdbcPoolConnectC3PO.getInstance().getConnection()) {
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            try (PreparedStatement statement = connection.prepareStatement(SqlQuery.UPDATE_COMPONENT_GROUP)) {
                statement.setString(1, name);
                statement.setDate(2, new java.sql.Date(receiptData.getTime()));
                statement.setInt(3, pieces);
                statement.setInt(4, id);
                statement.executeUpdate();
                connection.commit();
            }
        }
    }

    @Override
    public ArrayList<ComponentsEntity> searchByName(String name) throws
            SQLException, IOException, PropertyVetoException {
        ArrayList<ComponentsEntity> arrayListComponents = new ArrayList<>();
        try (Connection connection = JdbcPoolConnectC3PO.getInstance().getConnection()) {
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            try (PreparedStatement statement = connection.prepareStatement(SqlQuery.SELECT_BY_NAME_COMPONENT_GROUP)) {
                statement.setString(1, "%" + name + "%");
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        arrayListComponents.add(new ComponentsEntity(resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getDate(3), resultSet.getInt(4), resultSet.getInt(5)));
                    }
                    connection.commit();
                }
            }
        }
        return arrayListComponents;
    }

    @Override
    public void remove(int id) throws SQLException, IOException, PropertyVetoException {
        updateById(id, SqlQuery.REMOVE_COMPONENT_GROUP);
    }

    @Override
    public void add(ComponentsGroupEntity componentsGroupEntity) throws
            SQLException, PropertyVetoException, IOException, NameExist {
        add(new Insertion<ComponentsGroupEntity>(componentsGroupEntity) {
            @Override
            public void insertionOne(PreparedStatement statement) throws SQLException {
                statement.setString(1, t.getName());
                statement.setInt(2, t.getPieces());
            }

            @Override
            protected boolean isExist(Connection connection) {
                try (PreparedStatement statement = connection.prepareStatement(SqlQuery.COMPONENT_GROUP_IS_EXIST_NAME)) {
                    statement.setString(1, t.getName());
                    try (ResultSet resultSet = statement.executeQuery()) {
                        return resultSet.next();
                    }
                } catch (SQLException e) {
                    return false;
                }
            }
        }, SqlQuery.ADD_COMPONENT_GROUP);
    }

    @Override
    public List<ComponentsGroupEntity> selectAll() throws SQLException, IOException, PropertyVetoException {
        return selectAll(SqlQuery.COMPONENT_GROUP_GET_ALL, new Extractor<ComponentsGroupEntity>() {
            @Override
            public ComponentsGroupEntity extractOne(ResultSet resultSet) throws SQLException {
                return new ComponentsGroupEntity(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
            }
        });
    }
}
