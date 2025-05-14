package me.humenius.fowler.prices;

public class NewReleasePrice extends Price {
    private static NewReleasePrice instance;

    private NewReleasePrice() {}

    public static NewReleasePrice getInstance() {
        if (instance == null) {
            instance = new NewReleasePrice();
        }

        return instance;
    }

    @Override
    public double getCharge(int daysRented) {
        return (daysRented * 3);
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return (daysRented > 1) ? 2 : 1;
    }
}
