package jclevel8;

/*Using the wrapper (decorator) design pattern, extend the functionality of AmigoOutputStream.
In the QuestionFileOutputStream class, the following functionality should be implemented for the close() method:
1. Display "Do you really want to close the stream? Y/N".
2. Read a line.
3. If the read line is "Y", then close the stream.
4. If the read line is not "Y", then don't close the stream.

Requirements:
•	Don't change AmigoOutputStream.
•	The QuestionFileOutputStream class must implement the AmigoOutputStream interface.
•	The QuestionFileOutputStream class must initialize the AmigoOutputStream field in the constructor.
•	All of QuestionFileOutputStream's methods must be delegated to the AmigoOutputStream object.
•	The close() method should ask the user, "Do you really want to close the stream? Y/N".
•	The close() method should close the stream only if it reads the answer "Y" from the console.*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionFileOutputStream implements AmigoOutputStream {

    AmigoOutputStream component;

    public QuestionFileOutputStream(AmigoOutputStream component) {
        this.component = component;
    }

    @Override
    public void flush() throws IOException {
        component.flush();
    }

    @Override
    public void write(int b) throws IOException {
        component.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        component.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        component.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        System.out.println("Do you really want to close the stream? Y/N");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            if (reader.readLine().equals("Y"))
                component.close();
        }
    }
}
