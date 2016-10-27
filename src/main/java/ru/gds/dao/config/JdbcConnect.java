package ru.gds.dao.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class JdbcConnect {

//    private static Connection connection;
//    private final static String ADRESS = "jdbc:mysql//localhost";
//    private final static String DATABASE = "jaist_2";
//    private final static String USER = "root";
//    private final static String PASSWORD = "11";
//    private final static String PORT = "3306";
//    private final static String DRIVER = "com.mysql.jdbc.Driver";


    private JdbcConnect() {

    }

    private static Connection connection;
    private static String ADDRESS;
    private static String DATABASE;
    private static String USER;
    private static String PASSWORD;
    private static String PORT;
    private static String DRIVER;



    private static void initClass() {
        FileInputStream fis;
        Properties property = new Properties();
        try {
            fis = new FileInputStream("sql_properties/SQL_config_properties.properties");
            property.load(fis);
            ADDRESS = property.getProperty("ADDRESS");
            DATABASE = property.getProperty("DATABASE");
            USER = property.getProperty("USER");
            PASSWORD = property.getProperty("PASSWORD");
            PORT = property.getProperty("PORT");
            DRIVER = property.getProperty("DRIVER");
        } catch (IOException e) {
            System.err.println("Error, file not found! " + e.getMessage());
        }
    }

    private static void loadDriver(String driverName) {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver exception - " + e.getMessage());
        }
    }

    public synchronized static Connection getConnection() {
        if (connection == null) {
            initClass();
            loadDriver(DRIVER);
            loadConnection();
        }
        return connection;
    }

    private static void loadConnection() {
        try {
            connection = DriverManager.getConnection(getUrl(), USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database " + getUrl() + e.getMessage());
        }
    }


    private static String getUrl() {
        return ADDRESS + ":" + PORT + "/" + DATABASE;
    }

    public synchronized static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
