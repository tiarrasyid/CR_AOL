// before
// package me.humenius.fowler.prices;

// public class ChildrenPrice extends Price {
//     private static ChildrenPrice instance;

//     private ChildrenPrice() {}

//     public static ChildrenPrice getInstance() {
//         if (instance == null) {
//             instance = new ChildrenPrice();
//         }

//         return instance;
//     }

//     @Override
//     public double getCharge(int daysRented) {
//         double total = 1.5;

//         if (daysRented > 3) {
//             total += (daysRented - 3) * 1.5;
//         }

//         return total;
//     }
// }

// after
package me.humenius.fowler.prices;

public class ChildrenPrice extends Price {
    private static final double BASE_CHARGE = 1.5;
    private static final int FREE_DAYS = 3;
    private static final double DAILY_RATE = 1.5;

    public ChildrenPrice() {}

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