package ru.gds.AppTest;

import org.apache.log4j.Logger;
import ru.gds.Exception.NameExist;
import ru.gds.dao.impl.OrderDaoImpl;
import ru.gds.entitys.OrderListEntity;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static ru.gds.util.ClassNameUtil.getCurrentClassName;


public class TestApp {
    public static final Logger LOGGER = Logger.getLogger(getCurrentClassName());
    public static void main(String[] args) throws SQLException, IOException, PropertyVetoException, NameExist, ParseException {


        List<OrderListEntity> orderListEntities = new ArrayList<>();
        OrderDaoImpl orderDao = new OrderDaoImpl();
        orderListEntities = orderDao.searchOrders(1, "");
       // orderListEntities.forEach(System.clearProperty(d));
//        LOGGER.debug("Main");
//        DeviceDao deviceDao = new DeviceDaoImpl();
//        List<DeviceEntity> deviceEntities= deviceDao.selectByName(NameDevice.PPKPU.toString());
//        for(DeviceEntity deviceEntity : deviceEntities){
//            System.out.println(deviceEntity.toString());
//        }


//        userDao.deleteSessionByName("AIST");

//        ComponentsGroupDao componentDao = new ComponentGroupDaoImpl();
//        componentDao.remove(4);
//        componentDao.add(new ComponentsGroupEntity("АКБ 7АЧ"));
//        componentDao.remove(6);
//        List<ComponentsGroupEntity> deviceEntities = componentDao.selectAll();
//        for (ComponentsGroupEntity deviceEntity : deviceEntities)
//            System.out.println(deviceEntity.toString());
//
//        DeviceDao deviceDao = new DeviceDaoImpl();
//        List<ComponentsGroupEntity> deviceEntities = componentDao.selectAll();
//        deviceDao.add(new DeviceEntity(NameDevice.UDU.toString(), 0126, Date.valueOf("2016-09-22"), 1));
//        //deviceDao.removeDevice(16);
//        List<DeviceEntity> deviceEntities = deviceDao.selectAll();
//        for (DeviceEntity deviceEntity : deviceEntities)
//            System.out.println(deviceEntity.toString());
//
//        OrderDaoImpl orderDao = new OrderDaoImpl();
//        orderDao.add(new OrderListEntity(1459, "OOO fff25", Date.valueOf("2016-09-22"), 2, 0, 3, 0, 0));
//        orderDao.remove(8);
//        List<OrderListEntity> orderListEntities = orderDao.selectAll();
//        for (OrderListEntity orderListEntity : orderListEntities) {
//            System.out.println(orderListEntity.toString());
//        }

//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
//        Date data = sdf.parse("2016-09-23");
//        ComponentsDao componentsDao = new ComponentDaoImpl();
//
//        List<ComponentsEntity> componentsEntities = compo
// nentsDao.searchComponentByName("DTM 2");
//        for(ComponentsEntity componentsEntity : componentsEntities)
//            System.out.println(componentsEntity.toString());
//
//        DeviceDao deviceDao = new DeviceDaoImpl();
//        System.out.println(deviceDao.getDeviceById(5).toString());


//        for (int i = 0; i < 10; i++) {
//            long timer = System.nanoTime();
//            try (Connection connection = JdbcConnect.getConnection()) {
//                try (Statement statement = connection.createStatement()) {
//                    try (ResultSet resultSet = statement.executeQuery("SELECT * FROM user")) {
//                        while (resultSet.next()) {
//                            System.out.println("------------------------------------------------------");
//                            System.out.println(" | " + resultSet.getInt(1) + " | " +
//                                    resultSet.getString(2) + " | " +
//                                    resultSet.getString(3) + " | ");
//                        }
//                    }
//                }
//            }finally {
//                JdbcConnect.closeConnection();
//            }
//            System.out.println(">>>>>");
//            System.out.println((System.nanoTime() - timer) / 1000000);
//        }

//        for (int i = 0; i < 10; i++) {
//            long timer = System.nanoTime();
//            try (Connection connection = JdbcPoolConnectC3PO.getInstance().getConnection()) {
//                try (Statement statement = connection.createStatement()) {
//                    try (ResultSet resultSet = statement.executeQuery("SELECT * FROM user")) {
//                        while (resultSet.next()) {
//                            System.out.println("------------------------------------------------------");
//                            System.out.println(" | " + resultSet.getInt(1) + " | " +
//                                    resultSet.getString(2) + " | " +
//                                    resultSet.getString(3) + " | ");
//                        }
//                    }
//                }
//            }
//            System.out.println(">>>>>");
//            System.out.println((System.nanoTime() - timer) / 10000);
//        }

    }
}
