package ru.gds.AppTest.XML_API;

import javax.xml.bind.JAXBException;
import java.io.File;


public class AppXmlTest {

    public static void main(String[] args) throws JAXBException {

        Migu person = new Migu();
        person.setEr12(true);
        person.setEr12(false);
        person.setNumber("125");
        JaxbParser jaxbParser = new JaxbParser();
        jaxbParser.saveObject(new File("P:\\Разное\\Программирование\\MyServisV2\\src\\main\\java\\ru\\gds\\AppTest\\XML_API\\test.xml"), person);
        Migu person2 =  (Migu)jaxbParser.getObject(new File("P:\\Разное\\Программирование\\MyServisV2\\src\\main\\java\\ru\\gds\\AppTest\\XML_API\\test.xml"), Migu.class);
        System.out.println(person2.toString());

    }
}
