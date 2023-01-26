package jclevel6.main;

public class StackOverFlow {
    int sof(){
       return sof();
    }

    public static void main(String[] args) {
        new StackOverFlow().sof();
    }
}
