package jclevel10;


/*Write a program that will read detailed information about
 a folder and display it on the console.

First of all, read the folder path from the console.
If the entered path is not a directory, display "[full path] is not
 a folder" and exit the program.
Then calculate and display the following information:

Total folders: [the number of folders in the directory and subdirectories]
Total files: [the number of files in the directory and subdirectories]
Total size: [the total number of bytes stored in the directory]

Only use classes and methods from the java.nio package.

Don't display the square brackets ("[]").

Requirements:
•	The main method must read the folder path from the console.
•	If the entered path isn't a directory, you need to display
 "[full path] is not a folder" and exit the program.
•	Only use classes and methods from the java.nio package.
•	The following information must be displayed on the console:
"Total folders: [the number of folders in the directory and subdirectories]".
•	The following information must be displayed on the console:
"Total files: [the number of files in the directory and subdirectories]".
•	The following information must be displayed on the console:
"Total size: [the total number of bytes stored in the directory]".*/



import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        try(Scanner scanner = new Scanner(System.in)){
            Path path = Paths.get(scanner.nextLine());
            if(!path.toFile().isDirectory()){
                System.out.println(path.toAbsolutePath() +
                                " is not a folder");
            } else {

                MyVisitor myVisitor = new MyVisitor();
                Files.walkFileTree(path, myVisitor);

                displayInfo(myVisitor.directories, myVisitor.files, myVisitor.size);
            }
        }
    }

    private static class MyVisitor extends SimpleFileVisitor<Path>{
        private int directories = 0;
        private int files = 0;
        private  int size = 0;
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                throws IOException {
                files++;
                size += Files.readAllBytes(file).length;
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            directories++;
            return FileVisitResult.CONTINUE;
        }
    }

    private static void displayInfo(int dirs, int files, int size){
        System.out.println("Total folders: " + dirs +
                "\nTotal files: " + files +
                "\nTotal size: " + size);
    }
}

