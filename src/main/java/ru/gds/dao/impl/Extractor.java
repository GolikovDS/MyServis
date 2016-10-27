package ru.gds.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public abstract class Extractor <T>{
    public abstract T extractOne(ResultSet rs) throws SQLException;

    public List<T> extractAll(ResultSet resultSet) throws SQLException {
        List<T> result = new ArrayList<>();
        while (resultSet.next()){
            result.add(extractOne(resultSet));
        }
        return result;
    }
}


