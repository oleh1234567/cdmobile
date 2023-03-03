package jclevel9;

/*Replace the main method's System.out object with your own reader wrapper similar
 to the one shown in the lesson.
Your reader wrapper should convert all text to uppercase letters.
Call testString's existing printSomething() method.
Restore the System.out variable back to the original stream.
Display the modified string.

Requirements:
•	The Solution class must contain a TestString class.
•	The Solution class must have a public static TestString field called
testString that is initialized immediately.
•	The TestString class must have a public void printSomething() method.
•	The TestString class's printSomething() method must display "This is text for testing".
•	The Solution class's main(String[] args) method must create a PrintStream object
(use the PrintStream constructor with a ByteArrayOutputStream parameter).
•	The Solution class's main(String[] args) method should replace and then restore
the console output stream (System.out).
•	The Solution class's main(String[] args) method must call testString's printSomething() method.
•	The Solution class's main(String[] args) method must modify the line printed by
the printSomething() method, as per the task conditions, and output it to the console.*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("This is text for testing");
        }
    }
}




