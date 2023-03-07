package jclevel9;



/*
Replace the System.out object in the main method with your own reader wrapper.
Your reader wrapper should display a contextual ad after every other call to println.
Call testString's existing printSomething() method.
Restore the System.out variable back to the original stream.

Ad text: "CodeGym - online Java courses"

Example output:
first
second
CodeGym - online Java courses
third
fourth
CodeGym - online Java courses
fifth

Requirements:
•	The Solution class must contain a TestString class.
•	The Solution class must have a public static TestString field called testString
 that is initialized immediately.
•	The TestString class must have a public void printSomething() method.
•	The TestString class's printSomething() method must display the following lines:
 "first","second","third","fourth","fifth".
•	The Solution class's main(String[] args) method
 must create a PrintStream object (use the PrintStream constructor with
  a ByteArrayOutputStream parameter).
•	The Solution class's main(String[] args) method
 should replace and then restore the console output stream (System.out).
•	The Solution class's main(String[] args) method
 must call testString's printSomething() method.
•	The Solution class's main(String[] args) method
 must modify and display the lines output by the printSomething()
  method (by adding contextual ads), as per the task conditions.
*/

/*
Replacing numbers

*/


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/*
Correct the bug. Classes and interfaces

*/

public class Solution {
    {
        System.out.println("This is the Solution class");
    }

    public static void main(String... args) throws IOException {
        try (
                FileOutputStream outputStream = new FileOutputStream(args[0]);
                InputStream is = Solution.class.getClassLoader().getResourceAsStream(args[1]);
        ) {
            ;
            byte[] b = new byte[is.available()];
            outputStream.write(is.read(b));

            int value = 123_456_789;
            System.out.println(value);

            Example result = null;
            String s = "a";
            switch (s) {
                case "a": {
                    result = new Solution().new A();
                    break;
                }
                case "b": {
                    result = new Solution().new B();
                    break;
                }
                case "c": {
                    result = new Solution().new C();
                    break;
                }
            }

            if (result instanceof A) {
                C p = (C) result;
                System.out.println(p.getClass().getSimpleName());
            }

        } catch (IOException e) {
        }
    }

    interface Example {
    }

    class A implements Example {
        {
            System.out.println("This is the A class");
        }
    }

    class B implements Example {
        {
            System.out.println("This is the B class");
        }
    }

    class C extends A {
        {
            System.out.println("This is the C class");
        }
    }
}







