package ru.gds.AppTest.XML_API;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "migu")
@XmlType(propOrder = {"er12", "er13", "number"})

public class Migu {
    private boolean er12;
    private boolean er13;
    private String number;


    public boolean isEr12() {
        return er12;
    }
    @XmlElement
    public void setEr12(boolean er12) {
        this.er12 = er12;
    }

    public boolean isEr13() {
        return er13;
    }
    @XmlElement
    public void setEr13(boolean er13) {
        this.er13 = er13;
    }

    public String getNumber() {
        return number;
    }

    @XmlElement
    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Migu{" +
                "er12=" + er12 +
                ", er13=" + er13 +
                ", number='" + number + '\'' +
                '}';
    }
}
