// before
// package me.humenius.fowler.prices;

// public class RegularPrice extends Price {
//     private static RegularPrice instance;

//     private RegularPrice() {}

//     public static RegularPrice getInstance() {
//         if (instance == null) {
//             instance = new RegularPrice();
//         }

//         return instance;
//     }

//     @Override
//     public double getCharge(int daysRented) {
//         double total = 2.0;

//         if (daysRented > 2) {
//             total += (daysRented - 2) * 1.5;
//         }

//         return total;
//     }
// }

// after
package me.humenius.fowler.prices;

public class RegularPrice extends Price {
    private static final double BASE_CHARGE = 2.0;
    private static final int FREE_DAYS = 2;
    private static final double DAILY_RATE = 1.5;

    public RegularPrice() {}

    @Override
    public double getCharge(int daysRented) {
        return getBaseCharge() + getExtraCharge(daysRented);
    }

    private double getBaseCharge() {
        return BASE_CHARGE;
    }

    private double getExtraCharge(int daysRented) {
        return (daysRented > FREE_DAYS) ? (daysRented - FREE_DAYS) * DAILY_RATE : 0;
    }
}