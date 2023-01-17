package jclevel5;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
1. In separate files, create Plane and Helicopter classes that implement the CanFly interface.
2. The Plane class must have a constructor with an int parameter (the number of passengers on board).
3. In the Solution class's static reset method:
3.1. Read a String from the console.
3.2. If the value is "helicopter", then assign a Helicopter object to the static CanFly field result.
3.3. If the value is "plane", then read a second value (an int, the number of passengers), and assign a Plane object to the static CanFly field result.
4. In the static block, initialize the CanFly field result by calling the reset method.
5. Close the input stream with the close() method.
*/


public class Solution {
    public static void main(String[] args) {

    }

    static {
        try {
            reset();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static CanFly result;

    public static void reset() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in))
        ) {
            switch (bufferedReader.readLine()) {
                case "helicopter":
                    result = new Helicopter();
                    break;
                case "plane":
                    int numberOfPassengers = Integer.parseInt(
                            bufferedReader.readLine());
                    result = new Plane(numberOfPassengers);
            }
        }

    }
}



