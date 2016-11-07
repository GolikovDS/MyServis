package ru.gds.dao.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



public class SqlQuery {
    //////////////////////////////////////////////////////
    ////DEVICE////////////////////////////////////////////
    //**************************************************//
    public static final String DEVICE_GET_ALL;
    public static final String DEVICE_IS_EXIST_NUMBER_AND_NAME;
    public static final String REMOVE_DEVICE;
    public static final String ADD_DEVICE;
    public static final String SELECT_DEVICE_BY_NAME;
    public static final String  SELECT_DEVICE_BY_ORDER;

    //////////////////////////////////////////////////////
    ////ORDER/////////////////////////////////////////////
    //**************************************************//
    public static final String ADD_ORDER;
    public static final String ORDER_GET_ALL;
    public static final String ORDER_IS_EXIST_NUMBER;
    public static final String SEARCH_ORDER_BY_NUMB_AND_NAME;

    //////////////////////////////////////////////////////
    ////COMPONENT/////////////////////////////////////////
    //**************************************************//
    public static final String COMPONENT_GET_ALL;
    public static final String REMOVE_COMPONENT;
    public static final String ADD_COMPONENT;
    public static final String UPDATE_COMPONENT;
    public static final String SELECT_BY_NAME_COMPONENT;


    //////////////////////////////////////////////////////
    ////COMPONENT_GROUP/////////////////////////////////////////
    //**************************************************//
    public static final String COMPONENT_GROUP_GET_ALL;
    public static final String REMOVE_COMPONENT_GROUP;
    public static final String ADD_COMPONENT_GROUP;
    public static final String UPDATE_COMPONENT_GROUP;
    public static final String SELECT_BY_NAME_COMPONENT_GROUP;
    public static final String REMOVE_ORDER;
    public static final String COMPONENT_GROUP_IS_EXIST_NAME;

    //////////////////////////////////////////////////////
    ////USER_GROUP/////////////////////////////////////////
    //**************************************************//

    public static final String SELECT_BY_NAME_USER;
    public static final String ADD_SESSION_BY_ID;
    public static final String ADD_SESSION_BY_NAME;
    public static final String GET_ID_BY_NAME;
    public static final String GET_JSESSIONID_BY_NAME;


    static {

        Properties p = new Properties();
        try {
            p.load(new FileInputStream("P:\\Разное\\Программирование\\MyServisV2\\src\\main\\resources\\sql_properties\\SqlQuestion.properties"));
        } catch (IOException e) {

            e.printStackTrace();
        }
        DEVICE_GET_ALL = p.getProperty("DEVICE_GET_ALL");
        SELECT_DEVICE_BY_NAME = p.getProperty("SELECT_DEVICE_BY_NAME");
        SELECT_DEVICE_BY_ORDER= p.getProperty("SELECT_DEVICE_BY_ORDER");
        ADD_ORDER = p.getProperty("ADD_ORDER");
        ORDER_GET_ALL = p.getProperty("ORDER_GET_ALL");
        ORDER_IS_EXIST_NUMBER = p.getProperty("ORDER_IS_EXIST_NUMBER");
        SEARCH_ORDER_BY_NUMB_AND_NAME = p.getProperty("SEARCH_ORDER_BY_NUMB_AND_NAME");

        COMPONENT_GET_ALL = p.getProperty("COMPONENT_GET_ALL");
        DEVICE_IS_EXIST_NUMBER_AND_NAME = p.getProperty("DEVICE_IS_EXIST_NUMBER_AND_NAME");
        REMOVE_DEVICE = p.getProperty("REMOVE_DEVICE");
        ADD_DEVICE = p.getProperty("ADD_DEVICE");
        REMOVE_COMPONENT = p.getProperty("REMOVE_COMPONENT");
        ADD_COMPONENT = p.getProperty("ADD_COMPONENT");
        UPDATE_COMPONENT = p.getProperty("UPDATE_COMPONENT");
        SELECT_BY_NAME_COMPONENT = p.getProperty("SELECT_BY_NAME_COMPONENT");

        REMOVE_ORDER = p.getProperty("REMOVE_ORDER");

        COMPONENT_GROUP_GET_ALL = p.getProperty("COMPONENT_GROUP_GET_ALL");
        REMOVE_COMPONENT_GROUP = p.getProperty("REMOVE_COMPONENT_GROUP");
        ADD_COMPONENT_GROUP = p.getProperty("ADD_COMPONENT_GROUP");
        UPDATE_COMPONENT_GROUP = p.getProperty("UPDATE_COMPONENT_GROUP");
        SELECT_BY_NAME_COMPONENT_GROUP = p.getProperty("SELECT_BY_NAME_COMPONENT_GROUP");
        COMPONENT_GROUP_IS_EXIST_NAME = p.getProperty("COMPONENT_GROUP_IS_EXIST_NAME");

        SELECT_BY_NAME_USER = p.getProperty("SELECT_BY_NAME_USER");
        ADD_SESSION_BY_ID = p.getProperty("ADD_SESSION_BY_ID");
        ADD_SESSION_BY_NAME = p.getProperty("ADD_SESSION_BY_NAME");
        GET_ID_BY_NAME = p.getProperty("GET_ID_BY_NAME");
        GET_JSESSIONID_BY_NAME = p.getProperty("GET_JSESSIONID_BY_NAME");
    }

    public SqlQuery() throws IOException {

    }


}
