package ru.gds.dao.impl;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.gds.Exception.NameExist;
import ru.gds.dao.config.SqlQuery;
import ru.gds.dao.interfaces.OrderListDao;
import ru.gds.entitys.OrderListEntity;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class OrderDaoImpl extends AbstractDao<OrderListEntity> implements OrderListDao {

    static final Logger logger = LogManager.getLogger(new Throwable().getStackTrace()[0].getClassName());

    @Override
    public void add(OrderListEntity orderListEntity) throws SQLException, PropertyVetoException, IOException, NameExist {
        logger.info("Add logger");
        add(new Insertion<OrderListEntity>(orderListEntity) {
            @Override
            public void insertionOne(PreparedStatement statement) throws SQLException {
                statement.setInt(1, t.getNumber());
                statement.setString(2, t.getNameCostumer());
                statement.setDate(3, new java.sql.Date(t.getDataDeathLine().getTime()));
                statement.setInt(4, t.getPpkpuPieces());
                statement.setInt(5, t.getUptPieces());
                statement.setInt(6, t.getUpsPieces());
                statement.setInt(7, t.getUduPieces());
                statement.setInt(8, t.getUstPieces());
            }

            @Override
            protected boolean isExist(Connection connection) {
                try (PreparedStatement statement = connection.prepareStatement(SqlQuery.ORDER_IS_EXIST_NUMBER)) {
                    statement.setInt(1, t.getNumber());
                    try (ResultSet resultSet = statement.executeQuery()) {
                        return resultSet.next();
                    }
                } catch (SQLException e) {
                    return false;
                }
            }
        }, SqlQuery.ADD_ORDER);
    }


    @Override
    public List<OrderListEntity> selectAll() throws SQLException, IOException, PropertyVetoException {

        logger.info("SelectAll logger");
        return selectAll(SqlQuery.ORDER_GET_ALL, extractor());
    }

    @Override
    public void remove(int id) throws SQLException, IOException, PropertyVetoException {
        logger.info("Remove logger");
        updateById(id, SqlQuery.REMOVE_ORDER);
    }


    @Override
    public List<OrderListEntity> searchOrders(int number, String name) throws PropertyVetoException, SQLException, IOException {
        logger.info("SearchOrders");
        return searchByNumbAndNameCostumer(number, name, SqlQuery.SEARCH_ORDER_BY_NUMB_AND_NAME,extractor());
    }

    private Extractor<OrderListEntity> extractor(){
        return new Extractor<OrderListEntity>() {
            @Override
            public OrderListEntity extractOne(ResultSet resultSet) throws SQLException {
                return new OrderListEntity(resultSet.getInt(1), resultSet.getInt(2),
                        resultSet.getString(3), resultSet.getDate(4), resultSet.getInt(5), resultSet.getInt(6),
                        resultSet.getInt(7), resultSet.getInt(8), resultSet.getInt(9));
            }
        };
    }

}



