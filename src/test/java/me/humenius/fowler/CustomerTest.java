// package me.humenius.fowler;

// import static junit.framework.TestCase.assertTrue;

// import org.junit.Test;

// import me.humenius.fowler.prices.RegularPrice;

// public class CustomerTest {
//     @Test
//     public void testGetStatement() {
//         int daysRented = 5;
//         Customer customer = new Customer("Test Customer");
//         Movie movie = new Movie("Test movie for customer statement fetching", RegularPrice.getInstance());
//         Rental rental = new Rental(movie, daysRented);

//         customer.addRental(rental);

//         String statement = customer.getStatement();
//         boolean expected = statement.contains("Amount owed is " + rental.getCharge());
//         assertTrue(expected);
//     }
// }

// Code Smell:

// Fragile String Assertion: Bergantung pada format string yang spesifik
// Insufficient Coverage: Hanya test total charge tanpa frequent points
// Indirect Testing: Mengecek output string alih-alih logika bisnis

// Perubahan:
// Menambahkan test untuk frequent renter points:
// java
// @Test
// public void statement_shouldAccumulateFrequentRenterPoints() {
//     // ...setup
//     assertTrue(statement.contains("You earned " + expectedPoints + " frequent renter points"));
// }
// Menggunakan perhitungan terpisah untuk expected value:

// java
// double expectedTotal = regularMovie.getCharge(3) + newRelease.getCharge(2);
// Menambahkan multiple rental scenario testing

// Menggunakan static import untuk assertion method


package me.humenius.fowler;

import me.humenius.fowler.prices.NewReleasePrice;
import me.humenius.fowler.prices.RegularPrice;
import org.junit.Test;
import static org.junit.Assert.*;

public class CustomerTest {
    private static final double DELTA = 0.001;
    
    @Test
    public void statement_shouldContainCorrectTotalCharges() {
        Customer customer = new Customer("Test Customer");
        Movie regularMovie = new Movie("Regular", RegularPrice.getInstance());
        Movie newRelease = new Movie("New Release", NewReleasePrice.getInstance());
        
        customer.addRental(new Rental(regularMovie, 3));
        customer.addRental(new Rental(newRelease, 2));
        
        String statement = customer.getStatement();
        double expectedTotal = regularMovie.getCharge(3) + newRelease.getCharge(2);
        
        assertTrue(statement.contains("Amount owed is " + expectedTotal));
    }

    @Test
    public void statement_shouldAccumulateFrequentRenterPoints() {
        Customer customer = new Customer("Test Customer");
        Movie regularMovie = new Movie("Regular", RegularPrice.getInstance());
        Movie newRelease = new Movie("New Release", NewReleasePrice.getInstance());
        
        customer.addRental(new Rental(regularMovie, 3));
        customer.addRental(new Rental(newRelease, 2));
        
        String statement = customer.getStatement();
        int expectedPoints = 1 + 2; // Regular (1) + New Release (2)
        
        assertTrue(statement.contains("You earned " + expectedPoints + " frequent renter points"));
    }
}