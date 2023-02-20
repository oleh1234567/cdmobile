package jclevel8.packagio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
1 Change the AmigoOutputStream class so that it wraps the FileOutputStream class. Use inheritance.
2 When the close() method is called, perform the following sequence of actions:
2.1 Call the flush() method.
2.2 Append the following text "CodeGym © All rights reserved." Use the getBytes() method.
2.3 Close the stream using the close() method.

Requirements:
•	Don't change the main method.
•	The AmigoOutputStream class must inherit the FileOutputStream class.
•	The AmigoOutputStream class's constructor should accept a FileOutputStream object.
•	All write(), flush(), and close() methods in the AmigoOutputStream class must be delegated to the FileOutputStream object.
•	The close() method must first call the flush() method, append the additional text, and then close the stream.

*/

public class AmigoOutputStream extends FileOutputStream {
    FileOutputStream component;
    public static String fileName = "C:/tmp/result.txt";

    public AmigoOutputStream(FileOutputStream component) throws FileNotFoundException {
        super(fileName);
        this.component = component;
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

    @Override
    public void close() throws IOException {
        super.flush();
        byte[] bytes = "CodeGym © All rights reserved.".getBytes();
    }
}
