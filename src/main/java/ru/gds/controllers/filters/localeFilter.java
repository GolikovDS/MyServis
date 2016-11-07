package ru.gds.controllers.filters;


import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

import static ru.gds.util.ClassNameUtil.getCurrentClassName;

@WebFilter("/*")
public class localeFilter implements Filter {
    public static final Logger LOGGER = Logger.getLogger(getCurrentClassName());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;


        LOGGER.debug( Locale.getDefault());
        Locale.setDefault(new Locale("ru", "Ru"));
        LOGGER.debug(Locale.getDefault());
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
