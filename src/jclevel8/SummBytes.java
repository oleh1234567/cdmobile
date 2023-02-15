package jclevel8;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class SummBytes {
    public static void main(String[] args) throws Exception
    {
        //Create a FileInputStream object bound to «c:/data.txt».
        FileInputStream inputStream =
                new FileInputStream("src\\jclevel8\\data.txt");
        FileOutputStream outputStream =
                new FileOutputStream("src\\jclevel8\\copy.txt");
        long sum = 0;

        while (inputStream.available() > 0) //as long as there are unread bytes
        {
            int data = inputStream.read(); //Read the next byte
            System.out.println(data);
            outputStream.write(data);
        }
        inputStream.close(); // Close the stream
        outputStream.close();
        System.out.println(sum); // Display the sum on the screen.
    }
}
