package Homework_9;

import Homework_9.Enum.Animals;
import Homework_9.Enum.Cars;
import Homework_9.Enum.Phones;
import Homework_9.Interfaces.IAddition;
import Homework_9.Interfaces.IDivision;
import Homework_9.Interfaces.IMultiplication;
import Homework_9.Interfaces.IRun;

import java.util.function.*;

public class Main  {

    public static void main(String[] args) {

        IAddition<Integer> integerAddition = (a,b) -> a + b;
        System.out.println("Integer addition: " + integerAddition.add(5,5));

        IAddition<Double> doubleAddition = (a,b) -> a + b;
        System.out.println("Double addition: " + doubleAddition.add(5.8,5.2));

        IMultiplication<Double> multiplication = (a,b) -> a * b;
        System.out.println("Double multiplication: " + multiplication.multiply(5.3,4.6));

        IDivision<Double> division = (a,b) -> a / b;
        System.out.println("Double division: " + division.divide(10.2, 5.8));


        IRun<String> stringRun = (input) -> System.out.println("Running with " + input);
        stringRun.run("high speed!");

        IRun<Integer> integerRun = (input) -> System.out.println("Running with " + input + " k/h!");
        integerRun.run(28);
        System.out.println("-------");

        for(Phones phone: Phones.values()){
            System.out.println(phone.getName());
            System.out.println(phone.getModel());
            System.out.println(phone.getSystem());
            System.out.println("-------");
        }

        for(Cars car: Cars.values()){
            System.out.println(car.getName());
            System.out.println(car.getHorsePower());
            System.out.println(car.getCountry());
            System.out.println(car.getEngine());
            System.out.println("-------");
        }

        for(Animals animal: Animals.values()){
            System.out.println(animal.getName());
            System.out.println(animal.getQuantity());
            System.out.println(animal.getSound());
            System.out.println("-------");
        }

        Predicate<String> isNotEmpty = str -> !str.isEmpty();
        System.out.println(isNotEmpty.test(""));
        System.out.println(isNotEmpty.test("aaa"));

        Consumer<String> printMessage = msg -> System.out.println("Message: " + msg);
        printMessage.accept("Hello World!");

        Supplier<Double> randomValue = () -> Math.random();
        System.out.println(randomValue.get());

        BiFunction<String, Integer, String> repeatString = (str, times) -> str.repeat(times);
        System.out.println(repeatString.apply("Hi! ", 3));

        ToIntFunction<String> stringLenght = str -> str.length();
        System.out.println(stringLenght.applyAsInt("Geronimooooooo"));

    }
}
