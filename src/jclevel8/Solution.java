package jclevel8;

/*
CrUD for a table inside a file
Read a file name for CrUD operations from the console

The program runs with one of the following sets of arguments:
-u id productName price quantity
-d id

Argument values:
where id is 8 characters
productName is 30 characters
price is 8 characters
quantity is 4 characters
-u updates the data for the product with the specified id
-d performs the physical deletion of the product with
the specified id (all data related to the passed id)

The file data is stored in the following order (without separating spaces):
id productName price quantity
Each data field is padded with spaces up to its length

Example:
19847   Swim trunks, blue             159.00  12
198479  Swim trunks, black with printe173.00  17
19847983Snowboard jacket with reflecti10173.991234

Requirements:
•	The program should read a file name for CrUD operations from the console.
•	When you run the program without arguments, the product list must remain unchanged.
•	When the program is started with the arguments "-u id productName
price quantity", the product information in the file should be updated.
•	When the program is started with the arguments "-d id", the line for
the product with the specified id should be removed from the file.
•	The file streams must be closed.
*/

/*
src/jclevel8/file1.txt
src/jclevel8/file2.txt
src/jclevel8/file3.txt
src/jclevel8/data.txt
* */

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader =
                     new BufferedReader(new InputStreamReader(System.in))) {
            String fileName = bufferedReader.readLine();
            if (args.length > 0) {
                switch (args[0]) {
                    case "-u":
                        updateLine(fileName, args[1], args[2], args[3], args[4]);
                        break;
                    case "-d":
                        deleteLine(fileName, args[1]);
                }
            }
        }
    }

    private static void updateLine(String fileName, String id,
                                   String productName, String price,
                                   String quantity) throws IOException {
        try(BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(
                            new FileInputStream(fileName)))){
            String line;
            while(!(line = bufferedReader.readLine())
                    .substring(0, 8)
                    .trim()
                    .equals(id)){}
            System.out.println(line);
        }
    }

    private static void deleteLine(String fileName, String arg) {
    }



}



