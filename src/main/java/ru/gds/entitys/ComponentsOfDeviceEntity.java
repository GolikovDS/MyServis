package ru.gds.entitys;

/**
 * Created by User on 23.09.2016.
 */
public class ComponentsOfDeviceEntity {
    private int id;
    private int pieces;
    private int idListComponents;
    private String nameDevice;

    public int getId() {
        return id;
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

    public int getIdListComponents() {
        return idListComponents;
    }

    public void setIdListComponents(int idListComponents) {
        this.idListComponents = idListComponents;
    }

    public String getIdDevice() {
        return  nameDevice;
    }

    public void setIdDevice(String idDevice) {
        this. nameDevice = idDevice;
    }
}
