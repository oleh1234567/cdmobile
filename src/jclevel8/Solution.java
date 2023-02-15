package jclevel8;

/*Enter a file name from the console.
Find the byte or bytes with the maximum number of repetitions.
Display them on the screen, separated by spaces.
Close the IO stream.

Requirements:
•	The program should read a file name from the console.
•	Use a FileInputStream to read from the file.
•	All of the most frequently repeated bytes from the file should be displayed,
separated by spaces.
•	The screen output should be displayed in one line.
•	The stream used to read the file must be closed.*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, Frequency> map = new HashMap<>();
        try (FileInputStream fileInputStream =
                     new FileInputStream(reader.readLine())) {
            while (fileInputStream.available() > 0) {
                int data = fileInputStream.read();

                if (!map.containsKey(data)) {
                    map.put(data, new Frequency());
                } else {
                    map.get(data).counter++;
                }
            }
        }

        int maxFrequent = map.values().stream()
                .map(frequency -> frequency.counter)
                .max(Comparator.naturalOrder())
                .orElseThrow(RuntimeException::new);

        System.out.println(map);
        System.out.println(maxFrequent);

        Map<Integer, Integer> sortedmap = new HashMap<>();

        for (Map.Entry<Integer, Frequency> entries : map.entrySet()){
            sortedmap.put(entries.getKey(), entries.getValue().counter);
        }

        Stream<Map.Entry<Integer, Integer>> sorted =
                sortedmap.entrySet().stream().sorted(Map.Entry.comparingByValue());

        sorted.filter(integerIntegerEntry -> integerIntegerEntry
                .getValue()
                .equals(maxFrequent))
                .map(Map.Entry::getKey)
                .forEach(System.out::println);
    }
}

class Frequency {
    public Integer counter = 1;

    @Override
    public String toString() {
        return counter + "";
    }
}
