package jclevel7;

public class ThreadExample extends Thread {

    public ThreadExample() {
        this.start();
    }

    public void run() {

        System.out.println(Thread.currentThread().getName() + " yields its place to others");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + " has finished executing.");
    }

    public static void main(String[] args) {
        new ThreadExample();
        new ThreadExample();
        new ThreadExample();
    }
}