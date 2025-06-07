package me.humenius.fowler;

import static junit.framework.TestCase.assertTrue;

import org.junit.Test;

import me.humenius.fowler.prices.RegularPrice;

public class CustomerTest {
    @Test
    public void testGetStatement() {
        int daysRented = 5;
        Customer customer = new Customer("Test Customer");
        Movie movie = new Movie("Test movie for customer statement fetching", RegularPrice.getInstance());
        Rental rental = new Rental(movie, daysRented);

        customer.addRental(rental);

        String statement = customer.getStatement();
        boolean expected = statement.contains("Amount owed is " + rental.getCharge());
        assertTrue(expected);
    }
}