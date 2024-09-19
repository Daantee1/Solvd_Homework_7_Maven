package Homework_11;

import java.util.concurrent.Callable;

public class ThreadCall implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "Hello I'm Thread using Callable" ;
    }
}
