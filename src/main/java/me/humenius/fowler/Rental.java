// package me.humenius.fowler;

// /**
//  * <h1>Rental</h1>
//  * <p>Entity which represents a movie rental.</p>
//  */
// class Rental {
//     private final Movie movie;
//     private final int daysRented;

//     Rental(Movie movie, int daysRented) {
//         this.movie = movie;
//         this.daysRented = daysRented;
//     }

//     public int getDaysRented() {
//         return daysRented;
//     }

//     public Movie getMovie() {
//         return movie;
//     }

//     /**
//      * @return  Charge of movie based of days rented.
//      */
//     public double getCharge() { return movie.getCharge(daysRented); }

//     /**
//      * @return  Frequent renter points of movie based of days rented.
//      */
//     public int getFrequentRenterPoints() {
//         return movie.getFrequentRenterPoints(daysRented);
//     }
// }

package me.humenius.fowler;

// Code smell: Class package-private membatasi akses dari package lain
// Perubahan: Mengubah class ke public
public class Rental {
    private final Movie movie;
    private final int daysRented;

    // Code smell: Constructor package-private
    // Perubahan: Mengubah ke public constructor
    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    // Code smell: Method package-private
    // Perubahan: Mengubah ke public untuk encapsulation yang lebih baik
    public double getCharge() {
        return movie.getCharge(daysRented);
    }

    // Code smell: Method package-private
    // Perubahan: Mengubah ke public untuk encapsulation yang lebih baik
    public int getFrequentRenterPoints() {
        return movie.getFrequentRenterPoints(daysRented);
    }
}