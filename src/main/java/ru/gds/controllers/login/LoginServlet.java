package ru.gds.controllers.login;

import org.apache.log4j.Logger;
import ru.gds.dao.impl.DeviceDaoImpl;
import ru.gds.dao.impl.OrderDaoImpl;
import ru.gds.dao.interfaces.DeviceDao;
import ru.gds.dao.interfaces.OrderListDao;
import ru.gds.entitys.NameDevice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;

import static ru.gds.util.ClassNameUtil.getCurrentClassName;


@WebServlet("/index")
public class LoginServlet extends HttpServlet {
    public static final Logger LOGGER = Logger.getLogger(getCurrentClassName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        if (req.getAttribute("userName") == null) {
            //req.getRequestDispatcher("enter.jsp").forward(req, resp);
            //resp.sendRedirect("/login.do");
            req.getRequestDispatcher("/login.do").forward(req, resp);
        } else {
            DeviceDao deviceDao = new DeviceDaoImpl();
            OrderListDao orderListDao = new OrderDaoImpl();
            try {
                req.setAttribute("devicePPKPU", deviceDao.selectByName(NameDevice.PPKPU.toString()));
                req.setAttribute("deviceUPT", deviceDao.selectByName(NameDevice.UPT.toString()));
                req.setAttribute("deviceUPS", deviceDao.selectByName(NameDevice.UPS.toString()));
                req.setAttribute("deviceUDU", deviceDao.selectByName(NameDevice.UDU.toString()));
                req.setAttribute("deviceUST", deviceDao.selectByName(NameDevice.UST.toString()));
                req.setAttribute("order", orderListDao.selectAll());



            } catch (SQLException | PropertyVetoException e) {
                e.printStackTrace();
            }
                req.getRequestDispatcher("enter.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

}
