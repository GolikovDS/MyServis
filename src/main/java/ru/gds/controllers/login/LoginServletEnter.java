package ru.gds.controllers.login;

import org.apache.log4j.Logger;
import ru.gds.dao.impl.DeviceDaoImpl;
import ru.gds.dao.impl.OrderDaoImpl;
import ru.gds.dao.impl.UserDaoImpl;
import ru.gds.dao.interfaces.DeviceDao;
import ru.gds.dao.interfaces.OrderListDao;
import ru.gds.dao.interfaces.UserDao;
import ru.gds.entitys.NameDevice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;

import static ru.gds.util.ClassNameUtil.getCurrentClassName;

@WebServlet("/login.do")
public class LoginServletEnter extends HttpServlet {

    public static final Logger LOGGER = Logger.getLogger(getCurrentClassName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getAttribute("userName") == null) {
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("enter.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String userName = req.getParameter("loginInput");
        String userPassword = req.getParameter("passwordInput");


        LOGGER.debug("loginInput | passwordInput /     / " + userName + " | " + userPassword);

        if (req.getParameter("btnEnter") != null || userName.equals("")) {
            try {
                UserDao userDao = new UserDaoImpl();
                if (userDao.selectByName(userName).get(0).getPassword().equals(userPassword)) {
                    if (req.getParameter("saveMi") != null) {
                        userDao.addSessionByName(userName, req.getSession().getId());
                    }
                    Cookie cookie = new Cookie("userName", URLEncoder.encode(userName, "utf-8"));
                    cookie.setMaxAge(860000);
                    resp.addCookie(cookie);
                    cookie = new Cookie("DBJSESSIONID", URLEncoder.encode(req.getSession().getId(), "utf-8"));
                    cookie.setMaxAge(860000);
                    resp.addCookie(cookie);
                    req.setAttribute("userName", userName);
                    //////////////////////////////////////////////////////
                    //Fest table in jsp
                    //////////////////////////////////////////////////////
                    DeviceDao deviceDao = new DeviceDaoImpl();
                    OrderListDao orderListDao =new OrderDaoImpl();
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
                    /////////////////////////////////////////////////////
                    req.getRequestDispatcher("enter.jsp").forward(req, resp);
                } else {
                    req.getRequestDispatcher("login.jsp").forward(req, resp);
                }
                LOGGER.debug("isClick btnEnter");
            } catch (PropertyVetoException | SQLException e) {
                e.printStackTrace();
                req.getRequestDispatcher("/index").forward(req, resp);
            }
        }
    }
}
