package Homework_11;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ThreadOne threadOne = new ThreadOne();
        threadOne.start();

        Thread threadTwo = new Thread(new ThreadTwo());
        threadTwo.start();

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> future = executorService.submit(new ThreadCall());
        System.out.println(future.get());
    }
}
