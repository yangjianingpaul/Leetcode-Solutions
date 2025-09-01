package myRunnable;
public class MyRunnable implements Runnable {
    @Override 
    public void run(){
        System.out.println(" ...run...");
     }

     public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();

        Thread t1 = new Thread(myRunnable);
        Thread t2 = new Thread(myRunnable);

        t1.start();
        t2.start();
     }
}
