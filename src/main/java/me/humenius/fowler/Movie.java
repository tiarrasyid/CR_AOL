// package me.humenius.fowler;

// import me.humenius.fowler.prices.Price;

// /**
//  * <h1>Movie</h1>
//  * <p>A class that represents a movie with {@code title} and a {@link Price}.</p>
//  */
// public class Movie {
//     private final String title;
//     private final Price price;

//     Movie(String title, Price price) {
//         this.title = title;
//         this.price = price;
//     }

//     public String getTitle() {
//         return title;
//     }

//     /**
//      * Get charge which can be calculated from each class independently.
//      * @param   daysRented  Amount of days the movie has been rented
//      * @return  Total charge of a rental
//      */
//     public double getCharge(int daysRented) {
//         return price.getCharge(daysRented);
//     }

//     /**
//      * @param   daysRented  Amount of days the movie has been rented
//      * @return  Total amount of possible renter points
//      */
//     public int getFrequentRenterPoints(int daysRented) {
//         return price.getFrequentRenterPoints(daysRented);
//     }
// }

package me.humenius.fowler;

import me.humenius.fowler.prices.Price;

public class Movie {
    private final String title;
    private final Price price;

    Movie(String title, Price price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public double calculateCharge(int daysRented) {
        return price.getCharge(daysRented);
    }

    public int calculateFrequentRenterPoints(int daysRented) {
        return price.getFrequentRenterPoints(daysRented);
    }
}
