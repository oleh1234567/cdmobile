package jclevel5;

public class LatteMaker extends DrinkMaker{
    @Override
    void getRightCup() {
        System.out.println("Grab a cup for latte");
    }

    @Override
    void addIngredients() {
        System.out.println("Fill with foamy milk");
    }

    @Override
    void pour() {
        System.out.println("Make coffee");
    }
}
