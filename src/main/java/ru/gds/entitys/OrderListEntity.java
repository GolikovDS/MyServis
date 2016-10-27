package ru.gds.entitys;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by User on 23.09.2016.
 */
public class OrderListEntity implements Serializable {

    private int id;
    private int number;
    private String nameCostumer;
    private Date dataDeathLine;
    private int PpkpuPieces;
    private int UptPieces;
    private int UpsPieces;
    private int UduPieces;
    private int UstPieces;

    public OrderListEntity() {
    }

    public OrderListEntity(int id, int number, String nameCostumer, Date dataDeathLine, int ppkpuPieces, int uptPieces, int upsPieces, int uduPieces, int ustPieces) {
        this.id = id;
        this.number = number;
        this.nameCostumer = nameCostumer;
        this.dataDeathLine = dataDeathLine;
        PpkpuPieces = ppkpuPieces;
        UptPieces = uptPieces;
        UpsPieces = upsPieces;
        UduPieces = uduPieces;
        UstPieces = ustPieces;
    }


    public OrderListEntity(int number, String nameCostumer, Date dataDeathLine, int ppkpuPieces, int uptPieces, int upsPieces, int uduPieces, int ustPieces) {
        this.number = number;
        this.nameCostumer = nameCostumer;
        this.dataDeathLine = dataDeathLine;
        PpkpuPieces = ppkpuPieces;
        UptPieces = uptPieces;
        UpsPieces = upsPieces;
        UduPieces = uduPieces;
        UstPieces = ustPieces;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setNameCostumer(String nameCostumer) {
        this.nameCostumer = nameCostumer;
    }

    public void setDataDeathLine(Date dataDeathLine) {
        this.dataDeathLine = dataDeathLine;
    }

    public int getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public String getNameCostumer() {
        return nameCostumer;
    }

    public Date getDataDeathLine() {
        return dataDeathLine;
    }

    public int getPpkpuPieces() {
        return PpkpuPieces;
    }

    public void setPpkpuPieces(int ppkpuPieces) {
        PpkpuPieces = ppkpuPieces;
    }

    public int getUptPieces() {
        return UptPieces;
    }

    public void setUptPieces(int uptPieces) {
        UptPieces = uptPieces;
    }

    public int getUpsPieces() {
        return UpsPieces;
    }

    public void setUpsPieces(int upsPieces) {
        UpsPieces = upsPieces;
    }

    public int getUduPieces() {
        return UduPieces;
    }

    public void setUduPieces(int uduPieces) {
        UduPieces = uduPieces;
    }

    public int getUstPieces() {
        return UstPieces;
    }

    public void setUstPieces(int ustPieces) {
        UstPieces = ustPieces;
    }

    @Override
    public String toString() {
        return "OrderListEntity{" +
                "id=" + id +
                ", number=" + number +
                ", nameCostumer='" + nameCostumer + '\'' +
                ", dataDeathLine=" + dataDeathLine +
                ", PpkpuPieces=" + PpkpuPieces +
                ", UptPieces=" + UptPieces +
                ", UpsPieces=" + UpsPieces +
                ", UduPieces=" + UduPieces +
                ", UstPieces=" + UstPieces +
                '}';
    }
}
