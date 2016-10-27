package ru.gds.entitys;

/**
 * Created by User on 23.09.2016.
 */
public class ComponentsGroupEntity {
    private int id;
    private String name;
    private int pieces;

    public ComponentsGroupEntity(int id, String name, int pieces) {
        this.id = id;
        this.name = name;
        this.pieces = pieces;
    }

    public ComponentsGroupEntity(String name) {
        this.name = name;
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

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

    @Override
    public String toString() {
        return "ComponentsGroupEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pieces=" + pieces +
                '}';
    }
}
