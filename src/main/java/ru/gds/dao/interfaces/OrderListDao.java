package ru.gds.dao.interfaces;

import ru.gds.entitys.OrderListEntity;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public interface OrderListDao extends Dao<OrderListEntity> {
public List<OrderListEntity> searchOrders (int number, String name) throws PropertyVetoException, SQLException, IOException;
}
