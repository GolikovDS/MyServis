package ru.gds.dao.interfaces;

import ru.gds.Exception.NameExist;
import ru.gds.entitys.ComponentsEntity;
import ru.gds.entitys.ComponentsGroupEntity;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by User on 23.09.2016.
 */
public interface ComponentsGroupDao extends Dao<ComponentsGroupEntity>{
    public void insert(String name, int pieces) throws SQLException, IOException, PropertyVetoException, NameExist;
    public void update(int id, String name, Date receiptData, int pieces) throws SQLException, IOException, PropertyVetoException;
    public ArrayList<ComponentsEntity> searchByName(String name) throws SQLException, IOException, PropertyVetoException;

}
