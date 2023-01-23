package jclevel6;

import java.util.Date;

/*
1. Change the Violin class to make it a task for the thread. Use the MusicalInstrument interface
2. Implement the required method in the Violin thread. The implementation should be as follows:
2.1. Determine the time when you start playing - the startPlaying() method.
2.2. Wait 1 second - the sleepNSeconds(int n) method, where n is the number of seconds.
2.3. Determine the time when you stop playing - the stopPlaying() method.
2.4. Display how long you played the instrument. Use the methods in Items 2.1 and 2.3.

Example: Played for 1002 ms

Requirements:
•	The Violin class should not inherit any additional class.
•	The Violin class should implement the MusicalInstrument interface.
•	The Violin class's run method should call the startPlaying method.
•	The Violin class's run method should call the sleepNSeconds method with an argument of 1 second.
•	The Violin class's run method should call the stopPlaying method.
•	The Violin class's run method should display how long the instrument was played (in milliseconds). Use the format given in the example.

*/

public class Solution {
    public static int delay = 1000;

    public static void main(String[] args) {
        Thread violin = new Thread(new Violin("Player"));
        violin.start();
    }

    public static void sleepNSeconds(int n) {
        try {
            Thread.sleep(n * delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public interface MusicalInstrument extends Runnable {
        Date startPlaying();

        Date stopPlaying();
    }

    public static class Violin implements MusicalInstrument {
        private String owner;

        public Violin(String owner) {
            this.owner = owner;
        }

        public Date startPlaying() {
            System.out.println(this.owner + " is starting to play");
            return new Date();
        }

        public Date stopPlaying() {
            System.out.println(this.owner + " is stopping playing");
            return new Date();
        }

        @Override
        public void run() {
            Date start = startPlaying();
            sleepNSeconds(1);
            Date stop = stopPlaying();
            System.out.printf("Played for %d ms", (stop.getTime() - start.getTime()));
        }
    }
}
