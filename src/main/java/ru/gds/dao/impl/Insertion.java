package ru.gds.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by User on 28.09.2016.
 */
public abstract class Insertion<T> {
    T t;

    public Insertion(T t) {
        this.t = t;
    }

    public abstract void insertionOne(PreparedStatement preparedStatement) throws SQLException;

    protected abstract boolean isExist(Connection connection);
}
