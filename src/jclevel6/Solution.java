package jclevel6;

/*1. Create 5 different threads that differ from Thread:
1.1. Thread 1 must run indefinitely;
1.2. Thread 2 should display "InterruptedException" when an InterruptedException occurs;
1.3. Thread 3 should display "Hurray" every half second;
1.4. Thread 4 must implement the Message interface. When the showWarning method is called, the thread should stop;
1.5. Thread 5 should read numbers from the console until "N" is entered. Then it should display the sum of the entered numbers.
2. In a static block, add your threads to List<Thread> threads in the specified order.
3. The threads should not start automatically.

Hint:
Thread 4 can be checked using isAlive()

Requirements:
•	The Solution class's static block must create 5 threads and add them to the threads list.
•	The threads in the threads list should not start automatically.
•	Thread 1 in the threads list must run infinitely.
•	Thread 2 in the threads list should display "InterruptedException" when an InterruptedException occurs.
•	Thread 3 in the threads list should display "Hurray" every half second.
•	Thread 4 in the threads list must implement the Message interface. When the showWarning method is called, the thread should stop.
•	Thread 5 in the threads list should read numbers from the console until "N" is entered. Then it should display the sum of the entered numbers.*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        Thread thread1 = new Thread(() -> {
            while (true) ;
        });
        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        });
        Thread thread3 = new Thread(() -> {
            try {
                while (true) {
                    System.out.println("Hurray");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread4 thread4 = new Thread4();

        Thread thread5 = new Thread(() -> {
            int sum = 0;
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            String check = "";
            while (!check.equals("N")) {
                try {
                    check = bf.readLine();
                    sum += Integer.parseInt(check);
                } catch (Exception e) {

                }
            }
            System.out.println(sum);
        });

        Collections.addAll(threads, thread1, thread2, thread3, thread4, thread5);
    }

    public static void main(String[] args) {
        threads.get(4).start();
    }

    static class Thread4 extends Thread implements Message {
        //1.4. Thread 4 must implement the Message interface. When the showWarning method is called, the thread should stop;
        @Override
        public void showWarning() {
            Thread.currentThread().interrupt();
        }

        @Override
        public void run() {
            while (Thread.currentThread().isAlive()) {

            }
        }
    }
}


