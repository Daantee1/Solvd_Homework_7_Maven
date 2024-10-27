package Homework_Design_Pattern;

import java.util.ResourceBundle;

public class AnimalsFactory {

    static ResourceBundle resourceBundle = ResourceBundle.getBundle("conf");

    static String type = resourceBundle.getString("type");

    public static AnimalsBase createAnimal() {
        if (type.equals("Dog")) {
            return new Dog();
        } else if (type.equals("Bird")) {
            return new Bird();
        }
        return null;
    }
}
