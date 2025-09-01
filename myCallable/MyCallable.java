package myCallable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MyCallable implements Callable<String> {
    
    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        return "ok";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable myCallable = new MyCallable();
        FutureTask<String> ft = new FutureTask<String>(myCallable);
        Thread t1 = new Thread(ft);
        Thread t2 = new Thread(ft);
        t1.start();
        String result = ft.get();
        System.out.println(result);
    }
}
