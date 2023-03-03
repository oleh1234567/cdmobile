package jclevel9;

import java.io.IOException;

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

public interface AmigoStringWriter {
    void flush() throws IOException;
    void writeString(String s) throws IOException;
    void close() throws IOException;
}
