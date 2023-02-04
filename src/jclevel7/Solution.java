package jclevel7;

/*
1. Make it so that the result is calculated for all the array elements,
WITHOUT using Thread.sleep in the main(String[] args) method.
2. Correct the synchronized block so that the values array is filled with 1s

Requirements:
•	The Solution class must contain the Counter class.
•	The Counter class must be a thread.
•	The Counter class's run() method must have a synchronized block.
•	The run() method's synchronized block must not lock this.
•	The Solution class's main(String[] args) method should not use Thread.sleep().
•	For each thread, in the Solution class's main(String[] args) method,
 use a method that waits for the thread to end.

*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();
        Counter counter3 = new Counter();
        Counter counter4 = new Counter();

        counter1.start();
        counter2.start();
        counter3.start();
        counter4.start();
        counter1.join();
        counter2.join();
        counter3.join();
        counter4.join();

        for (int i = 1; i <= 100; i++) {
            if (values[i] != 1) {
                System.out.println("The values array contains elements not equal to 1");
                break;
            }
        }
    }

    public static Integer count = 0;
    public static int[] values = new int[105];

    static {
        for (int i = 0; i < 105; i++) {
            values[i] = 0;
        }
    }

    public static void incrementCount() {
        count++;
    }

    public static int getCount() {
        return count;
    }

    public static class Counter extends Thread {
        @Override
        public void run() {
            do {
                synchronized (Solution.class) {
                    incrementCount();
                    values[getCount()]++;
                }

                try {
                    Thread.sleep(1);
                } catch (InterruptedException ignored) {
                }
            } while (getCount() < 100);
        }
    }
}


