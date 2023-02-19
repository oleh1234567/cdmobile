package jclevel8;

/*
The program is started with one argument: the name of a file that contains text.
Calculate how often each symbol is encountered.
Sort the results by increasing ASCII code (read about it online).

Example:
','=44, 's'=115, 't'=116.

Display the sorted results:
[symbol1] frequency1
[symbol2] frequency2
Close the streams.

Example output:
, 19
- 7
f 361

Requirements:
•	You don't need to read anything from the console.
•	Create a stream to read from the file passed as the first argument of the main method.
•	You need to calculate the frequency of each symbol in the file and display the results.
•	The displayed results should be sorted by ascending ASCII code.
•	The stream used to read the file must be closed.
*/

/*
src/jclevel8/file1.txt
src/jclevel8/file2.txt
src/jclevel8/file3.txt
* */


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<Character, Frequency> charFrequencies =
                new TreeMap<>(Comparator.naturalOrder());
        try(FileInputStream fileInputStream = new FileInputStream(args[0])){
            while(fileInputStream.available() > 0){
                Character character = (char)fileInputStream.read();
                if(!charFrequencies.containsKey(character)){
                    charFrequencies.put(character, new Frequency());
                } else{
                    charFrequencies.get(character).count++;
                }
            }
        }

        for(Character key : charFrequencies.keySet()){
            System.out.println(key + " " + charFrequencies.get(key));
        }
    }
    private static class Frequency{
        Integer count = 1;

        @Override
        public String toString() {
            return count + "";
        }
    }
}




