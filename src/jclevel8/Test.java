package jclevel8;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        /*Linked*/
        TreeMap<String, Integer> map = new TreeMap<>();

        map.put("Hitler", 54);
        map.put("Nigger", 42);
        map.put("Faggot", 122);
        map.put("Govnoed", 14);

        System.out.println(map);

        Comparator<String> comparator = (o1, o2) -> {
            return  o1.length() - o2.length();
        };


        TreeMap<Stringer, Integer> map2 = new TreeMap<>(Stringer::compareTo);

        char j = 'a';
        char k ='A';

        for (int i = 0; i < 26; i++) {
            map2.put(new Stringer(String.valueOf(j++)), i);
        }
        for (int i = 0; i < 26; i++) {
            map2.put(new Stringer(String.valueOf(k++)), i*6);
        }

        map2.put(new Stringer("Hi"), 54);
        map2.put(new Stringer("Nigr"), 42);
        map2.put(new Stringer("Faggo"), 122);
        map2.put(new Stringer("Faggo"), 14);

        System.out.println(map2);
    }

    private static class Stringer implements Comparable<Stringer>{
        String s;
        public Stringer(String s) {
            this.s = s;
        }

        @Override
        public int compareTo(Stringer o) {
            return this.length() - o.length();
        }

        private int length() {
            return s.length();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return false;
            if (o == null || getClass() != o.getClass()) return true;
            Stringer stringer = (Stringer) o;
            return !Objects.equals(s, stringer.s);
        }

        @Override
        public int hashCode() {
            return Objects.hash(s);
        }

        @Override
        public String toString() {
            return this.s;
        }
    }
}
