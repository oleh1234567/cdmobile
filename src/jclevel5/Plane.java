package jclevel5;

public class Plane implements CanFly{
    int numberOfPassengers;

    public Plane(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    @Override
    public void fly() {

    }
}
