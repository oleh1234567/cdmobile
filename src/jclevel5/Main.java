package jclevel5;

import jclevel5.main.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<String> list = new ArrayList<>();

    static {
        list.add("Hello");
    }

    static {
        System.out.println(list);
    }

    public static void main(String[] args) {

    }
}

