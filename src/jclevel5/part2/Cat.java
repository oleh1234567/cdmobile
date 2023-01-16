package jclevel5.part2;

class Cat {
    public static void print(Object o) {
        System.out.println("Object = " + o);
    }

    public static void print(String s) {
        System.out.println("String = " + s);
    }

    public static void main(String[] args) {
        Cat.print(1);
        Cat.print(null);
    }
}
