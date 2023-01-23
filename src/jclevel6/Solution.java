package jclevel6;

import java.util.ArrayList;
import java.util.List;

/*

In the main method, add 5 threads to the static list.
Each thread must be a new Thread object that works with its own SpecialThread object.
 */


public class Solution {
    public static volatile List<Thread> list = new ArrayList<>(5);

    public static void main(String[] args) {
        for(int i = 0; i < 5; i++)
            list.add(new Thread(new SpecialThread()));
    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("This is the run method inside SpecialThread");
        }
    }
}
