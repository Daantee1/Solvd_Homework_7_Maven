package Homework_Design_Pattern;


public class Main {
    public static void main(String[] args) {



        AnimalsService animalsService = new AnimalsService();

        animalsService.setAnimal();

        // I have i conf dog so it will only show the run func :)
        // And i using pattern facade too in service


        Person person1 = Person.builder().name("Kacper").build();
    }
}
