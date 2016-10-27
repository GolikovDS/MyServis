package ru.gds.dao.interfaces;

import ru.gds.Exception.NameExist;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public interface Dao<T> {
    public List<T> selectAll() throws SQLException, IOException, PropertyVetoException;
    public void remove(int id) throws SQLException, IOException, PropertyVetoException;
    public void add(T t) throws SQLException, PropertyVetoException, IOException, NameExist;
}
