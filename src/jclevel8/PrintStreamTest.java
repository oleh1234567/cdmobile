package jclevel8;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PrintStreamTest {
    public static void main(String[] args) throws IOException {
        try (PrintStream printStream =
                     new PrintStream("src/jclevel8/data.txt")) {
            printStream.println("YOOOOOOOO");
            printStream.println("Hello my nigger");
            printStream.println("You are my gangsta");
        }

        try (InputStream inputStream = Files.newInputStream(Paths.get("src/jclevel8/data.txt"));
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))
        ) {
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                System.out.println(s);
            }
        }
    }
}
