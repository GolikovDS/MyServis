package ru.gds.controllers.order;

import org.apache.log4j.Logger;
import ru.gds.Exception.NameExist;
import ru.gds.dao.impl.DeviceDaoImpl;
import ru.gds.dao.impl.OrderDaoImpl;
import ru.gds.dao.interfaces.DeviceDao;
import ru.gds.dao.interfaces.OrderListDao;
import ru.gds.entitys.NameDevice;
import ru.gds.entitys.OrderListEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import static ru.gds.util.ClassNameUtil.getCurrentClassName;


@WebServlet("/addOrder")
public class addOrder extends HttpServlet {
    public static final Logger LOGGER = Logger.getLogger(getCurrentClassName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("enter.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        OrderListDao orderDao = new OrderDaoImpl();
        try {
            if (req.getParameter("btnAddOrder") != null) {
                LOGGER.debug("in add Order");
                orderDao.add(new OrderListEntity(
                        Integer.parseInt(req.getParameter("orderNumbInputText")),
                        req.getParameter("orderNameInputText"),
                        Date.valueOf(req.getParameter("orderDeadLineInputText")),
                        Integer.parseInt(req.getParameter("orderPPKPUInputText")),
                        Integer.parseInt(req.getParameter("orderUPTInputText")),
                        Integer.parseInt(req.getParameter("orderUPSInputText")),
                        Integer.parseInt(req.getParameter("orderUDUInputText")),
                        Integer.parseInt(req.getParameter("orderUSTInputText"))));
            }

            if (req.getParameter("btnSearchOrder") != null) {
                LOGGER.debug("in searchOrder");
                int numbOrder = Integer.parseInt(req.getParameter("orderNumbInputText"));
                String nameOrder = req.getParameter("orderNameInputText");
            }

        } catch (SQLException | PropertyVetoException | NameExist e) {
            e.printStackTrace();
        }

        DeviceDao deviceDao = new DeviceDaoImpl();

        try {
            req.setAttribute("devicePPKPU", deviceDao.selectByName(NameDevice.PPKPU.toString()));
            req.setAttribute("deviceUPT", deviceDao.selectByName(NameDevice.UPT.toString()));
            req.setAttribute("deviceUPS", deviceDao.selectByName(NameDevice.UPS.toString()));
            req.setAttribute("deviceUDU", deviceDao.selectByName(NameDevice.UDU.toString()));
            req.setAttribute("deviceUST", deviceDao.selectByName(NameDevice.UST.toString()));
            req.setAttribute("order", orderDao.selectAll());
        } catch (SQLException | PropertyVetoException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("enter.jsp").forward(req, resp);
    }
}

