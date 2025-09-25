class Task1 extends Thread {
    public void run() {
        int i = 1;
        while (i <= 5) {
            System.out.println(i);
            i++;
            try {
                Thread.sleep(1000);
            } 
            catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }
    }
}

class Task2 implements Runnable {
    public void run() {
        int j = 6;
        while (j <= 10) {
            System.out.println(j);
            j++;
            try {
                Thread.sleep(1000);
            } 
            catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }
    }
}

public class Multithreading {
    public static void main(String[] args) {
        Thread t1 = new Task1();
        Thread t2 = new Thread(new Task2());

        t1.start();
        t2.start();

    }
}