package jclevel6.main;

class Printer implements Runnable{
    String name;
    Printer(String name){
        this.name = name;
    }
    @Override
    public void run() {
        System.out.println("I'm " + this.name);
    }
}

public class Test {
    public static void main(String[] args) {
        Printer printer = new Printer("Vasya");
        Thread thread1 = new Thread(printer);
        Thread thread2 = new Thread(new Printer("Loh"));
        Thread thread3 = new Thread(new Printer("Pituh"));

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
