package ru.gds.controllers.listener;

import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import static ru.gds.util.ClassNameUtil.getCurrentClassName;


@WebListener
public class SessionLifeCycleEventExample implements ServletContextListener, HttpSessionListener {

    public static final Logger LOGGER = Logger.getLogger(getCurrentClassName());
    ServletContext servletContext;

    public SessionLifeCycleEventExample() {
    }


    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        LOGGER.debug("Session IS BEGIN Listener");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        LOGGER.debug("DESTROY, Session Duration:");
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        servletContext = servletContextEvent.getServletContext();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
