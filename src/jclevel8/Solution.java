package jclevel8;

/*Read 2 file names from the console: file1, file2.
Write all the bytes in file1 to file2, but in the reverse order.
Close the streams.

Requirements:
•	The program should read a file name twice from the console.
•	Use FileInputStream to read
 from a file, and use FileOutputStream to write to a file.
•	In the second file, you need
 to write all the bytes from the first file in the reverse order.
•	The FileInputStream and FileOutputStream must be closed.*/

/*
src/jclevel8/file1.txt
src/jclevel8/file2.txt
src/jclevel8/file3.txt
* */

import java.io.*;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) throws IOException {
        Stack<Integer> bytes = new Stack<>();

        try(BufferedReader reader =
                    new BufferedReader(new InputStreamReader(System.in));
            FileInputStream file1 = new FileInputStream(reader.readLine());
            FileOutputStream file2 = new FileOutputStream(reader.readLine())
        ){
            while (file1.available() > 0){
                bytes.add(file1.read());
            }
            while (!bytes.isEmpty()){
                file2.write(bytes.pop());
            }
        }
    }
}


