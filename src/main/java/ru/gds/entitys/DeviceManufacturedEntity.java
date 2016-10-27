package ru.gds.entitys;

import java.util.Date;

/**
 * Created by User on 23.09.2016.
 */
public class DeviceManufacturedEntity {
    private int id;
private int idDevice;
    private int number;
    private Date dataManuf;
    private int idOrderState;

    public int getId() {
        return id;
    }

    public int getIdDevice() {
        return idDevice;
    }

    public void setIdDevice(int idDevice) {
        this.idDevice = idDevice;
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

    public int getIdOrderState() {
        return idOrderState;
    }

    public void setIdOrderState(int idOrderState) {
        this.idOrderState = idOrderState;
    }
}
