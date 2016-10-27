package ru.gds.dao.impl;

import ru.gds.Exception.NameExist;
import ru.gds.dao.config.JdbcPoolConnectC3PO;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public abstract class AbstractDao<T> {
    private T t;

    protected List<T> selectAll(String sqlQuery, Extractor<T> extractor) throws SQLException, IOException, PropertyVetoException {
        List<T> result = new ArrayList<>();
        try (Connection connection = JdbcPoolConnectC3PO.getInstance().getConnection()) {
            connection.setTransactionIsolation(java.sql.Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sqlQuery)) {
                    while (resultSet.next()) {
                        T record = extractor.extractOne(resultSet);
                        result.add(record);
                    }
                }
            }
        }
        return result;
    }

    protected List<T> selectByName(String sqlQuery, String name, Extractor<T> extractor) throws SQLException, IOException, PropertyVetoException {
        List<T> result = new ArrayList<>();
        try (Connection connection = JdbcPoolConnectC3PO.getInstance().getConnection()) {
            connection.setTransactionIsolation(java.sql.Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                preparedStatement.setString(1, name);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        T record = extractor.extractOne(resultSet);
                        result.add(record);
                    }
                }
            }
        }
        return result;
    }

    protected int getIdByName(String name, String sqlQuery) throws PropertyVetoException, SQLException, IOException {
        int id = 0;
        try (Connection connection = JdbcPoolConnectC3PO.getInstance().getConnection()) {
            connection.setTransactionIsolation(java.sql.Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                preparedStatement.setString(1, name);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    resultSet.next();
                    id = resultSet.getInt(1);
                }
            }
        }
        return id;
    }

    protected String getJsessionidByName(String name, String sqlQuery) throws PropertyVetoException, SQLException, IOException {
        String id = "";
        try (Connection connection = JdbcPoolConnectC3PO.getInstance().getConnection()) {
            connection.setTransactionIsolation(java.sql.Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                preparedStatement.setString(1, name);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    resultSet.next();
                    id = resultSet.getString(1);
                }
            }
        }
        return id;
    }

    protected void add(Insertion<T> insertion, String sqlQuery) throws PropertyVetoException, SQLException, IOException, NameExist {
        try (Connection connection = JdbcPoolConnectC3PO.getInstance().getConnection()) {
            connection.setTransactionIsolation(java.sql.Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            if (insertion.isExist(connection)) {
                throw new NameExist();
            }
            try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
                insertion.insertionOne(statement);
                statement.executeUpdate();
                connection.commit();
            }
        }
    }

    protected void updateRowById(final int id, final String nameRow, String sqlQuery) throws SQLException, IOException, PropertyVetoException {
        connectPreparedStatement(sqlQuery, new Insertion<T>(t) {
            @Override
            public void insertionOne(PreparedStatement statement) throws SQLException {
                statement.setString(1, nameRow);
                statement.setInt(2, id);
                statement.executeUpdate();
            }

            @Override
            protected boolean isExist(Connection connection) {
                return false;
            }
        });
    }

    protected void updateRowByName(final String name, final String nameRow, String sqlQuery)
            throws SQLException, IOException, PropertyVetoException {

        connectPreparedStatement(sqlQuery, new Insertion<T>(t) {
            @Override
            public void insertionOne(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, nameRow);
                preparedStatement.setString(2, name);
                preparedStatement.executeUpdate();
            }

            @Override
            protected boolean isExist(Connection connection) {
                return false;
            }
        });

    }

    protected void updateById(int id, String sqlQuery) {

    }

    private void connectPreparedStatement(String sqlQuery, Insertion insertion) throws SQLException, IOException, PropertyVetoException {
        try (Connection connection = JdbcPoolConnectC3PO.getInstance().getConnection()) {
            connection.setTransactionIsolation(java.sql.Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
                insertion.insertionOne(statement);
                connection.commit();
            }
        }
    }


}
