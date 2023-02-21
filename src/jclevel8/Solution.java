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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

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
        String updatedLine =
                String.format("%-8s%-30s%-8s%-4s", id, productName, price, quantity);

        List<String> updatedLines = Files.readAllLines(Paths.get(fileName));

        boolean deletion = productName.equals("") && price.equals("") && quantity.equals("");

        for (int i = 0; i < updatedLines.size(); i++) {
            if (updatedLines.get(i).substring(0, 8).trim().equals(id) && !deletion)
                updatedLines.set(i, updatedLine);
            else if (updatedLines.get(i).substring(0, 8).trim().equals(id) && deletion) {
                updatedLines.remove(i++);
            }
        }

        try (PrintWriter printWriter = new PrintWriter(fileName)) {
            for (String line : updatedLines)
                printWriter.println(line);
        }
    }

    private static void deleteLine(String fileName, String id) throws IOException {
        updateLine(fileName, id, "", "", "");
    }
}



