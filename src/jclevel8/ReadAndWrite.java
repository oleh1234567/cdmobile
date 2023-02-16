package jclevel8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadAndWrite {
    public static void main(String[] args) throws IOException {
        try (FileInputStream inputStream =
                     new FileInputStream("src\\jclevel8\\data.txt");
             FileOutputStream outputStream =
                     new FileOutputStream("src\\jclevel8\\copy.txt")
        ) {
            byte[] buffer = new byte[1024*1024];
            while (inputStream.available() > 0){
                int count = inputStream.read(buffer);
                outputStream.write(buffer, 0, count);
            }

            outputStream.flush();
        }


    }
}
