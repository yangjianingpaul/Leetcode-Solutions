public class demo extends Thread {

    @Override
    public void run(){
        System.out.println("MyThread...run...");
    }

    public static void main(String[] args) {
        demo t1 = new demo();
        demo t2 = new demo();

        t1.start();
        t2.start();
    }
}