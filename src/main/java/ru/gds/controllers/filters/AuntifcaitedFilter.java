package ru.gds.controllers.filters;

import org.apache.log4j.Logger;
import ru.gds.dao.impl.UserDaoImpl;
import ru.gds.dao.interfaces.UserDao;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.net.URLDecoder;
import java.sql.SQLException;


@WebFilter("/index")
public class AuntifcaitedFilter implements Filter {
    public static final Logger LOGGER = Logger.getLogger(AuntifcaitedFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        request.setCharacterEncoding("UTF-8");
        LOGGER.debug("Is doFilter");
        Cookie[] cookie = request.getCookies();


        if (cookie != null) {
            String idSession = request.getSession().getId();
            String idSessionInCookie = "";
            String nameInCookie = "";
            LOGGER.debug("Filter session " + idSession);
            for (Cookie cookie1 : cookie) {
                if (cookie1.getName().equals("DBJSESSIONID")) {
                    idSessionInCookie = cookie1.getValue();
                    LOGGER.debug("Cookie session" + idSessionInCookie);
                }
                if (cookie1.getName().equals("userName")) {
                    nameInCookie = URLDecoder.decode(cookie1.getValue(), "UTF-8");
                    LOGGER.debug("Cookie user name" + nameInCookie);
                }
            }

            if (idSessionInCookie.equals(idSession) && !nameInCookie.equals("")) {
                LOGGER.debug("Id in cookie -  " + idSessionInCookie);
                request.setAttribute("userName", nameInCookie);

            } else {
                try {
                    UserDao userDao = new UserDaoImpl();
                    if (idSessionInCookie.equals(userDao.getSessionByName(nameInCookie))) {
                        request.setAttribute("userName", nameInCookie);
                        LOGGER.debug("User in database");
                    } else {
                        request.setAttribute("userName", null);
                        Cookie cookie1 = new Cookie("userName", "");
                        cookie1.setMaxAge(0);
                        response.addCookie(cookie1);
                        LOGGER.debug("NO USER");
                    }
                } catch (PropertyVetoException | SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
