// before
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

// after
package me.humenius.fowler.prices;

/**
 * <h1>Price</h1>
 * <p>An interface whose classes should provide functionality for charge and rental points calculation.</p>
 */
public abstract class Price {
    /**
     * Get charge which can be calculated from each class independently.
     * @param   daysRented  Amount of days the movie has been rented
     * @return  Total charge of a rental
     */
    public abstract double getCharge(int daysRented);

    /**
     * @param   daysRented  Amount of days the movie has been rented
     * @return  Total amount of possible renter points
     */
    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}