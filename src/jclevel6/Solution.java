package jclevel6;

/*
1. Figure out what the program does.
2. Make the program first display the result of the thread,
and when the thread has finished then the main method continues.

3. Example output:
inside MyThread 0
inside MyThread 1
...
inside MyThread 9
inside main 0
inside main 1
...
inside main 9

Requirements:
•	The main method must call the start method on thread t.
•	The main method must call the join method on thread t.
•	At first, the program should display 10 lines starting with "inside MyThread".
•	At the end, the program should display 10 lines starting with "inside main".
•	In total, the program should display 20 lines.
*/


public class Solution {
    public static MyThread t = new MyThread();
    static String message = "inside main ";

    public static void main(String a[]) throws Exception {
        t.start();
        t.join();
        for (int i = 0; i < 10; i++) {
            System.out.println(message + i);
            sleep();
        }
    }

    public static void sleep() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
        }
    }

    static class MyThread extends Thread {
        String message = "inside MyThread ";

        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(message + i);
                Solution.sleep();
            }
        }
    }
}
