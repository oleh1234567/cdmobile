package jclevel6;

/*1.
Figure out what the program does.

Read about UncaughtExceptionHandler - it's important.

Take another careful look at the program.

Figure out why our OurUncaughtExceptionHandler doesn't work (use the debugger).

Fix the bug, i.e. everything should work. :)

Expected result in no particular order:

Thread 1: My exception message

Thread 2: My exception message

Requirements:
•	The main method should create a thread with the following arguments: commonThread and "Thread 1".
•	The main method should create a thread with the following arguments: commonThread and "Thread 2".
•	The main method must start two threads (Thread objects).
•	The main method must interrupt two threads (Thread objects).
•	The program must use OurUncaughtExceptionHandler's uncaughtException method to display 2 messages.
•	Don't explicitly call OurUncaughtExceptionHandler's uncaughtException method.
•	The program's output should contain the following lines: "Thread 1: My exception message" and "Thread 2: My exception message".*/

public class Solution {
    public static Thread.UncaughtExceptionHandler handler = new OurUncaughtExceptionHandler();

    public static void main(String[] args) {
        TestedThread commonThread = new TestedThread(handler);

        Thread threadA = new Thread(commonThread, "Thread 1");
        Thread threadB = new Thread(commonThread, "Thread 2");

        threadA.setUncaughtExceptionHandler(handler);
        threadB.setUncaughtExceptionHandler(handler);

        threadA.start();
        threadB.start();

        threadA.interrupt();
        threadB.interrupt();
    }

    public static class TestedThread extends Thread {
        public TestedThread(Thread.UncaughtExceptionHandler handler) {
            setUncaughtExceptionHandler(handler);
            start();
        }

        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException("My exception message");
            }
        }
    }

    public static class OurUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println(t.getName() + ": " + e.getMessage());
        }
    }
}


