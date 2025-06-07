// package me.humenius.fowler.prices;

// /**
//  * <h1>Price</h1>
//  * <p>An interface whose classes should provide functionality for charge and rental points calculation.</p>
//  */
// public abstract class Price {
//     /**
//      * Get charge which can be calculated from each class independently.
//      * @param   daysRented  Amount of days the movie has been rented
//      * @return  Total charge of a rental
//      */
//     public abstract double getCharge(int daysRented);

//     /**
//      * @param   daysRented  Amount of days the movie has been rented
//      * @return  Total amount of possible renter points
//      */
//     public int getFrequentRenterPoints(int daysRented) {
//         return 1;
//     }
// }

package me.humenius.fowler.prices;

public abstract class Price {
    public abstract double getBaseCharge();
    public abstract int getThresholdDays();
    public abstract double getSurchargePerDay();

    public double getCharge(int daysRented) {
        double total = getBaseCharge();
        if (daysRented > getThresholdDays()) {
            total += (daysRented - getThresholdDays()) * getSurchargePerDay();
        }
        return total;
    }

    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
