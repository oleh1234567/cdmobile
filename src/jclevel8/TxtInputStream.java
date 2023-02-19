package jclevel8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
Change the TxtInputStream class so that it only works with txt files (* .txt).
For example, first.txt or name.1.part3.txt.
If a non-txt file is passed (e.g. file.txt.exe), then the constructor should throw
an UnsupportedFileNameException.
Think about what else you need to do if an exception is thrown.

Requirements:
•	The TxtInputStream class must inherit the FileInputStream class.
•	If a txt file is passed to the constructor, TxtInputStream should behave like a regular FileInputStream.
•	If a non-txt file is passed to the constructor, an UnsupportedFileNameException should be thrown.
•	If an exception is thrown, then you must also call super.close().

*/

public class TxtInputStream extends FileInputStream {

    public TxtInputStream(String fileName) throws Exception {
        super(fileName);
        if(!fileName.endsWith(".txt")) {
            super.close();
            throw new UnsupportedFileNameException();
        }
    }

    public static void main(String[] args) {
    }
}

class UnsupportedFileNameException extends Exception {
}