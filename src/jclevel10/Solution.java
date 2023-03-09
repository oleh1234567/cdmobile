package jclevel10;


/*
1. The main method is passed two arguments as inputs.
The first argument is path, which is the path to the directory; the second
 is resultFileAbsolutePath,
which is the name (full path) of an existing file that will store the result.
2. For each file in the path directory and in all of its subdirectories,
do the following:
For each file whose size in bytes is NOT greater than 50, do the following:
2.1. Sort them by file name in ascending order. Don't include the path when sorting.
2.2. Rename resultFileAbsolutePath to "allFilesContent.txt"
(use the FileUtils.renameFile method and
FileUtils.isExist if necessary).
2.3. Sequentially write the contents of each file from step 2.1 to allFilesContent.txt.
After the body of each file, write "\n".
All files have the TXT extension.
Use "/" as the path separator.

Requirements:
•	The file passed as the second argument to main must be renamed to
allFilesContent.txt.
•	You need to create a stream to write to the renamed file.
•	The contents of every file that is 50 bytes or smaller must be written to
the allFilesContent.txt file.
•	The output stream to the file must be closed.
•	Don't use static variables.

*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Solution {
    public static void main(String[] args) throws IOException {
        File directory = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);

        rename(resultFileAbsolutePath);

        List<File> allFiles = new ArrayList<>();

        getAllFilesToList(directory, allFiles);


        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(new FileWriter(resultFileAbsolutePath))) {

            // Потрібно тут дістати назву файлу і якось назад вернутися
            // до його повного шляху. Написати Компаратор чи щось таке????
            // Використати PAth???
            allFiles.stream()
                    .filter(file -> file.length() <= 50)
                    .map(File::getName)
                    .sorted()
                    .forEach(file -> write(bufferedWriter, file));
        }
    }

    private static void write(BufferedWriter bufferedWriter, File file) {
        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader(file))) {

            while (bufferedReader.ready()){
                bufferedWriter.write(bufferedReader.readLine());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void rename(File resultFileAbsolutePath) {
        File dest =
                new File(resultFileAbsolutePath.getParent() +
                        "\\allFilesContent.txt");

        if (FileUtils.isExist(resultFileAbsolutePath)) {
            FileUtils.renameFile(resultFileAbsolutePath, dest);
        }
    }

    private static void getAllFilesToList(File directory, List<File> allFiles) {

        File[] files = Objects.requireNonNull(directory.listFiles());

        Arrays.stream(files)
                .filter(File::isFile)
                .forEach(allFiles::add);

        Arrays.stream(files)
                .filter(File::isDirectory)
                .forEach(dir -> getAllFilesToList(dir, allFiles));

    }
}

