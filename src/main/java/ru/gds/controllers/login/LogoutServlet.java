package ru.gds.controllers.login;

import org.apache.log4j.Logger;
import ru.gds.dao.impl.UserDaoImpl;
import ru.gds.dao.interfaces.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.net.URLDecoder;
import java.sql.SQLException;


@WebServlet("/logout.do")
public class LogoutServlet extends HttpServlet {

    public static final Logger LOGGER = Logger.getLogger(LogoutServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("login.jsp").forward(req, resp);
        resp.sendRedirect("/index");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        if (req.getParameter("btnCloseSession") != null) {

            Cookie[] cookies = req.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("userName")) {
                        UserDao userDao = new UserDaoImpl();
                        try {
                            userDao.deleteSessionByName(URLDecoder.decode(cookie.getValue(), "UTF-8"));
                        } catch (PropertyVetoException | SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            Cookie cookie = new Cookie("userName", null);
            cookie.setMaxAge(0);
            resp.addCookie(cookie);
            cookie = new Cookie("DBJSESSIONID", null);
            cookie.setMaxAge(0);
            resp.addCookie(cookie);
            req.removeAttribute("userName");
            req.getSession(true).invalidate();
            req.getRequestDispatcher("/index").forward(req, resp);
        }

    }
}
