// package me.humenius.fowler;

// import static junit.framework.TestCase.assertEquals;

// import org.junit.Test;

// import me.humenius.fowler.prices.ChildrenPrice;
// import me.humenius.fowler.prices.NewReleasePrice;

// public class RentalTest {
//     @Test
//     public void testGetChargeWithNewReleasePrice() {
//         int daysRented = 10;
//         Movie movie = new Movie("Test movie with new release pricing", NewReleasePrice.getInstance());
//         Rental rental = new Rental(movie, daysRented);

//         double actual = rental.getCharge();
//         double expected = (double) daysRented * 3;
//         assertEquals(expected, actual);
//     }

//     @Test
//     public void testGetChargeWithChildrenPrice() {
//         int daysRented = 5;
//         Movie movie = new Movie("Test movie with children price", ChildrenPrice.getInstance());
//         Rental rental = new Rental(movie, daysRented);

//         double actual = rental.getCharge();
//         double expected = 1.5 + (((double) daysRented) - 3) * 1.5;
//         assertEquals(expected, actual);
//     }
// }

// Code Smell:
// Test Duplication: Logika test sama untuk berbagai tipe price
// Feature Envy Test: Test terlalu fokus pada implementasi Movie
// Missing Coverage: Tidak ada test untuk frequent renter points

// Perubahan:

// Mengubah pendekatan test menjadi behavior-focused:

// java
// @Test
// public void getCharge_shouldDelegateToMoviePriceCalculation() {
//     // ...setup
//     assertEquals(expected, rental.getCharge(), DELTA);
// }
// Menambahkan test untuk frequent renter points:

// java
// @Test
// public void getFrequentRenterPoints_shouldDelegateToMoviePriceCalculation() {
//     // ...setup
//     assertEquals(expected, rental.getFrequentRenterPoints());
// }
// Menggunakan delta untuk floating point comparison

// Menggunakan proper assertion parameter order (expected dulu baru actual)


package me.humenius.fowler;

import me.humenius.fowler.prices.ChildrenPrice;
import me.humenius.fowler.prices.NewReleasePrice;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RentalTest {
    private static final double DELTA = 0.001;

    @Test
    public void getCharge_shouldDelegateToMoviePriceCalculation() {
        Movie movie = new Movie("Test", NewReleasePrice.getInstance());
        Rental rental = new Rental(movie, 5);
        
        double expected = movie.getCharge(5);
        assertEquals(expected, rental.getCharge(), DELTA);
    }

    @Test
    public void getFrequentRenterPoints_shouldDelegateToMoviePriceCalculation() {
        Movie movie = new Movie("Test", NewReleasePrice.getInstance());
        Rental rental = new Rental(movie, 5);
        
        int expected = movie.getFrequentRenterPoints(5);
        assertEquals(expected, rental.getFrequentRenterPoints());
    }
}