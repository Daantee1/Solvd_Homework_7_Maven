package Homework_11;

public class Main {
    public static void main(String[] args) {

        ThreadOne threadOne = new ThreadOne();
        threadOne.start();

        Thread threadTwo = new Thread(new ThreadTwo());
        threadTwo.start();


    }
}
