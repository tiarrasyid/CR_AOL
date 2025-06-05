// before
// package me.humenius.fowler.prices;

// public class NewReleasePrice extends Price {
//     private static NewReleasePrice instance;

//     private NewReleasePrice() {}

//     public static NewReleasePrice getInstance() {
//         if (instance == null) {
//             instance = new NewReleasePrice();
//         }

//         return instance;
//     }

//     @Override
//     public double getCharge(int daysRented) {
//         return (daysRented * 3);
//     }

//     @Override
//     public int getFrequentRenterPoints(int daysRented) {
//         return (daysRented > 1) ? 2 : 1;
//     }
// }

// after
package me.humenius.fowler.prices;

public class NewReleasePrice extends Price {
    private static final int DAILY_RATE = 3;
    private static final int BONUS_POINT_THRESHOLD = 1;
    private static final int BONUS_POINTS = 2;
    private static final int REGULAR_POINTS = 1;

    public NewReleasePrice() {}

    @Override
    public double getCharge(int daysRented) {
        return daysRented * DAILY_RATE;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return (daysRented > BONUS_POINT_THRESHOLD) ? BONUS_POINTS : REGULAR_POINTS;
    }
}