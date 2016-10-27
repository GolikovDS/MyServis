package ru.gds.dao.impl;

import ru.gds.Exception.NameExist;
import ru.gds.dao.config.SqlQuery;
import ru.gds.dao.interfaces.DeviceDao;
import ru.gds.entitys.DeviceEntity;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class DeviceDaoImpl extends AbstractDao<DeviceEntity> implements DeviceDao {


    @Override
    public void remove(int id) throws SQLException, IOException, PropertyVetoException {
        updateById(id, SqlQuery.REMOVE_DEVICE);
    }

    @Override
    public void add(DeviceEntity deviceEntity) throws SQLException, PropertyVetoException, IOException, NameExist {
        add(new Insertion<DeviceEntity>(deviceEntity) {
            @Override
            public void insertionOne(PreparedStatement statement) throws SQLException {
                statement.setString(1, t.getName());
                statement.setInt(2, t.getNumber());
                statement.setDate(3, new java.sql.Date(t.getDataManuf().getTime()));
                statement.setInt(4, t.getIdOrderList());
            }

            @Override
            protected boolean isExist(Connection connection) {
                try (PreparedStatement statement = connection.prepareStatement(SqlQuery.DEVICE_IS_EXIST_NUMBER_AND_NAME)) {
                    statement.setString(1, t.getName());
                    statement.setInt(2, t.getNumber());
                    try (ResultSet resultSet = statement.executeQuery()) {
                        return resultSet.next();
                    }
                } catch (SQLException e) {
                    return false;
                }
            }

        }, SqlQuery.ADD_DEVICE);
    }


    @Override
    public List<DeviceEntity> selectAll() throws SQLException, IOException, PropertyVetoException {
        return selectAll(SqlQuery.DEVICE_GET_ALL, extractor());
    }

    @Override
    public List<DeviceEntity> selectByOrder(int id) throws PropertyVetoException, SQLException, IOException {
        return selectByName(SqlQuery.SELECT_DEVICE_BY_ORDER, "", extractor());
    }

    @Override
    public List<DeviceEntity> selectByName(String name) throws PropertyVetoException, SQLException, IOException {
        return selectByName(SqlQuery.SELECT_DEVICE_BY_NAME, name, extractor());
    }

    private Extractor<DeviceEntity> extractor(){
        return new Extractor<DeviceEntity>() {
            @Override
            public DeviceEntity extractOne(ResultSet resultSet) throws SQLException {
                return new DeviceEntity(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getInt(3), resultSet.getDate(4), resultSet.getInt(5));
            }
        };
    }
}
