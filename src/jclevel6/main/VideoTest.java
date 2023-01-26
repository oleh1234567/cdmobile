package jclevel6.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VideoTest {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        Collections.addAll(strings, "acvv", "dsadsadsa", "121", "fsafsafsafsafsafasfas");
        Integer integer = strings.stream()
                        .mapToInt(x -> x.length())
                        .max().getAsInt();
        System.out.println(integer);
    }
}
