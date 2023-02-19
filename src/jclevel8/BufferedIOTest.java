package jclevel8;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedIOTest {
    public static void main(String[] args) throws IOException {
        try(FileInputStream inputStream =
                new FileInputStream("src/jclevel8/data.txt");
            BufferedInputStream bufferedStream =
                    new BufferedInputStream(inputStream, 200)
        ){
            while (bufferedStream.available() > 0){
                System.out.print((char)bufferedStream.read());
            }
        }
    }
}
