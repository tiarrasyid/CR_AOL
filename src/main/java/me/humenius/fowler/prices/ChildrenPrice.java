package me.humenius.fowler.prices;

public class ChildrenPrice extends Price {
    private static ChildrenPrice instance;

    private ChildrenPrice() {}

    public static ChildrenPrice getInstance() {
        if (instance == null) {
            instance = new ChildrenPrice();
        }

        return instance;
    }

    @Override
    public double getCharge(int daysRented) {
        double total = 1.5;

        if (daysRented > 3) {
            total += (daysRented - 3) * 1.5;
        }

        return total;
    }
}
