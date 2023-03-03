package jclevel9;

/*Use the AdapterFileOutputStream class to adapt FileOutputStream to the new AmigoStringWriter interface.

Requirements:
•	AmigoStringWriter must be an interface.
•	The AdapterFileOutputStream class must implement the AmigoStringWriter interface.
•	The AdapterFileOutputStream class must have a private FileOutputStream field called fileOutputStream.
•	The AdapterFileOutputStream class must have a constructor with a FileOutputStream parameter.
•	The AdapterFileOutputStream class's flush() method must delegate the call to fileOutputStream.
•	The AdapterFileOutputStream class's writeString(String s) method must delegate the call to the
fileOutputStream field's corresponding write() method.
•	The AdapterFileOutputStream class's close() method must delegate the call to fileOutputStream.*/

import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterFileOutputStream implements AmigoStringWriter{
    private FileOutputStream fileOutputStream;

    public AdapterFileOutputStream(FileOutputStream fileOutputStream) {
        this.fileOutputStream = fileOutputStream;
    }

    public static void main(String[] args) {

    }

    @Override
    public void flush() throws IOException {
        fileOutputStream.flush();
    }

    @Override
    public void writeString(String s) throws IOException {
        fileOutputStream.write(s.getBytes());
    }

    @Override
    public void close() throws IOException {
        fileOutputStream.close();
    }
}
