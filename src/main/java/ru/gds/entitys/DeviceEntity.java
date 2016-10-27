package ru.gds.entitys;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by User on 23.09.2016.
 */
public class DeviceEntity implements Serializable {
    private int id;
    private String name;
    private int number;
    private Date dataManuf;
    private int idOrderList;


    public DeviceEntity() {
    }

    public DeviceEntity(int id, String name, int number, Date dataManuf, int idOrderList) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.dataManuf = dataManuf;
        this.idOrderList = idOrderList;
    }


    public DeviceEntity(String name, int number, Date dataManuf, int idOrderList) {
        this.name = name;
        this.number = number;
        this.dataManuf = dataManuf;
        this.idOrderList = idOrderList;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getDataManuf() {
        return dataManuf;
    }

    public void setDataManuf(Date dataManuf) {
        this.dataManuf = dataManuf;
    }

    public int getIdOrderList() {
        return idOrderList;
    }

    public void setIdOrderList(int idOrderList) {
        this.idOrderList = idOrderList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeviceEntity that = (DeviceEntity) o;

        if (id != that.id) return false;
        if (idOrderList != that.idOrderList) return false;
        if (number != that.number) return false;
        if (dataManuf != null ? !dataManuf.equals(that.dataManuf) : that.dataManuf != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + number;
        result = 31 * result + (dataManuf != null ? dataManuf.hashCode() : 0);
        result = 31 * result + idOrderList;
        return result;
    }

    @Override
    public String toString() {
        return "DeviceEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", dataManuf=" + dataManuf +
                ", idOrderList=" + idOrderList +
                '}';
    }
}
