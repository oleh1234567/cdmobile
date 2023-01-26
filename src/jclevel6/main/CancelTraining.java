package jclevel6.main;


class Clock implements Runnable{

    @Override
    public void run() {
        Thread current = Thread.currentThread();
        while (!current.isInterrupted()){
            System.out.println("Tick");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class CancelTraining {
    public static void main(String[] args) {
        Clock clock = new Clock();
        Thread thread = new Thread(clock);
        thread.start();
        try{
            Thread.sleep(2500);
        } catch (InterruptedException e){

        }
        thread.interrupt();
    }
}
