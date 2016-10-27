package ru.gds.dao.interfaces;

import ru.gds.entitys.DeviceEntity;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public interface DeviceDao extends Dao<DeviceEntity> {

    public List<DeviceEntity> selectByOrder(int id) throws PropertyVetoException, SQLException, IOException;
    public List<DeviceEntity> selectByName(String name) throws PropertyVetoException, SQLException, IOException;



}
