package Homework_11;

public class ThreadOne extends Thread{
    @Override
    public void run() {
        System.out.println("ThreadOne is running by extends Thread! "  + Thread.currentThread().getName());

    }
}
