package ru.gds.entitys;

import java.util.Date;

/**
 * Created by User on 23.09.2016.
 */
public class ComponentsEntity {
    private int id;
    private String name;
    private Date receiptData;
    private int pieces;
    private int idComponentList;

    public ComponentsEntity(int id, String name, Date receiptData, int pieces, int idComponentList) {
        this.id = id;
        this.name = name;
        this.receiptData = receiptData;
        this.pieces = pieces;
        this.idComponentList = idComponentList;
    }

    public ComponentsEntity(String name, Date receiptData, int pieces, int idComponentList) {
        this.name = name;
        this.receiptData = receiptData;
        this.pieces = pieces;
        this.idComponentList = idComponentList;
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

    public Date getReceiptData() {
        return receiptData;
    }

    public void setReceiptData(Date receiptData) {
        this.receiptData = receiptData;
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

    public int getIdComponentList() {
        return idComponentList;
    }

    public void setIdComponentList(int idComponentList) {
        this.idComponentList = idComponentList;
    }

    @Override
    public String toString() {
        return "ComponentsEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", receiptData=" + receiptData +
                ", pieces=" + pieces +
                ", idComponentList=" + idComponentList +
                '}';
    }
}
