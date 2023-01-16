package jclevel5;

public class Sun implements Planet{
    private static Sun instance;

    private Sun(){

    }

    public static Sun getSun(){
        if(instance == null)
            instance = new Sun();
        return instance;
    }
}
