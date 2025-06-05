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
    private static final double ADDITIONAL_DAY_CHARGE = 1.5;

    public ChildrenPrice() {}

    @Override
    public double getCharge(int daysRented) {
        double total = BASE_CHARGE;

        if (daysRented > FREE_DAYS) {
            total += (daysRented - FREE_DAYS) * ADDITIONAL_DAY_CHARGE;
        }

        return total;
    }
}