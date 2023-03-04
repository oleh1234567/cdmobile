package jclevel9;

/*Read 2 file names from the console: file1 and file2.
Both files contain text, but file2 is an updated version of file1. Some of the lines are still the same.
You need to create a merged version of the lines by writing them to the lines list.
The ADDED and REMOVED labels can't be used consecutively—they must always separated by the SAME label.
The example includes empty lines for clarity.
Neither the original file nor the updated file have empty lines!

Example 1:

In the example, empty lines mean that the line is not in the specified file.

Requirements:
•	The Solution class must contain a LineItem class.
•	The Solution class must have an enum called Type.
•	The Solution class must have a public static List<LineItem> field called lines that is initialized immediately.
•	In the main(String[] args) method, the program must read file names from the console (use BufferedReader).
•	In the main(String[] args) method, the BufferedReader used for reading input from the console must be
closed after use.
•	The program must read the contents of the first and second file (use FileReader).
•	The file input streams (FileReader) must be closed.
•	The lines list should contain the merged version of the lines from the files.
Each line should start with the label ADDED, REMOVED, or SAME, depending on the action taken.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/*
Tracking changes

*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<>();

    public static void main(String[] args) {
        try (BufferedReader bufferedReader =
                     new BufferedReader(new InputStreamReader(System.in));
             FileReader fileReader1 =
                     new FileReader(bufferedReader.readLine());
             FileReader fileReader2 =
                     new FileReader(bufferedReader.readLine());
             BufferedReader reader1 = new BufferedReader(fileReader1);
             BufferedReader reader2 = new BufferedReader(fileReader2)) {

            Stream.

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static enum Type {
        ADDED,        // New line added
        REMOVED,      // Line deleted
        SAME          // No change
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}





