package ru.gds.dao.interfaces;

import ru.gds.entitys.User;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    public void addSessionById(int id, String jsessionid) throws PropertyVetoException, SQLException, IOException;

    public void addSessionByName(String name, String jsessionid) throws PropertyVetoException, SQLException, IOException;

    public void deleteSessionById(int id) throws PropertyVetoException, IOException, SQLException;

    public void deleteSessionByName(String name) throws PropertyVetoException, IOException, SQLException;

    public int getIdByName(String name) throws PropertyVetoException, IOException, SQLException;

    public List<User> selectByName(String name) throws PropertyVetoException, SQLException, IOException;

    public String getSessionByName(String name) throws PropertyVetoException, IOException, SQLException;
}
