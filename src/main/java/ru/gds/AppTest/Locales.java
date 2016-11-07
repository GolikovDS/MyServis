package ru.gds.AppTest;

import java.util.Locale;
import java.util.ResourceBundle;

public class Locales {

    public static void main(String[] args) {
//        Locale.setDefault(new Locale("en"));
//        Locale locale = new Locale("ru");
//        System.out.println(locale.getLanguage());

        Locale.setDefault(new Locale("en"));
        Locale locale = Locale.getDefault();
        ResourceBundle resourceBundle = ResourceBundle.getBundle("languages/message", locale);
        System.out.println(resourceBundle.getString("PPKPU"));
    }
}
