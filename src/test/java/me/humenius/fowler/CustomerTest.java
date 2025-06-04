package me.humenius.fowler;

import static junit.framework.TestCase.assertTrue;

import javax.xml.crypto.Data;

import org.junit.Test;

import me.humenius.fowler.prices.RegularPrice;

public class CustomerTest {
    @Test
    public void testGetStatement() {

        // Data Clumps (Code Smell)
        // Reason: Kombinasi objek Movie, Price, dan daysRented selalu muncul bersama berulang dalam test, lebih baik dibuat builder agar lebih rapi dan reusable.
        // Refactoring Technique: Introduce Builder

        // before
        // int daysRented = 5;
        // Customer customer = new Customer("Test Customer");
        // Movie movie = new Movie("Test movie for customer statement fetching", RegularPrice.getInstance());
        // Rental rental = new Rental(movie, daysRented);

        // customer.addRental(rental);

        // String statement = customer.getStatement();
        // boolean expected = statement.contains("Amount owed is " + rental.getCharge());
        // assertTrue(expected);

        // after
        Customer customer = new Customer("Test Customer");
        Rental rental = new RentalBuilder()
                            .withTitle("Test movie for customer statement fetching")
                            .withPrice(RegularPrice.getInstance())
                            .withDaysRented(5)
                            .build();

        customer.addRental(rental);

        String statement = customer.getStatement();
        boolean expected = statement.contains("Amount owed is " + rental.getCharge());
        assertTrue(expected);
    }
}
