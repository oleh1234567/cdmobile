package jclevel8;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputTest {
    public static void main(String[] args) throws IOException {
        try(FileOutputStream fileOutputStream =
                new FileOutputStream("src/jclevel8/copy.txt", true)){

            fileOutputStream.write("Hello, hangsta\n".getBytes());
        }
    }
}
