package jclevel10;


/*Implement the getProperties method, which must read the properties from the passed fileName file.
fileName can have any extension, e.g. XML, any other extension, or none at all.
You need to ensure the properties are read properly.
If errors occur, a null object must be returned.
The main method is not tested.

Hint: you may need File.separator.

Requirements:
•	The Solution class must have a Properties getProperties(String fileName) method.
•	The getProperties method must correctly read the properties of an XML file.
•	The getProperties method must correctly read the properties from a file with any other extension.
•	The getProperties method must correctly return a null object if an error occurs while reading the properties.*/


import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("C:\\Users\\kuznetsov.aa.HITED1UA\\IdeaProjects\\cdmobile\\src\\jclevel10\\properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("C:\\Users\\kuznetsov.aa.HITED1UA\\IdeaProjects\\cdmobile\\src\\jclevel10\\properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("C:\\Users\\kuznetsov.aa.HITED1UA\\IdeaProjects\\cdmobile\\src\\jclevel10\\NotExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        Properties properties = new Properties();
        try {

            if (fileName.endsWith(".xml"))
                properties.loadFromXML(Files.newInputStream(Paths.get(fileName)));
            else
                properties.load(new FileReader(fileName));

        } catch (IOException e) {
            return properties;
        }
        return properties;
    }
}

