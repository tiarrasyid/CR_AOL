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
    private static final double ADDITIONAL_DAY_CHARGE = 1.5;

    public RegularPrice() {}

    @Override
    public double getCharge(int daysRented) {
        double total = BASE_CHARGE;

        if (daysRented > FREE_DAYS) {
            total += (daysRented - FREE_DAYS) * ADDITIONAL_DAY_CHARGE;
        }

        return total;
    }
}