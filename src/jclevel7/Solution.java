package jclevel7;

import java.util.ArrayList;
import java.util.List;

/*

Singleton pattern: synchronization in a method.
The IMF class is the International Monetary Fund.
Create a synchronized block inside the getFund method.
Inside the synchronized block, initialize imf so that the getFund method
always returns the same object.

Requirements:
•	The IMF class must have a private static IMF field imf.
•	The IMF class must have a private constructor.
•	The IMF class must have a public static IMF getFund() method.
•	The getFund() method must have a synchronized block.
•	The synchronized block must initialize imf.
•	The getFund() method must always return the same object.
*/


public class Solution {
    public static void main(String[] args) {
        IMF fund = IMF.getFund();
        IMF anotherFund = IMF.getFund();
        System.out.println(fund.equals(anotherFund));
    }
}


