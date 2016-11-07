package ru.gds.controllers.order;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static ru.gds.util.ClassNameUtil.getCurrentClassName;

@WebServlet("/searchOrder")
public class SearchOrder extends HttpServlet {
    public static final Logger LOGGER = Logger.getLogger(getCurrentClassName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("enter.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int numbOrder = Integer.parseInt(req.getParameter("orderNumbInputText"));
        String nameOrder = req.getParameter("orderNameInputText");
        if(req.getParameter("btnSearchOrder")!=null){
            LOGGER.debug("in searchOrder");

        }

        req.getRequestDispatcher("enter.jsp").forward(req, resp);
    }


}
