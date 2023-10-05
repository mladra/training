package training.java;

import java.util.concurrent.TimeUnit;

public class DeadlockExample {

    private static final Object OBJ1 = new Object();
    private static final Object OBJ2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (OBJ1) {
                try {
                    System.out.println("Took OBJ1");
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println("Waited 5 seconds for OBJ2");
                    synchronized (OBJ2) {
                        System.out.println("Took OBJ1 and OBJ2");
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (OBJ2) {
                try {
                    System.out.println("Took OBJ2");
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println("Waited 5 seconds for OBJ1");
                    synchronized (OBJ1) {
                        System.out.println("Took OBJ2 and OBJ1");
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread1.start();
        thread2.start();
    }

}
