package jclevel5;

public class Moon implements Planet {
    private static Moon instance;

    private Moon() {
    }

    public static Moon getMoon() {
        if (instance == null)
            instance = new Moon();
        return instance;
    }
}
