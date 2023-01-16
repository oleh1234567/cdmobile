package jclevel5;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/*
1. Initialize the variable Statics.FILE_NAME to the full
path to a data file that contains several lines.
2. Then, in the static block, read all the lines from the
file named Statics.FILE_NAME, and add them separately to the List lines.
*/


public class Solution {
    public static List<String> lines = new ArrayList<>();

    static{
        try {
            lines = Files.readAllLines(Paths.get(Statics.FILE_NAME));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}




