package ru.gds.dao.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcPoolConnectC3PO {

    private ComboPooledDataSource cpds;
    private static JdbcPoolConnectC3PO jdbcPoolConnectC3PO;


    private JdbcPoolConnectC3PO() throws IOException, SQLException, PropertyVetoException {

        Properties p = new Properties();
        p.load(new FileInputStream(
                "P:\\Разное\\Программирование\\MyServisV2\\src\\main\\resources\\sql_properties\\SQL_config_properties.properties"));

        cpds = new ComboPooledDataSource();
        cpds.setDriverClass(p.getProperty("DRIVER"));
        String str = String.format(
                p.getProperty("ADDRESS") + ":" +
                p.getProperty("PORT") + "/" +
                p.getProperty("DATABASE"));
        cpds.setJdbcUrl(str);

        cpds.setUser(p.getProperty("USER"));
        cpds.setPassword(p.getProperty("PASSWORD"));

        cpds.setMinPoolSize(5);
        cpds.setAcquireIncrement(5);
        cpds.setMaxPoolSize(20);
        cpds.setMaxStatements(180);
    }

    public static JdbcPoolConnectC3PO getInstance() throws IOException, SQLException, PropertyVetoException {
        if (jdbcPoolConnectC3PO == null) {
            jdbcPoolConnectC3PO = new JdbcPoolConnectC3PO();

        }
        return jdbcPoolConnectC3PO;
    }

    public Connection getConnection() throws SQLException {
        return this.cpds.getConnection();
    }


}
