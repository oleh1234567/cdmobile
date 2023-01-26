package jclevel6;


/*
1. Figure out what the program does.
2. In a static block, read 2 filenames: firstFileName and secondFileName.
3. Inside the Solution class, create a public static ReadFileThread class that implements the ReadFileInterface interface (Think about what is more appropriate: Thread or Runnable).
3.1. The setFileName method must set the name of the file whose contents will be read.
3.2. The getFileContents method must return the contents of the file.
3.3. In the run method, read the contents of the file and close the stream. Separate the lines of the file with spaces.
4. Think about where you need to wait for the thread to finish to ensure that the files are displayed sequentially.
4.1. To do this, add a call to the appropriate method.

Expected output:
[entire contents of the first file]
[entire contents of the second file]

Requirements:
•	The Solution class's static block should read from the console the names of two files and store them in the variables firstFileName and secondFileName.
•	In the Solution class, declare the public static ReadFileThread class.
•	The ReadFileThread class must implement the ReadFileInterface interface.
•	The ReadFileThread class must inherit the appropriate class.
•	The ReadFileThread class's run method should read lines from the file set by
the setFileName method.
And the getFileContents method of this same class must return the file contents.
The return value is one string consisting of the lines of the file, separated by spaces.
•	The systemOutPrintln method must call the join method on the created object f.
•	The program's output should consist of 2 lines. Each line contains the contents of one file.
*/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static {
        Scanner scanner = new Scanner(System.in);
        firstFileName = scanner.nextLine();
        secondFileName = scanner.nextLine();
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContents());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContents();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {

        private String fullFileName;
        private StringBuilder result = new StringBuilder();

        @Override
        public void setFileName(String fullFileName) {
            //3.1. The setFileName method must set the name
            // of the file whose contents will be read.

            this.fullFileName = fullFileName;
        }

        @Override
        public String getFileContents() {
            //3.2. The getFileContents method must return the contents of the file.
            return result.toString();
        }

        @Override
        public void run() {
            try(Stream<String> stream = Files.lines(Paths.get(fullFileName))) {
                stream.forEach(line -> {
                    result.append(line);
                    result.append(" ");
                });
                result.deleteCharAt(result.length()-1);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


