package ru.gds.dao.impl;

import ru.gds.dao.config.SqlQuery;
import ru.gds.dao.interfaces.UserDao;
import ru.gds.entitys.User;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class UserDaoImpl extends AbstractDao<User> implements UserDao {

    @Override
    public List<User> selectByName(String name) throws PropertyVetoException, SQLException, IOException {
        return selectByName(SqlQuery.SELECT_BY_NAME_USER, name, new Extractor<User>() {
            @Override
            public User extractOne(ResultSet rs) throws SQLException {
                return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
        });
    }

    @Override
    public String getSessionByName(String name) throws PropertyVetoException, IOException, SQLException {
        return getJsessionidByName(name, SqlQuery.GET_JSESSIONID_BY_NAME);
    }

    @Override
    public void addSessionById(int id, String jsessionid) throws PropertyVetoException, SQLException, IOException {
        updateRowById(id, jsessionid, SqlQuery.ADD_SESSION_BY_ID);
    }

    @Override
    public void addSessionByName(String name, String jsessionid) throws PropertyVetoException, SQLException, IOException {
        updateRowByName(name, jsessionid, SqlQuery.ADD_SESSION_BY_NAME);
    }

    @Override
    public void deleteSessionById(int id) throws PropertyVetoException, IOException, SQLException {
        addSessionById(id, null);
    }

    @Override
    public void deleteSessionByName(String name) throws PropertyVetoException, IOException, SQLException {
        addSessionByName(name, null);
    }

    @Override
    public int getIdByName(String name) throws PropertyVetoException, IOException, SQLException {
       return getIdByName(name, SqlQuery.GET_ID_BY_NAME);
    }


}
