package Homework_11;

public class ThreadTwo implements Runnable{
    @Override
    public void run() {
        System.out.println("ThreadTwo is running by implements Runnable! " + Thread.currentThread().getName());

    }
}
